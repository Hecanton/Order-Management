package bll;
import dao.ClientDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
import model.Client;
import model.Orders;
import model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 *  Clasa care face legatura intre Controller si clasa OrdersDAO.
 *  Contine operatiile pentru orders.
 */

public class OrdersBLL {

    private static OrdersDAO ordersDAO = new OrdersDAO();

    public static List<Orders> findOrdersAll(){
        return ordersDAO.findAll();
    }

    public static void insertOrders(Orders or){
        Product product = new ProductDAO().findById(or.getIdProduct(),"idProduct");
        if(product==null)
            return;
        Client client = new ClientDAO().findById(or.getIdClient(),"idClient");
        if(client==null)
            return;
        if(product.getQuantity()<or.getQuantity())
            return;
        else
            product.setQuantity(product.getQuantity()-or.getQuantity());
        createBill(product,or,client);
        new ProductDAO().update(product,"idProduct");
        new OrdersDAO().insert(or);
    }

    public static void createBill( Product product,Orders orders,Client client)  {

        System.out.println(orders.getQuantity());
        System.out.println(product.getProductName());
        System.out.println(client.getName());
        String textBill =" Order id="+orders.getIdOrder()+"\n Client Name="+client.getName()+"\n Product Name="
                            +product.getProductName() +"\n Quantity="+orders.getQuantity();
        try {
            FileWriter fileWriter = new FileWriter("BillNumber"+orders.getIdOrder()+".txt");
            fileWriter.write(textBill);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
