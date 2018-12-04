package dao.client;


import dao.Config;
import dao.Const;
import dao.client.ClientDAO;
import model.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcClientDAO extends Config implements ClientDAO {
    private Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String ConnectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?autoReconnect=true&useSSL=false&characterEncoding=utf-8";
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(ConnectionString, dbUser, dbPass);

        return dbConnection;

    }

    public void saveClient(Client client) {
        String insert = "INSERT INTO " + Const.CLIENT_TABLE + "(" + Const.CLIENT_FIRSTNAME + "," +
                Const.CLIENT_LASTNAME + "," + Const.CLIENT_PATRONYMIC + "," + Const.CLIENT_BIRTHDATE + "," +
                Const.CLIENT_GENDER + "," + Const.CLIENT_PASSPORTSERIES + "," + Const.CLIENT_PASSPORTNUMBER + "," +
                Const.CLIENT_PASSPORTISSUE + "," + Const.CLIENT_DATEISSUE + "," + Const.CLIENT_IDENTICALNUMBER + "," +
                Const.CLIENT_BIRTHPLACE + "," + Const.CLIENT_LIVINGCITY + "," + Const.CLIENT_PHONEHOMENUMBER + "," +
                Const.CLIENT_PHONENUMBER + "," + Const.CLIENT_EMAIL + "," + Const.CLIENT_MARITALSTATUS + "," +
                Const.CLIENT_CITIZENSHIP + "," + Const.CLIENT_DISABILITY + "," + Const.CLIENT_PENSIONER + "," +
                Const.CLIENT_MONTHLYINCOME + "," + Const.CLIENT_MILITARY + ")" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            setClientInfo(insert, client);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        int id = client.getId();
        String update = "UPDATE " + Const.CLIENT_TABLE + " SET " + Const.CLIENT_FIRSTNAME + "=?, " +
                Const.CLIENT_LASTNAME + "=?, " + Const.CLIENT_PATRONYMIC + "=?, " + Const.CLIENT_BIRTHDATE + "=?, " +
                Const.CLIENT_GENDER + "=?, " + Const.CLIENT_PASSPORTSERIES + "=?, " + Const.CLIENT_PASSPORTNUMBER + "=?, " +
                Const.CLIENT_PASSPORTISSUE + "=?, " + Const.CLIENT_DATEISSUE + "=?, " + Const.CLIENT_IDENTICALNUMBER + "=?, " +
                Const.CLIENT_BIRTHPLACE + "=?, " + Const.CLIENT_LIVINGCITY + "=?, " + Const.CLIENT_PHONEHOMENUMBER + "=?, " +
                Const.CLIENT_PHONENUMBER + "=?, " + Const.CLIENT_EMAIL + "=?, " + Const.CLIENT_MARITALSTATUS + "=?, " +
                Const.CLIENT_CITIZENSHIP + "=?, " + Const.CLIENT_DISABILITY + "=?, " + Const.CLIENT_PENSIONER + "=?, " +
                Const.CLIENT_MONTHLYINCOME + "=?, " + Const.CLIENT_MILITARY + "=?" + "WHERE " + Const.CLIENT_ID + "=" + id;
        try{
            setClientInfo(update, client);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void setClientInfo(String sqlString, Client client) throws SQLException, ClassNotFoundException{
        PreparedStatement prSt = getDbConnection().prepareStatement(sqlString);
        prSt.setString(1, client.getFirstName());
        prSt.setString(2, client.getLastName());
        prSt.setString(3, client.getPatronymic());
        prSt.setString(4, client.getBirthDate().toString());
        prSt.setString(5, client.getGender());
        prSt.setString(6, client.getPassportSeries());
        prSt.setString(7, client.getPassportNumber());
        prSt.setString(8, client.getPassportIssue());
        prSt.setString(9, client.getDateIssue().toString());
        prSt.setString(10, client.getIdenticalNumber());
        prSt.setString(11, client.getBirthPlace());
        prSt.setString(12, client.getLivingCity());
        prSt.setString(13, client.getPhoneHomeNumber());
        prSt.setString(14, client.getPhoneNumber());
        prSt.setString(15, client.getEmail());
        prSt.setString(16, client.getMaritalStatus());
        prSt.setString(17, client.getCitizenship());
        prSt.setString(18, client.getDisability());
        prSt.setString(19, client.getPensioner());
        prSt.setString(20, client.getMonthlyIncome());
        prSt.setString(21, client.getMilitary());
        prSt.executeUpdate();

    }

    public void deleteClient(int id) {
        String delete = "DELETE FROM " + Const.CLIENT_TABLE + " WHERE idClient=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.setString(1, Integer.toString(id));
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public List<Client> findAllClients() {
        ResultSet resultSet = null;
        List<Client> clients = new ArrayList<>();
        String selectAllClients = "SELECT * FROM " + Const.CLIENT_TABLE;
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(selectAllClients);
            resultSet = preparedStatement.executeQuery(selectAllClients);

            while (resultSet.next()){
                Client client = getClientFromDB(resultSet);
                clients.add(client);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return clients;
    }

    public ResultSet findClient(String firstName, String lastName) {
        ResultSet resultSet = null;
        String find = "SELECT idClient FROM " + Const.CLIENT_LASTNAME + "=? AND " + Const.CLIENT_FIRSTNAME + "=?";
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(find);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            resultSet = preparedStatement.executeQuery();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Client getClient(int id) {
        ResultSet resultSet = null;
        String idClient = Integer.toString(id);
        String find = "SELECT * FROM " + Const.CLIENT_TABLE + " WHERE " + Const.CLIENT_ID + "=?";
        Client client = null;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(find);
            prSt.setString(1, idClient);
            resultSet = prSt.executeQuery();
            while(resultSet.next()){
                client = getClientFromDB(resultSet);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public boolean isSuchClientExist(Client client) {
        boolean isSuchClient = false;
        List<Client> allClients = findAllClients();
        for (Client checkClient : allClients) {
            if(checkClient.equals(client))
                isSuchClient = true;
        }
        return isSuchClient;
    }

    @Override
    public boolean isSuchPassportNumberExist(Client client) {
        boolean isSuchPassportNumber = false;
        List<Client> allClients = findAllClients();
        for (Client check : allClients) {
            if(check.getPassportNumber().equals(client.getPassportNumber()))
                isSuchPassportNumber = true;
        }
        return isSuchPassportNumber;
    }

    @Override
    public boolean isSuchIdenticalNumberExist(Client client) {
        boolean isSuchIsenticalNumber = false;
        List<Client> allClients = findAllClients();
        for (Client check : allClients) {
            if(check.getIdenticalNumber().equals(client.getIdenticalNumber()))
                isSuchIsenticalNumber = true;
        }
        return isSuchIsenticalNumber;
    }


    private Client getClientFromDB(ResultSet resultSet) throws SQLException {
        int id = Integer.valueOf(resultSet.getString(1));
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String patronymic = resultSet.getString(4);
        LocalDate birthDate = LocalDate.parse(resultSet.getString(5));
        String gender = resultSet.getString(6);
        String passportSeries = resultSet.getString(7);
        String passportNumber = resultSet.getString(8);
        String passportIssue = resultSet.getString(9);
        LocalDate dateIssue = LocalDate.parse(resultSet.getString(10));
        String identicalNumber = resultSet.getString(11);
        String birthPlace = resultSet.getString(12);
        String livingCity = resultSet.getString(13);
        String phoneHomeNumber = resultSet.getString(14);
        String phoneNumber = resultSet.getString(15);
        String email = resultSet.getString(16);
        String maritalStatus = resultSet.getString(17);
        String citizenship = resultSet.getString(18);
        String disability = resultSet.getString(19);
        String pensioner = resultSet.getString(20);
        String monthlyIncome = resultSet.getString(21);
        String military = resultSet.getString(22);

        Client client = new Client(firstName, lastName, patronymic, birthDate, gender, passportSeries, passportNumber, passportIssue,
                dateIssue, identicalNumber, birthPlace, livingCity, phoneHomeNumber, phoneNumber, email, maritalStatus, citizenship,
                disability, pensioner, monthlyIncome, military);
        client.setId(id);
        return client;
    }
}