package org.example;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    private String name;
    private String address;
    private Map<String, Integer> medicines;
    private int stock;
    private double rating;

    public Pharmacy(String name, String address, double rating, int initialStock) throws InvalidPharmacyDataException {
        setName(name);
        setAddress(address);
        setRating(rating);
        setStock(initialStock);
        this.medicines = new HashMap<>();
    }

    public void setStock(int stock) throws InvalidPharmacyDataException {
        if (stock < 0) {
            throw new InvalidPharmacyDataException("Количество лекарств не может быть отрицательным: " + stock);
        }
        this.stock = stock;
    }

    public void setName(String name) throws InvalidPharmacyDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPharmacyDataException("Название аптеки не может быть пустым.");
        }
        this.name = name;
    }

    public void setAddress(String address) throws InvalidPharmacyDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new InvalidPharmacyDataException("Адрес аптеки не может быть пустым.");
        }
        this.address = address;
    }

    public void setRating(double rating) throws InvalidPharmacyDataException {
        if (rating < 1.0 || rating > 5.0) {
            throw new InvalidPharmacyDataException("Рейтинг должен быть от 1 до 5 Передано: " + rating);
        }
        this.rating = rating;
    }

    public void sellMedicine(String name, int quantity) throws MedicineNotFoundException, StockException {
        if (quantity <= 0) {
            throw new StockException("Количество для продажи должно быть больше нуля: " + quantity);
        }
        if (!medicines.containsKey(name)) {
            throw new MedicineNotFoundException("Лекарство \"" + name + "\" не найдено в аптеке.", name);
        }

        int currentAmount = medicines.get(name);
        if (quantity > currentAmount) {
            throw new StockException(
                    "Недостаточно товара \"" + name + "\" на складе",
                    quantity,
                    currentAmount
            );
        }

        medicines.put(name, currentAmount - quantity);
        this.stock -= quantity;
        System.out.println("Успешно продано: \"" + name + "\" (" + quantity + " шт.)");
    }

    public void restockMedicine(String name, int quantity) throws StockException {
        if (quantity <= 0) {
            throw new StockException("Количество для пополнения должно быть > 0! Передано: " + quantity);
        }

        int currentAmount = medicines.getOrDefault(name, 0);
        medicines.put(name, currentAmount + quantity);
        this.stock += quantity;
        System.out.println("Пополнен запас: \"" + name + "\" на " + quantity + " шт. (Всего: " + (currentAmount + quantity) + ")");
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getStock() { return stock; }
    public double getRating() { return rating; }
    public Map<String, Integer> getMedicines() { return medicines; }

    @Override
    public String toString() {
        return "Аптека '" + name + "\nАдрес: " + address + "\nРейтинг: " + rating +
                " \nОбщий остаток: " + stock + " шт. \nАссортимент: " + medicines;
    }
}
