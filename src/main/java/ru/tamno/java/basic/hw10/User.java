package ru.tamno.java.basic.hw10;

public class User {
    public String surname;
    public String name;
    public String patronymicName;
    public int birthYear;
    public String email;

    public User(String surname, String name, String patronymicName, int birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymicName +
                "\nГод рождения: " + birthYear +
                "\nemail: " + email);
        System.out.println();
    }
}
