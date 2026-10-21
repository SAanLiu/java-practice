package oop.bank;

public interface InterestBearing {
    void applyInterest();

    default String interestPolicy() {
        return "Interest is calculated annually.";
    }
}