package model;

import java.sql.Date;

public class Deposit {
    private int idDeposit;
    private int idClientDeposit;
    private String depositType;
    private int contactNumber;
    private String currencyType;
    private Date dateBegin;
    private Date dateEnd;
    private int contractTerm;
    private int depositSum;
    private int depositPercent;
    private int currentPercent;
    public static int fondSum = 100000000;

    public Deposit() {
    }

    public Deposit(int idClientDeposit, String depositType, int contactNumber,
                   String currencyType, Date dateBegin, Date dateEnd, int contractTerm,
                   int depositSum, int depositPercent, int currentPercent) {
        this.idClientDeposit = idClientDeposit;
        this.depositType = depositType;
        this.contactNumber = contactNumber;
        this.currencyType = currencyType;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.contractTerm = contractTerm;
        this.depositSum = depositSum;
        this.depositPercent = depositPercent;
        this.currentPercent = currentPercent;
    }

    public int getFondSum() {
        return fondSum;
    }

    public void setFondSum(int fondSum) {
        this.fondSum = fondSum;
    }

    public int getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(int idDeposit) {
        this.idDeposit = idDeposit;
    }

    public int getIdClientDeposit() {
        return idClientDeposit;
    }

    public void setIdClientDeposit(int idClientDeposit) {
        this.idClientDeposit = idClientDeposit;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(int contractTerm) {
        this.contractTerm = contractTerm;
    }

    public int getDepositSum() {
        return depositSum;
    }

    public void setDepositSum(int depositSum) {
        this.depositSum = depositSum;
    }

    public int getDepositPercent() {
        return depositPercent;
    }

    public void setDepositPercent(int depositPercent) {
        this.depositPercent = depositPercent;
    }

    public int getCurrentPercent() {
        return currentPercent;
    }

    public void setCurrentPercent(int currentPercent) {
        this.currentPercent = currentPercent;
    }
}
