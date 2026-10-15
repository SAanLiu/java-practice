package oop.bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String owner, double initialBalance) {
        super(owner, initialBalance);
    }

    @Override
    protected double getAvailableFunds() {
        return Math.min(getBalance(), 5000);
    }

    @Override
    public String getAccountType() {
        return "SavingsAccount";
    }
}