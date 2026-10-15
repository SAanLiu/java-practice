package oop.bank;

public class BankDemo {
    public static void main(String[] args) {
        System.out.println("Initial account count: "
                + BankAccount.getTotalAccounts());

        BankAccount first = new BankAccount("Alice");
        BankAccount second = new BankAccount("Bob", 200);
        BankAccount third = new BankAccount("Charlie");

        System.out.println("Alice's account number: "
                + first.getAccountNumber());
        System.out.println("Bob's account number: "
                + second.getAccountNumber());
        System.out.println("Charlie's account number: "
                + third.getAccountNumber());
        System.out.println("Total accounts: "
                + BankAccount.getTotalAccounts());

        System.out.println("Deposit a negative amount: "
                + first.deposit(-50)); // false
        System.out.println("Deposit zero: "
                + first.deposit(0)); // false
        System.out.println("Deposit 100: "
                + first.deposit(100)); // true
        System.out.println("Withdraw more than the balance: "
                + first.withdraw(200)); // false
        System.out.println("Withdraw a negative amount: "
                + first.withdraw(-10)); // false
        System.out.println("Withdraw 30: "
                + first.withdraw(30)); // true
        System.out.println("Alice's balance: "
                + first.getBalance()); // 70.0

        try {
            new BankAccount("Invalid Account", -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total accounts after failed creation: "
                + BankAccount.getTotalAccounts());
    }
}