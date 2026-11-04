package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("попытка создания с отрицательным запасом");
        try {
            Pharmacy badPharmacy = new Pharmacy("Фармация", "ул. Советская, 12", 4.2, -15);
        } catch (InvalidPharmacyDataException e) {
            System.err.println(e.getMessage());
        }

        Pharmacy pharmacy = null;
        try {
            pharmacy = new Pharmacy("Дежурная Аптека", "пр. Независимости, 100", 4.7, 0);
            System.out.println("Успешно создана: " + pharmacy);

            pharmacy.restockMedicine("Аспирин", 30);
            pharmacy.restockMedicine("Парацетамол", 50);
            System.out.println("Текущее состояние склада: " + pharmacy + "\n");
        } catch (InvalidPharmacyDataException | StockException e) {
            System.err.println(e.getMessage());
        }

        if (pharmacy == null) return;

        System.out.println("успешная продажа препарата");
        try {
            pharmacy.sellMedicine("Парацетамол", 15);
            System.out.println("Общий остаток лекарств: " + pharmacy.getStock());
        } catch (MedicineNotFoundException | StockException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("операция продажи завершена\n");
        }

        System.out.println("покупка несуществующего лекарства");
        try {
            pharmacy.sellMedicine("Ибупрофен", 2);
        } catch (MedicineNotFoundException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getMedicineName());
        } catch (StockException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("превышение доступного количества при покупке");
        try {
            pharmacy.sellMedicine("Аспирин", 100);
        } catch (MedicineNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (StockException e) {
            System.err.println(e.getMessage());
            System.err.println("Было запрошено: " + e.getRequested() + " шт., в наличии: " + e.getAvailable() + " шт.");
        }

        System.out.println(pharmacy);
    }
}
