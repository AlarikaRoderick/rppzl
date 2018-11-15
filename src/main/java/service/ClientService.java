package service;

import dao.JdbcClientDAO;
import model.Client;

import java.sql.ResultSet;
import java.util.List;

public class ClientService {
    private JdbcClientDAO clientDAO = new JdbcClientDAO();

    public ClientService(){}

    public Client getClient(int id){
        return clientDAO.getClient(id);
    }

    public void saveClient(Client client){
        clientDAO.saveClient(client);
    }

    public void deleteClient(int id){
        clientDAO.deleteClient(id);
    }

    public void updateClient(Client client){
        clientDAO.updateClient(client);
    }

    public List<Client> findAllClients() {
        return clientDAO.findAllClients();
    }

    public boolean isSuchClientExist(Client client) {
        return clientDAO.isSuchClientExist(client);
    }

    public boolean isSuchPassportNumberExist(Client client){
        return clientDAO.isSuchPassportNumberExist(client);
    }

    public boolean isSuchIdenticalNumberExist(Client client) {
        return clientDAO.isSuchIdenticalNumberExist(client);
    }
}
