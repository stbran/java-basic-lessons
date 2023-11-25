package ru.tamno.java.basic.lesson16;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, String> phoneBook = new HashMap<>();
    private Set<Map.Entry<String, String>> entries = phoneBook.entrySet();

    public void add(String name, String phone) {
        phoneBook.put(phone, name);
    }

    public void find(String name) {
        int count = 0;
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getValue().equals(name)) {
                System.out.println(entry.getValue() + " " + entry.getKey());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В базе нет человека с именем " + name);
        }
    }

    public void containsPhoneNumber(String phone) {
        if (phoneBook.containsKey(phone)) {
            System.out.println("Номер " + phone + " найден");
        } else {
            System.out.println("Номер " + phone + " не найден");
        }
    }

    public void print() {
        int i = 1;
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(i++ + ". " + entry.getValue() + ": " + entry.getKey());
        }
    }
}
