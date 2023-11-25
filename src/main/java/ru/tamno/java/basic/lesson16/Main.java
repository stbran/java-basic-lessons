package ru.tamno.java.basic.lesson16;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap.*;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "9050000000");
        phoneBook.add("Ivanov", "9050000001");
        phoneBook.add("Ivanov", "9050000002");
        phoneBook.add("Petrov", "9050000003");
        phoneBook.add("Petrenko", "9050000004");
        phoneBook.add("Petrenko", "9050000005");
        phoneBook.add("Ivanenko", "9050000006");
        phoneBook.print();
        phoneBook.find("Ivanov");
        phoneBook.find("Petr");
        phoneBook.containsPhoneNumber("9050000004");
        phoneBook.containsPhoneNumber("9050000007");
    }
}
