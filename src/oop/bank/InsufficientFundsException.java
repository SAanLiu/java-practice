package oop.bank;

public class InsufficientFundsException extends Exception {
    private final double requestedAmount;
    private final double availableAmount;

    public InsufficientFundsException(double requestedAmount, double availableAmount) {
        super("Insufficient funds: requested " + requestedAmount
                + ", available " + availableAmount);
        this.requestedAmount = requestedAmount;
        this.availableAmount = availableAmount;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }
}