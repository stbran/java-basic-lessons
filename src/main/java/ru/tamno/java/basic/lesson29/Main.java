package ru.tamno.java.basic.lesson29;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] lines = parseLine();
        String fileName = lines[0];
        String word = lines[1];
        if (searchFileInRoot(fileName)) {
            System.out.println(countMatches(fileName, word));
        }
    }

    static boolean searchFileInRoot(String fileName) {
        File dir = new File(".");
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    static int countMatches(String fileName, String word) {
        int matches = 0;
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(in);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.contains(word))
                    matches++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }

    static String[] parseLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя файла и через пробел искомую последовательность символов:");
        String line = sc.nextLine();
        if (line.length() == 0) {
            return null;
        }
        String[] lines = line.split(" ");
        if (lines.length < 2) {
            return null;
        }
        return lines;
    }
}
