package oop.bank;

public abstract class BankAccount {
    private static int createdCount = 0;

    private final int accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String owner) {
        this(owner, 0);
    }

    public BankAccount(String owner, double initialBalance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner cannot be null or blank");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = ++createdCount;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    protected double getAvailableFunds() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > getAvailableFunds()) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return createdCount;
    }

    public abstract String getAccountType();

    @Override
    public String toString() {
        return "BankAccount{type='" + getAccountType()
                + "', accountNumber=" + accountNumber
                + ", owner='" + owner
                + "', balance=" + balance + "}";
    }
}