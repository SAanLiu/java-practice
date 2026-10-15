package oop.bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String owner, double initialBalance) {
        super(owner, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 5000) {
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public String getAccountType() {
        return "SavingsAccount";
    }
}