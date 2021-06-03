package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;

/**
 *  Interfata grafica cu utilizatorul pentru tabelul Product.
 */

public class ViewProduct extends JFrame {
    private JTextField insertId     = new JTextField(2);
    private JTextField insertProductName = new JTextField(7);
    private JTextField insertPrice = new JTextField(10);
    private JTextField insertQuantity     = new JTextField(10);
    private JTextField insertSearchID     = new JTextField(2);

    private JButton    insertBtn = new JButton("Insert");
    private JButton    updateBtn    = new JButton("Update");
    private JButton    deleteBtn = new JButton("Delete");
    private JButton    listBtn = new JButton("ListAll");
    private JButton    listByIDBtn = new JButton("ListByID");


    JTable table;
    JScrollPane scrollPane = new JScrollPane();
    String [] col = {"idProduct","Name","Price","Quantity"};
    String [][] row ={{"","","","",""}};

    public ViewProduct(){
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(100,70));
        add (content);

        JPanel content2=new JPanel();
        JPanel content3=new JPanel();
        JPanel content4=new JPanel();
        JPanel content5=new JPanel();

        JPanel content6=new JPanel();
        JPanel content7=new JPanel();
        JPanel content8=new JPanel();
        JPanel content9=new JPanel();

        content3.setLayout(new BorderLayout(10,10));
        content2.setLayout(new FlowLayout());
        content4.setLayout(new FlowLayout());
        content5.setLayout(new FlowLayout());

        content6.setLayout(new BorderLayout(10,10));
        content7.setLayout(new FlowLayout());
        content8.setLayout(new FlowLayout());
        content9.setLayout(new FlowLayout());

        content2.add(new JLabel("ID"));
        content2.add(insertId);
        content2.add(new JLabel("Name"));
        content2.add(insertProductName);
        content2.add(new JLabel("Price"));
        content2.add(insertPrice);
        content2.add(new JLabel("Quantity"));
        content2.add(insertQuantity);

        JLabel productsLabel = new JLabel("PRODUCTS TABLE",JLabel.CENTER);
        productsLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        content4.add(productsLabel);
        content5.add(insertBtn);
        content5.add(updateBtn);


        content7.add(new JLabel("ID="));
        content7.add(insertSearchID);
        content8.add(listBtn);
        content8.add(deleteBtn);
        content8.add(listByIDBtn);
        updateTable();


        content9.add(scrollPane);

        content3.add(content4,"North");
        content3.add(content2,"Center");
        content3.add(content5,"South");

        content6.add(content7,"North");
        content6.add(content8,"Center");
        content6.add(content9,"South");


        content.add(content3,"North");
        content.add(content6,"Center");


        this.setLocation(500,200);
        this.setContentPane(content);
        this.setSize(1000,10000);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setTitle("Products View");
    }

    public void updateTable(){
        table=new JTable(row,col);
        table.setPreferredScrollableViewportSize(new Dimension(500,65) );
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(table);
    }
    public String getIdInput() { return insertId.getText();}
    public String getProductNameInput() { return insertProductName.getText();}
    public String getPriceInput() { return insertPrice.getText(); }
    public String getQuantityInput() { return insertQuantity.getText();}
    public String getIdSearchInput(){ return insertSearchID.getText();}

    public void setCol(String[] col){
        this.col=col;
    }
    public void setRow(String[][] row){
        this.row=row;
    }

    public void addInsertProductListener(ActionListener actionListener){
        insertBtn.addActionListener(actionListener);
    }

    public void addFindALLProductsListener(ActionListener actionListener) {
        listBtn.addActionListener(actionListener);
    }

    public void addFindProductsByIDListener(ActionListener actionListener){
        listByIDBtn.addActionListener(actionListener);
    }

    public void addUpdateProductListener(ActionListener actionListener){
        updateBtn.addActionListener(actionListener);
    }

    public void addDeleteProductByIdListener(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }

}
