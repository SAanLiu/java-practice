package oop.bank;

public class CreditAccount extends BankAccount {
    private final double creditLimit;

    public CreditAccount(String owner, double initialBalance, double creditLimit) {
        super(owner, validateCreditLimit(initialBalance, creditLimit));
        this.creditLimit = creditLimit;
    }

    private static double validateCreditLimit(double initialBalance, double creditLimit) {
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Credit limit cannot be negative");
        }
        return initialBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    protected double getAvailableFunds() {
        return getBalance() + creditLimit;
    }

    @Override
    public String getAccountType() {
        return "CreditAccount";
    }
}