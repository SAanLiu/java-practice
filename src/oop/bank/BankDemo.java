package oop.bank;

import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount savings = new SavingsAccount("Alice", 1000);
        savings.applyInterest();
        System.out.println(savings.getBalance());
    }
}