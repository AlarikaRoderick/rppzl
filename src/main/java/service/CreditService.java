package service;

import dao.credit.JdbcCreditDAO;
import model.Credit;

import java.util.List;

public class CreditService {
    private JdbcCreditDAO creditDAO = new JdbcCreditDAO();

    public CreditService(){}

    public void saveCredit(Credit credit){
        creditDAO.saveCredit(credit);
    }

    public List<Credit> getAllCredits(){
        return creditDAO.getAllCredits();
    }

    public void closeBankDay(){
        creditDAO.closeBankDay();
    }
}
