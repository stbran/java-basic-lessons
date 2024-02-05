package ru.tamno.java.basic.lesson22;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<String> files = searchTxtFilesInRoot();
        String name = openFileByName(files);
        addDataInFile(name);
    }

    static List<String> searchTxtFilesInRoot() {
        File dir = new File(".");
        File[] files = dir.listFiles();
        List<String> txtFiles = new ArrayList<>();
        System.out.println("Существующие файлы .txt в корне проекта:");
        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                txtFiles.add(file.getName());
                System.out.println(file.getName());
            }
        }
        return txtFiles;
    }

    static String openFileByName(List<String> files) {
        Scanner sc = new Scanner(System.in);
        String inputName = null;
        if (files.size() > 0) {
            System.out.println("Введите название файла для чтения:");
            while (true) {
                inputName = sc.next();
                if (files.contains(inputName)) {
                    try (InputStreamReader in = new InputStreamReader(new FileInputStream(inputName))) {
                        int n = in.read();
                        while (n != -1) {
                            System.out.print((char) n);
                            n = in.read();
                        }
                        break;
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Неверное имя");
                }
            }
        } else {
            System.out.println("Файлов не найдено");
        }
        return inputName;
    }

    static void addDataInFile(String fileName) {
        if (fileName != null) {
            System.out.println("\nЧто вы хотите добавить?");
            Scanner sc = new Scanner(System.in);
            String data = "\n" + sc.nextLine();
            try (FileOutputStream out = new FileOutputStream(fileName, true)) {
                byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
                out.write(buffer);
                System.out.println("Данные успешно записаны");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
