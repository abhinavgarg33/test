package com.test.pojo;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public class Account {

    private double amount;

    private String accountNumber;

    private Branch branch;

    private Client client;


    public Account(Branch branch, String accountNumber, double amount, Client client){
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.client = client;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = this.amount - amount;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
