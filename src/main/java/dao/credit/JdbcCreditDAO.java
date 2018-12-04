package dao.credit;

import dao.Config;
import model.Credit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCreditDAO extends Config implements CreditDAO {
    private Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String ConnectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?autoReconnect=true&useSSL=false&characterEncoding=utf-8";
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(ConnectionString, dbUser, dbPass);

        return dbConnection;

    }
    @Override
    public void saveCredit(Credit credit) {
        PreparedStatement preparedStatement;
        String insert = "INSERT INTO credit(id_client_credit, credit_type, contract_number, " +
                "currency_type, date_begin, date_end, contract_term, credit_sum, credit_percent, " +
                "current_percent) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, credit.getIdClientCredit());
            preparedStatement.setString(2, credit.getCreditType());
            preparedStatement.setInt(3, credit.getContractNumber());
            preparedStatement.setString(4, credit.getCurrencyType());
            preparedStatement.setDate(5, credit.getDateBegin());
            preparedStatement.setDate(6, credit.getDateEnd());
            preparedStatement.setInt(7, credit.getContractTerm());
            preparedStatement.setInt(8, credit.getCreditSum());
            preparedStatement.setInt(9, credit.getCreditPercent());
            preparedStatement.setInt(10, credit.getCurrentPercent());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String selectIdCredit = "select id_credit from credit where contract_number=?";
        ResultSet resultSet;
        int id = 0;
        try{
            preparedStatement = getDbConnection().prepareStatement(selectIdCredit);
            preparedStatement.setInt(1, credit.getContractNumber());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String insertCreditBill = "insert into credit_bill(id_credit_credit_bill, current_credit_sum) values (?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insertCreditBill);
            preparedStatement.setInt(1, id);
            preparedStatement.setFloat(2, 0);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeCredit(Credit credit) {
        int creditSum = credit.getCreditSum();
        int currentPercent = credit.getCurrentPercent();
        float totalSum = creditSum + creditSum*currentPercent/100;
        System.out.println(totalSum);
        deleteCredit(credit);
    }

    @Override
    public void closeBankDay() {
        List<Credit> credits = getAllCredits();
        for (Credit credit : credits) {
            if (credit.getContractTerm() > 0) {
                credit.setContractTerm(credit.getContractTerm() - 1);
                credit.setCurrentPercent(credit.getCurrentPercent() + credit.getCreditPercent());
                updateCredit(credit);
            }
            else closeCredit(credit);
        }
    }

    @Override
    public List<Credit> getAllCredits() {
        List<Credit> credits = new ArrayList<>();
        ResultSet resultSet;
        String getCredits = "SELECT * FROM credit";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(getCredits);
            resultSet = preparedStatement.executeQuery(getCredits);
            while (resultSet.next()){
                Credit credit = getCreditFromDB(resultSet);
                credits.add(credit);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }

    private Credit getCreditFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_credit");
        int idClient = resultSet.getInt("id_client_credit");
        String creditType = resultSet.getString("credit_type");
        int contractNumber = resultSet.getInt("contract_number");
        String currencyType = resultSet.getString("currency_type");
        Date dateBegin = resultSet.getDate("date_begin");
        Date dateEnd = resultSet.getDate("date_end");
        int contractTerm = resultSet.getInt("contract_term");
        int creditSum = resultSet.getInt("credit_sum");
        int creditPercent = resultSet.getInt("credit_percent");
        int currentPercent = resultSet.getInt("current_percent");

        Credit credit = new Credit(idClient, creditType, contractNumber, currencyType,
                dateBegin, dateEnd, contractTerm, creditSum, creditPercent, currentPercent);
        credit.setIdCredit(id);
        return credit;
    }

    @Override
    public void updateCredit(Credit credit) {
        PreparedStatement preparedStatement;
        String update = "update credit set contract_term=?, current_percent=? where id_credit=?";
        try {
            preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setInt(1, credit.getContractTerm());
            preparedStatement.setInt(2, credit.getCurrentPercent());
            preparedStatement.setInt(3, credit.getIdCredit());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String updateBill = "update credit_bill set current_credit_sum=? where id_credit_credit_bill=?";
        try {
            preparedStatement = getDbConnection().prepareStatement(updateBill);
            preparedStatement.setFloat(1, credit.getCreditSum()*credit.getCurrentPercent()/100);
            preparedStatement.setInt(2, credit.getIdCredit());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCredit(Credit credit) {
        String delete = "delete from credit where id_credit=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.setInt(1, credit.getIdCredit());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
