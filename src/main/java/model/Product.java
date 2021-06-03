package model;

/**
 *  Clasa cu campurile tabelulului Product din baza de date.
 */

public class Product {
    private int idProduct;
    private String productName;
    private float price;
    private int quantity;

    public Product(int id, String productName, float price, int quantity) {
        this.idProduct = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(){
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int id) {
        this.idProduct = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
