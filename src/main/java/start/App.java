package start;

import connection.ConnectionFactory;
import presentation.Controller;
import presentation.ViewClient;
import presentation.ViewOrders;
import presentation.ViewProduct;

import javax.swing.text.View;
import java.sql.Connection;

import static connection.ConnectionFactory.getConnection;

/**
 * Contine metoda Main
 *
 */
public class App
{
    public static void main( String[] args ) {

        ViewClient view = new ViewClient();
        ViewOrders viewOrders = new ViewOrders();
        ViewProduct viewProduct = new ViewProduct();
        Controller controller = new Controller(view, viewProduct,viewOrders);
        view.setVisible(true);
        viewProduct.setVisible(true);
        viewOrders.setVisible(true);

    }
}
