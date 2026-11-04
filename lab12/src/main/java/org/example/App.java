package org.example;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Зоопарк");
        Map<String, Animal> zoo = new LinkedHashMap<>();

        zoo.put("Лев", new Mammal("Лев", 1, "Саванна", "Короткая шерсть"));
        zoo.put("Медведь", new Mammal("Медведь", 2, "Лес", "Густой мех"));
        zoo.put("Тигр", new Mammal("Тигр", 3, "Джунгли", "Полосатая шерсть"));

        zoo.put("Крокодил", new Reptile("Крокодил", 4, "Болото", "Твердая чешуя"));
        zoo.put("Змея", new Reptile("Змея", 5, "Пустыня", "Мелкая чешуя"));
        zoo.put("Черепаха", new Reptile("Черепаха", 6, "Океан", "Панцирь"));

        zoo.put("Акула", new Fish("Акула", 7, "Океан", "Большие плавники"));
        zoo.put("Клоун", new Fish("Клоун", 8, "Риф", "Маленькие плавники"));

        System.out.println("Зоопарк:");
        for (Map.Entry<String, Animal> entry : zoo.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " | Значение: " + entry.getValue());
        }
        System.out.println("Журналы");

        List<Magazine> magazines = new ArrayList<>();
        magazines.add(new Magazine(1, "Forbes", "Бизнес", 5, Arrays.asList(5, 4, 5, 5)));
        magazines.add(new Magazine(2, "Vogue", "Мода", 3, Arrays.asList(2, 3, 2, 4)));
        magazines.add(new Magazine(3, "National Geographic", "Наука", 4, Arrays.asList(4, 5, 4, 4)));
        magazines.add(new Magazine(4, "Cosmopolitan", "Стиль", 2, Arrays.asList(1, 2, 3, 2)));
        magazines.add(new Magazine(5, "Time", "Новости", 5, Arrays.asList(5, 5, 4, 5)));

        System.out.println("Исходный список журналов:");
        for (Magazine m : magazines) System.out.println("  " + m);

        System.out.println("\n1. После удаления журналов со средним рейтингом < 3:");
        magazines.removeIf(m -> m.getAverageRating() < 3);
        for (Magazine m : magazines) System.out.println("  " + m);

        System.out.println("\n2. Повышение рейтинга журналов (средний >= 4):");
        for (Magazine m : magazines) {
            if (m.getAverageRating() >= 4) {
                m.setRating(m.getRating() + 1); // Повышаем
                System.out.println("  Повышен: " + m.getTitle() + " (новый рейтинг: " + m.getRating() + ")");
            }
        }

        System.out.println("\n3. Печать журналов с рейтингом 5:");
        printMagazines(magazines, 5);

        System.out.println("\n4. Отсортированный список (ID, Название, Средний рейтинг):");
        magazines.sort((m1, m2) -> {
            int cmp = Double.compare(m2.getAverageRating(), m1.getAverageRating());
            return cmp != 0 ? cmp : m2.getTitle().compareTo(m1.getTitle());
        });
        System.out.printf("%-5s %-25s %-15s%n", "ID", "Название", "Средний рейтинг");
        System.out.println("--------------------------------------------------");
        for (Magazine m : magazines) {
            System.out.printf("%-5d %-25s %-15.2f%n", m.getId(), m.getTitle(), m.getAverageRating());
        }
    }
    public static void printMagazines(List<Magazine> magazines, int rating) {
        boolean found = false;
        for (Magazine m : magazines) {
            if (m.getRating() == rating) {
                System.out.println("  " + m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Журналов с рейтингом " + rating + " не найдено.");
        }
    }
}