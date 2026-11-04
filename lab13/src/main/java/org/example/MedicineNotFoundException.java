package org.example;

public class MedicineNotFoundException extends Exception {
    private final String medicineName;

    public MedicineNotFoundException(String message, String medicineName) {
        super(message);
        this.medicineName = medicineName;
    }

    public String getMedicineName() {
        return medicineName;
    }
}
