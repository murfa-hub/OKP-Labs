package org.example;

public class StockException extends Exception {
    private final int requested;
    private final int available;

    public StockException(String message) {
        super(message);
        this.requested = 0;
        this.available = 0;
    }

    public StockException(String message, int requested, int available) {
        super(message);
        this.requested = requested;
        this.available = available;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }
}
