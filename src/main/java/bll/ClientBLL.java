package bll;

import dao.AbstractDAO;
import dao.ClientDAO;
import model.Client;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *  Clasa care face legatura intre Controller si clasa ClientDAO.
 *  Contine operatiile pentru clients.
 */

public class ClientBLL {

    private static ClientDAO clientDAO = new ClientDAO();

    public static Client findClientById(int id){
        Client cl = clientDAO.findById(id,"idClient");
        if (cl == null) {
            throw new NoSuchElementException("Clientul cu id =" + id + " nu a fost gasit !");
        }
        return cl;
    }

    public static void insertClient(Client client){
        clientDAO.insert(client);
    }

    public static List<Client> findClientAll(){
        return clientDAO.findAll();
    }

    public static void deleteClientById(int id){
       clientDAO.delete(id,"idClient");
    }

    public static void updateClientById(Client client ){
        clientDAO.update(client,"idClient");
    }



}
