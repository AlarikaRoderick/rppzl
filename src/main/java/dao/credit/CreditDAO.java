package dao.credit;

import model.Credit;

import java.util.List;

public interface CreditDAO {
    void saveCredit(Credit credit);
    void closeCredit(Credit credit);
    void closeBankDay();
    List<Credit> getAllCredits();
    void updateCredit(Credit credit);
    void deleteCredit(Credit credit);
}
