package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class z5 {
    public static void main(String[] args) {
        String fileName = "f.txt";

        int[] initialNumbers = {12, 45, 39, 40, 88, 5, 27, 41, 100, 3};
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int num : initialNumbers) {
                writer.print(num + " ");
            }
            System.out.println("Файл \"" + fileName + "\" успешно создан с 10 целыми числами.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            return;
        }

        int countLessThan40 = 0;
        System.out.println("\nЧисла, прочитанные из файла:");

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextInt()) {
                int number = fileScanner.nextInt();
                System.out.print(number + " ");
                if (number < 40) {
                    countLessThan40++;
                }
            }
            System.out.println();
            System.out.println("\nКоличество чисел, меньших 40: " + countLessThan40);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
