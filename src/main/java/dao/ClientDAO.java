package dao;

import model.Client;

import java.sql.ResultSet;
import java.util.List;

public interface ClientDAO {
    void saveClient(Client client);
    void updateClient(Client client);
    void deleteClient(int id);
    List<Client> findAllClients();
    ResultSet findClient(String firstName, String lastName);
    Client getClient(int id);
    boolean isSuchClientExist(Client client);
    boolean isSuchPassportNumberExist(Client client);
    boolean isSuchIdenticalNumberExist(Client client);
}
