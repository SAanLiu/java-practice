package oop.bank;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount a = new BankAccount("张三");
        BankAccount b = new BankAccount("李四", 500);

        System.out.println(a.getBalance()); // 0.0
        System.out.println(b.getBalance()); // 500.0
    }
}
