package ru.tamno.java.basic.hw10;

public class User {
    private String surname;
    private String name;
    private String patronymicName;
    private int birthYear;
    private String email;

    public User(String surname, String name, String patronymicName, int birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymicName +
                "\nГод рождения: " + birthYear +
                "\nemail: " + email);
        System.out.println();
    }
}
