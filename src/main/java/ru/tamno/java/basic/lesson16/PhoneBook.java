package ru.tamno.java.basic.lesson16;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new TreeMap<>();

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        } else {
            phoneBook.put(name, new LinkedHashSet<>());
            phoneBook.get(name).add(phone);
        }
    }

    public Set<String> find(String name) {
        if (!phoneBook.containsKey(name)) {
            System.out.println("В базе нет человека с именем " + name);
            return null;
        }
        System.out.println("Для " + name + " найдена запись: " + phoneBook.get(name));
        return phoneBook.get(name);
    }

    public boolean containsPhoneNumber(String phone) {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                System.out.println("Номер " + phone + " найден. Принадлежит " + entry.getKey());
                return true;
            }
        }
        System.out.println("Номер " + phone + " не найден");
        return false;
    }

    public void print() {
        int i = 1;
        for (String key : phoneBook.keySet()) {
            System.out.println(i++ + ". " + key + ": " + phoneBook.get(key));
        }
    }
}
