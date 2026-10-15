package oop.bank;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("张三");

        System.out.println(account.deposit(1000));
        System.out.println(account.withdraw(300));
        System.out.println(account.withdraw(1000));
        System.out.println(account.deposit(-10));
        System.out.println(account.getBalance());
    }
}
