package oop.bank;

public class CreditAccount extends BankAccount {
    private final double creditLimit;

    public CreditAccount(String owner, double initialBalance, double creditLimit) {
        super(owner, initialBalance);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance + creditLimit) {
            return false;
        }
        balance -= amount;
        return true;
    }
}