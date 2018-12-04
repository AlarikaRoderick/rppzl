package service;

import dao.deposit.JdbcDepositDAO;
import model.Deposit;

import java.util.List;

public class DepositService {
    private JdbcDepositDAO depositDAO = new JdbcDepositDAO();

    public DepositService(){}

    public void saveDeposit(Deposit deposit){
        depositDAO.saveDeposit(deposit);
    }

    public List<Deposit> getAllDeposits(){
        return depositDAO.getAllDeposits();
    }

    public void closeBankDay(){
        depositDAO.closeBankDay();
    }
}
