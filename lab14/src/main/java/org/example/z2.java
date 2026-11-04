package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class z2 {
    public static void main(String[] args) {
        String fileName = "f.txt";
        Scanner console = new Scanner(System.in);

        System.out.println("Введите 10 целых чисел:");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 10; i++) {
                System.out.print("Число " + i + ": ");
                while (!console.hasNextInt()) {
                    System.out.println("Ошибка! Введите целое число:");
                    console.next();
                }
                int number = console.nextInt();
                writer.print(number + " ");
            }
            System.out.println("\nЧисла успешно записаны в файл \"" + fileName + "\".");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            return;
        }

        System.out.println("\nЧисла, считанные из файла:");
        int count = 0;

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");

                if (num % 6 == 0 && num % 9 != 0) {
                    count++;
                }
            }
            System.out.println();
            System.out.println("Количество чисел, кратных 6 и не кратных 9: " + count);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
