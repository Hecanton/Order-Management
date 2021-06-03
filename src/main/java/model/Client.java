package model;

/**
 *  Clasa cu campurile tabelulului Client din baza de date.
 */

public class Client {
    private int idClient;
    private String name;
    private String address;
    private String age;
    private String email;

    public Client(int id, String Name , String address, String age, String email) {
        this.idClient = id;
        this.name = Name;
        this.address = address;
        this.age = age;
        this.email = email;
    }

    public Client(){

    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int id) {
        this.idClient = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}