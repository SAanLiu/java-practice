package oop.bank;

public class ResourceDemo {
    public static void main(String[] args) {
        try (MyResource r = new MyResource()) {
            System.out.println("Inside try block.");
            throw new IllegalStateException("Test exception");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}