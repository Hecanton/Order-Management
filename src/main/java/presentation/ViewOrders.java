package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;

/**
 *  Interfata grafica cu utilizatorul pentru tabelul Orders.
 */

public class ViewOrders extends JFrame {
    private JTextField insertId     = new JTextField(2);
    private JTextField insertProductId     = new JTextField(2);
    private JTextField insertClientId     = new JTextField(2);
    private JTextField insertQuantity     = new JTextField(10);


    private JButton    insertBtn = new JButton("Order");
    private JButton    listBtn = new JButton("ListAll");



    JTable table;
    JScrollPane scrollPane = new JScrollPane();
    String [] col = {"idOrder","idProduct","IdClient","Quantity"};
    String [][] row ={{"","","","",""}};

    public ViewOrders(){
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

        content2.add(new JLabel("Order ID"));
        content2.add(insertId);
        content2.add(new JLabel("Client ID"));
        content2.add(insertProductId);
        content2.add(new JLabel("Product ID"));
        content2.add(insertClientId);
        content2.add(new JLabel("Quantity"));
        content2.add(insertQuantity);

        JLabel productsLabel = new JLabel("Orders TABLE",JLabel.CENTER);
        productsLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        content4.add(productsLabel);
        content5.add(insertBtn);

        content7.add(listBtn);

        updateTable();

        content8.add(scrollPane);

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

        this.setTitle("Orders View");
    }

    public void updateTable(){
        table=new JTable(row,col);
        table.setPreferredScrollableViewportSize(new Dimension(500,65) );
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(table);
    }
    public String getIdInput() { return insertId.getText();}
    public String getProductIdInput() { return insertProductId.getText();}
    public String getClientIdInput() { return insertClientId.getText(); }
    public String getQuantityInput() { return insertQuantity.getText();}

    public void setCol(String[] col){
        this.col=col;
    }
    public void setRow(String[][] row){
        this.row=row;
    }

    public void addInsertOrdersListener(ActionListener actionListener){
        insertBtn.addActionListener(actionListener);
    }

    public void addFindALLOrdersListener(ActionListener actionListener) {
        listBtn.addActionListener(actionListener);
    }


}
