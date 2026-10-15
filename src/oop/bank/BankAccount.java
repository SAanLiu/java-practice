package oop.bank;

public class BankAccount {
    public String owner;
    public double balance;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}

