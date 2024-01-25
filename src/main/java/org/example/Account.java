package org.example;

public class Account {
    public void setBalance(int balance) {
        this.balance = balance;
    }

    protected int balance;

    public Account() {
        this.balance = balance;
        this.rate = rate;
    }

    protected int rate;

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }


}
