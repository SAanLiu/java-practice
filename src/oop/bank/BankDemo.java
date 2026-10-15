package oop.bank;

public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Alice", 1000);
        CreditAccount credit = new CreditAccount("Bob", 500, 3000);

        System.out.println(savings.getBalance());
        System.out.println(credit.getBalance());
        System.out.println(credit.getCreditLimit());
    }
}