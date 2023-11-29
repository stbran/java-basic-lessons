package ru.tamno.java.basic.lesson16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, String> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        phoneBook.put(phone, name);
    }

    public Set<String> find(String name) {
        int count = 0;
        Set<String> phones = new HashSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                phones.add(entry.getKey());
                System.out.println("Для " + name + " сохранен номер " + entry.getKey());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В базе нет человека с именем " + name);
        }
        return phones;
    }

    public boolean containsPhoneNumber(String phone) {
        if (phoneBook.containsKey(phone)) {
            System.out.println("Номер " + phone + " найден");
            return true;
        } else {
            System.out.println("Номер " + phone + " не найден");
        }
        return false;
    }

    public void print() {
        int i = 1;
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(i++ + ". " + entry.getValue() + ": " + entry.getKey());
        }
    }
}
