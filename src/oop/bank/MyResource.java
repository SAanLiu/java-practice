package oop.bank;

public class MyResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Resource closed.");
    }
}