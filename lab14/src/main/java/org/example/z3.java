package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
public class z3 {
    public static void main(String[] args) {
        String fileF = "f.txt";
        String fileG = "g.txt";
        String fileH = "h.txt";

        // 1. Создание файла 'f' со случайными целыми числами (15 чисел)
        Random rnd = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileF))) {
            for (int i = 0; i < 15; i++) {
                int randomNum = rnd.nextInt(150) - 20; // случайные числа от -20 до 129
                writer.print(randomNum + " ");
            }
            System.out.println("Файл \"" + fileF + "\" со случайными числами создан.");
        } catch (IOException e) {
            System.err.println("Ошибка создания файла f: " + e.getMessage());
            return;
        }

        // 2. Чтение из 'f' и распределение в 'g' и 'h' через try-with-resources с 3 ресурсами
        try (Scanner readerF = new Scanner(new File(fileF));
             PrintWriter writerG = new PrintWriter(new FileWriter(fileG));
             PrintWriter writerH = new PrintWriter(new FileWriter(fileH))) {

            while (readerF.hasNextInt()) {
                int n = readerF.nextInt();

                // Условие: кратные 8 И НЕ кратные 3
                if (n % 8 == 0 && n % 3 != 0) {
                    writerG.print(n + " ");
                } else {
                    writerH.print(n + " ");
                }
            }
            System.out.println("Числа распределены по файлам \"g.txt\" и \"h.txt\".\n");

        } catch (IOException e) {
            System.err.println("Ошибка обработки файлов: " + e.getMessage());
        }

        printFile("Файл f (все случайные числа)", fileF);
        printFile("Файл g (кратные 8 и не кратные 3)", fileG);
        printFile("Файл h (все остальные числа)", fileH);
    }

    private static void printFile(String label, String fileName) {
        System.out.println(label + ":");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            System.out.println(line != null ? line : "[файл пуст]");
        } catch (IOException e) {
            System.err.println("Ошибка чтения " + fileName + ": " + e.getMessage());
        }
        System.out.println();
    }
}
