package org.example;

public class InvalidPharmacyDataException extends Exception {
    public InvalidPharmacyDataException(String message) {
        super(message);
    }
}