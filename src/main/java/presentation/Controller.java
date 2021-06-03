package presentation;
import bll.ClientBLL;
import bll.OrdersBLL;
import bll.ProductBLL;
import model.Client;
import model.Orders;
import model.Product;

import java.awt.event.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 *  Clasa ce ofera functionalitatiile interfetei grafice.
 */

public class Controller {
    private ViewClient viewClient;
    private ViewProduct viewProduct;
    private ViewOrders viewOrders;
    public Controller(ViewClient view ,ViewProduct viewP ,ViewOrders viewO){
        viewClient=view;
        viewProduct=viewP;
        viewOrders=viewO;

       viewClient.addInsertClientListener(new InsertClientListener());
       viewClient.addFindALLClientsListener(new FindAllClientsListener());
       viewClient.addFindClientsByIDListener(new FindClientsByIDListener());
       viewClient.addDeleteByIdListener(new DeleteByIdListener());
       viewClient.addUpdateClientListener(new UpdateClientListener());

       viewProduct.addFindALLProductsListener(new FindALLProductsListener());
       viewProduct.addFindProductsByIDListener(new FindProductsByIDListener());
       viewProduct.addUpdateProductListener(new UpdateProductListener());
       viewProduct.addDeleteProductByIdListener(new DeleteProductByIdListener());
       viewProduct.addInsertProductListener(new InsertProductListener());

       viewOrders.addFindALLOrdersListener(new FindALLOrdersListener());
       viewOrders.addInsertOrdersListener(new InsertOrdersListener());
    }

    public void tableUpdate(List<Object> tab){

        if(tab.size()==0){
            viewClient.setRow(new String[0][0]);
            viewClient.setCol(new String[0]);
        }else{
            Field[] fields=tab.get(0).getClass().getDeclaredFields();
            String[] col=new String[fields.length];
            for(int i=0;i<fields.length;i++){
                col[i]=fields[i].getName();
            }
            String[][] row=new String[tab.size()][fields.length];
            for(int i=0;i<row.length;i++){
                for(int j=0;j<fields.length;j++){
                    fields[j].setAccessible(true);
                    try{
                        row[i][j]=fields[j].get(tab.get(i)).toString();
                    }
                    catch(IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
            }
            viewClient.setCol(col);
            viewClient.setRow(row);
        }
        viewClient.updateTable();
    }
    public void tableProductsUpdate(List<Object> tab){

        if(tab.size()==0){
            viewProduct.setRow(new String[0][0]);
            viewProduct.setCol(new String[0]);
        }else{
            Field[] fields=tab.get(0).getClass().getDeclaredFields();
            String[] col=new String[fields.length];
            for(int i=0;i<fields.length;i++){
                col[i]=fields[i].getName();
            }
            String[][] row=new String[tab.size()][fields.length];
            for(int i=0;i<row.length;i++){
                for(int j=0;j<fields.length;j++){
                    fields[j].setAccessible(true);
                    try{
                        row[i][j]=fields[j].get(tab.get(i)).toString();
                    }
                    catch(IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
            }
            viewProduct.setCol(col);
            viewProduct.setRow(row);
        }
        viewProduct.updateTable();
    }

    public void tableOrdersUpdate(List<Object> tab){

        if(tab.size()==0){
            viewOrders.setRow(new String[0][0]);
            viewOrders.setCol(new String[0]);
        }else{
            Field[] fields=tab.get(0).getClass().getDeclaredFields();
            String[] col=new String[fields.length];
            for(int i=0;i<fields.length;i++){
                col[i]=fields[i].getName();
            }
            String[][] row=new String[tab.size()][fields.length];
            for(int i=0;i<row.length;i++){
                for(int j=0;j<fields.length;j++){
                    fields[j].setAccessible(true);
                    try{
                        row[i][j]=fields[j].get(tab.get(i)).toString();
                    }
                    catch(IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
            }
            viewOrders.setCol(col);
            viewOrders.setRow(row);
        }
        viewOrders.updateTable();
    }


    class  InsertClientListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = parseInt(viewClient.getIdInput());
            System.out.println(viewClient.getNameInput());
            Client client = new Client(id,viewClient.getNameInput(),viewClient.getAddressInput(),viewClient.getAgeInput(),viewClient.getEmailInput());
            ClientBLL.insertClient(client);
        }
    }

    class FindAllClientsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            List<Object> list=new ArrayList<>();
            list.addAll(ClientBLL.findClientAll());
            tableUpdate(list);
        }
    }

    class FindClientsByIDListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            List<Object> list = new ArrayList<>();
            int id=parseInt(viewClient.getIdSearchInput());
            list.add(ClientBLL.findClientById(id));
            tableUpdate(list);
        }
    }

    class DeleteByIdListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id=parseInt(viewClient.getIdSearchInput());
            ClientBLL.deleteClientById(id);
        }
    }

    class UpdateClientListener implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = parseInt(viewClient.getIdInput());
            Client client = new Client(id,viewClient.getNameInput(),viewClient.getAddressInput(),viewClient.getAgeInput(),viewClient.getEmailInput());
            ClientBLL.updateClientById(client);
        }
    }

    class FindALLProductsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            List<Object> list=new ArrayList<>();
            list.addAll(ProductBLL.findProductsAll());
            tableProductsUpdate(list);
        }
    }

    class FindProductsByIDListener implements  ActionListener{
        public void actionPerformed(ActionEvent e){

            List<Object> list = new ArrayList<>();
            int id=parseInt(viewProduct.getIdSearchInput());
            list.add(ProductBLL.findProductById(id));
            tableProductsUpdate(list);
        }
    }

    class UpdateProductListener implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = parseInt(viewProduct.getIdInput());
            int quant=parseInt(viewProduct.getQuantityInput());
            Float price= Float.parseFloat(viewProduct.getPriceInput());
            Product product = new Product(id,viewProduct.getProductNameInput(),price,quant);
            ProductBLL.updateProductById(product);
        }
    }

    class DeleteProductByIdListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id=parseInt(viewProduct.getIdSearchInput());
            ProductBLL.deleteProductById(id);
        }
    }

    class  InsertProductListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = parseInt(viewProduct.getIdInput());
            int quantity= parseInt(viewProduct.getQuantityInput());
            Float price = Float.parseFloat(viewProduct.getPriceInput());
            Product product = new Product(id,viewProduct.getProductNameInput(),price,quantity);
            ProductBLL.insertProduct(product);
        }
    }

    class FindALLOrdersListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            List<Object> list=new ArrayList<>();
            list.addAll(OrdersBLL.findOrdersAll());
            tableOrdersUpdate(list);
        }
    }

    class  InsertOrdersListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = parseInt(viewOrders.getIdInput());
            int idC = parseInt(viewOrders.getClientIdInput());
            int idO = parseInt(viewOrders.getProductIdInput());
            int quantity= parseInt(viewOrders.getQuantityInput());
            Orders order = new Orders(id,idO,idC,quantity);
            OrdersBLL.insertOrders(order);
        }
    }

}
