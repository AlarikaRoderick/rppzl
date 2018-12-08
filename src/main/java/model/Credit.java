package model;

import java.sql.Date;

public class Credit {
    private int idCredit;
    private int idClientCredit;
    private String creditType;
    private int contractNumber;
    private String currencyType;
    private Date dateBegin;
    private Date dateEnd;
    private int contractTerm;
    private int creditSum;
    private int creditPercent;
    private int currentPercent;
    public static int fondSum = 100000000;

    public Credit() {
    }

    public Credit(int idClientCredit, String creditType, int contractNumber, String currencyType,
                  Date dateBegin, Date dateEnd, int contractTerm, int creditSum, int creditPercent,
                  int currentPercent) {
        this.idClientCredit = idClientCredit;
        this.creditType = creditType;
        this.contractNumber = contractNumber;
        this.currencyType = currencyType;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.contractTerm = contractTerm;
        this.creditSum = creditSum;
        this.creditPercent = creditPercent;
        this.currentPercent = currentPercent;
    }

    public int getFondSum() {
        return fondSum;
    }

    public void setFondSum(int fondSum) {
        Credit.fondSum = fondSum;
    }

    public int getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public int getIdClientCredit() {
        return idClientCredit;
    }

    public void setIdClientCredit(int idClientCredit) {
        this.idClientCredit = idClientCredit;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
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

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }

    public int getCreditPercent() {
        return creditPercent;
    }

    public void setCreditPercent(int creditPercent) {
        this.creditPercent = creditPercent;
    }

    public int getCurrentPercent() {
        return currentPercent;
    }

    public void setCurrentPercent(int currentPercent) {
        this.currentPercent = currentPercent;
    }
}
