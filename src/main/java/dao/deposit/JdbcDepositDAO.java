package dao.deposit;

import dao.Config;
import model.Deposit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDepositDAO extends Config implements DepositDAO{
    private Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String ConnectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?autoReconnect=true&useSSL=false&characterEncoding=utf-8";
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(ConnectionString, dbUser, dbPass);

        return dbConnection;

    }
    @Override
    public void saveDeposit(Deposit deposit) {
        String insert = "INSERT INTO deposit(id_client_deposit, deposit_type, contract_number, " +
                "currency_type, date_begin, date_end, contract_term, deposit_sum, deposit_percent, current_percent) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, deposit.getIdClientDeposit());
            preparedStatement.setString(2, deposit.getDepositType());
            preparedStatement.setInt(3, deposit.getContactNumber());
            preparedStatement.setString(4, deposit.getCurrencyType());
            preparedStatement.setDate(5, deposit.getDateBegin());
            preparedStatement.setDate(6, deposit.getDateEnd());
            preparedStatement.setInt(7, deposit.getContractTerm());
            preparedStatement.setInt(8, deposit.getDepositSum());
            preparedStatement.setInt(9, deposit.getDepositPercent());
            preparedStatement.setInt(10, deposit.getCurrentPercent());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeDeposit(Deposit deposit) {

    }

    @Override
    public void closeBankDay() {
        List<Deposit> deposits = getAllDeposits();
        for (Deposit deposit : deposits) {
            if (deposit.getContractTerm() > 0) {
                deposit.setContractTerm(deposit.getContractTerm() - 1);
                deposit.setCurrentPercent(deposit.getCurrentPercent() + deposit.getDepositPercent());
                updateDeposit(deposit);
            }
        }
    }

    @Override
    public List<Deposit> getAllDeposits() {
        List<Deposit> deposits = new ArrayList<>();
        ResultSet resultSet;
        String getDeposits = "SELECT * FROM deposit";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(getDeposits);
            resultSet = preparedStatement.executeQuery(getDeposits);
            while (resultSet.next()){
                Deposit deposit = getDepositFromDB(resultSet);
                deposits.add(deposit);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deposits;
    }

    @Override
    public void updateDeposit(Deposit deposit) {
        String update = "update deposit set contract_term=?, current_percent=? where id_deposit=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setInt(1, deposit.getContractTerm());
            preparedStatement.setInt(2, deposit.getCurrentPercent());
            preparedStatement.setInt(3, deposit.getIdDeposit());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Deposit getDepositFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_deposit");
        int idClient = resultSet.getInt("id_client_deposit");
        String depositType = resultSet.getString("deposit_type");
        int contractNumber = resultSet.getInt("contract_number");
        String currencyType = resultSet.getString("currency_type");
        Date dateBegin = resultSet.getDate("date_begin");
        Date dateEnd = resultSet.getDate("date_end");
        int contractTerm = resultSet.getInt("contract_term");
        int depositSum = resultSet.getInt("deposit_sum");
        int depositPercent = resultSet.getInt("deposit_percent");
        int currentPercent = resultSet.getInt("current_percent");

        Deposit deposit = new Deposit(idClient, depositType, contractNumber, currencyType,
                dateBegin, dateEnd, contractTerm, depositSum, depositPercent, currentPercent);
        deposit.setIdDeposit(id);
        return deposit;

    }
}
