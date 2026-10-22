package oop.bank;

import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("Alice", 10000));
        accounts.add(new CreditAccount("Bob", 4000, 3000));

        for (BankAccount account : accounts) {
            try {
                account.withdraw(6000);
                System.out.println("Withdrawal succeeded.");
            } catch (InsufficientFundsException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(account);
        }

        for (BankAccount account : accounts) {
            double balanceBefore = account.getBalance();

            if (account instanceof InterestBearing ib) {
                ib.applyInterest();
            }

            System.out.println("Account " + account.getAccountNumber()
                    + " balance after interest: "
                    + balanceBefore + " -> " + account.getBalance());
        }
    }
}