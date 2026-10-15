package oop.bank;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.owner = "张三";
        account.balance = 1000;

        account.balance = -10000;
        System.out.println(account.balance);
    }
}
