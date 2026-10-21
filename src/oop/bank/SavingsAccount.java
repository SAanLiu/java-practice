package oop.bank;

public class SavingsAccount extends BankAccount implements InterestBearing {
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

    private static final double ANNUAL_INTEREST_RATE = 0.015;

    @Override
    public void applyInterest() {
        double interest = getBalance() * ANNUAL_INTEREST_RATE;
        if (interest > 0) {
            deposit(interest);
        }
    }
}