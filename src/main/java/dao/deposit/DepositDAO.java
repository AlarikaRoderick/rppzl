package dao.deposit;

import model.Deposit;

import java.util.List;

public interface DepositDAO {
    void saveDeposit(Deposit deposit);
    void closeDeposit(Deposit deposit);
    void closeBankDay();
    List<Deposit> getAllDeposits();
    void updateDeposit(Deposit deposit);
    void deleteDeposit(Deposit deposit);
}
