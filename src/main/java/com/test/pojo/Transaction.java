package com.test.pojo;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public class Transaction {

    private Account payee;

    private int amount;

    private Account payeer;

    private TransactionType transactionType;

    public Transaction(Account payee, int amount, Account payeer, TransactionType transactionType){
        this.payee = payee;
        this.amount = amount;
        this.payeer = payeer;
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account getPayee() {
        return payee;
    }

    public void setPayee(Account payee) {
        this.payee = payee;
    }

    public Account getPayeer() {
        return payeer;
    }

    public void setPayeer(Account payeer) {
        this.payeer = payeer;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
