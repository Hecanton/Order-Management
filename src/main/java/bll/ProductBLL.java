package bll;

import dao.ProductDAO;
import model.Client;
import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *  Clasa care face legatura intre Controller si clasa ProductDAO.
 *  Contine operatiile pentru products.
 */

public class ProductBLL {
    private static ProductDAO productDAO = new ProductDAO();

    public static Product findProductById(int id){
        Product pr = productDAO.findById(id,"idProduct");
        if (pr == null) {
            throw new NoSuchElementException("Produsul cu id =" + id + " nu a fost gasit !");
        }
        return pr;
    }

    public static void updateProductById(Product product ){
        productDAO.update(product,"idProduct");
    }

    public static void deleteProductById(int id){
        productDAO.delete(id,"idProduct");
    }

    public static void insertProduct(Product pr){
        productDAO.insert(pr);
    }

    public static List<Product> findProductsAll(){
        return productDAO.findAll();
    }

}
