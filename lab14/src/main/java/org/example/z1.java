package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class z1 {
    public static void main(String[] args) {
        String fileName = "transport.txt";
        String content = "Мой любимый вид транспорта — поезд.\n" +
                "Он позволяет путешествовать безопасно, любоваться природой за окном,\n" +
                "читать книги и комфортно отдыхать в дороге.";

        File file = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            System.out.println("Файл \"" + fileName + "\" успешно создан и заполнен.\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            return;
        }

        System.out.println("Св-ва и данные о файле");
        System.out.println("Имя файла: " + file.getName());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Файл существует: " + (file.exists() ? "Да" : "Нет"));
        System.out.println("Доступен для чтения: " + (file.canRead() ? "Да" : "Нет"));
        System.out.println("Доступен для записи: " + (file.canWrite() ? "Да" : "Нет"));
        System.out.println("Является каталогом: " + (file.isDirectory() ? "Да" : "Нет"));
        System.out.println("Является обычным файлом: " + (file.isFile() ? "Да" : "Нет"));
        System.out.println("Дата последней модификации: " + new Date(file.lastModified()));

        System.out.println("\nИнфа из файла");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
