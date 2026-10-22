package oop.bank;

import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) throws InsufficientFundsException {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("Alice", 10000));
        accounts.add(new CreditAccount("Bob", 4000, 3000));

        for (BankAccount account : accounts) {
            try {
                account.withdraw(6000);
                System.out.println("Withdrawal succeeded.");
            } catch (InsufficientFundsException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Transaction finished.");
            }

            System.out.println(account);
        }

        SavingsAccount failingAccount = new SavingsAccount("Charlie", 10000);
        failingAccount.withdraw(6000);
    }
}