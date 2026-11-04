package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
public class z4 {
    public static void main(String[] args) {
        String fileName = "battery.txt";
        Scanner console = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Введите 10 значений уровня заряда батареи в % (например: 98.5 45.0 23.4):");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 10; i++) {
                System.out.print("Значение " + i + ": ");
                while (!console.hasNextDouble()) {
                    System.out.println("Ошибка! Введите вещественное число (с точкой):");
                    console.next();
                }
                double charge = console.nextDouble();
                writer.print(charge + " ");
            }
            System.out.println("\nДанные о заряде успешно записаны в файл \"" + fileName + "\".");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            return;
        }

        double sum = 0.0;
        int count = 0;

        System.out.println("\nСчитанные из файла значения заряда:");
        try (Scanner fileScanner = new Scanner(new File(fileName)).useLocale(Locale.US)) {
            while (fileScanner.hasNextDouble()) {
                double val = fileScanner.nextDouble();
                System.out.printf(Locale.US, "%.1f%%  ", val);
                sum += val;
                count++;
            }
            System.out.println();

            if (count > 0) {
                double avg = sum / count;
                System.out.printf(Locale.US, "\nСредний уровень заряда батареи: %.2f%%\n", avg);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
