package oop.bank;

import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Alice", 1000);
        System.out.println(savings.interestPolicy());
    }
}