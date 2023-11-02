package ru.tamno.java.basic.hw10;

public class Main {

    public static void main(String[] args) {
        checkUser();
        checkBox();
    }

    private static void checkBox() {
        Box box1 = new Box(100, 200, "белый", false);
        Box box2 = new Box(50, 50, "красный", true);
        box1.info();
        box2.info();
        box1.putItem("молоток");
        box2.putItem("молоток");
        box2.setOpen(false);
        box2.putItem("молоток");
        box2.takeOutItem("молоток");
        box1.setColor("розовый");
        box1.info();
        box1.setOpen(true);
        box2.setOpen(true);
        box2.printItems();
        box1.printItems();
        box1.putItem("ответрка", "гвозди", "схема", "инструкция", "шуруповерт", "сверло");
        box1.printItems();
        box1.takeOutItem("jhd");
        box1.takeOutItem("гвозди", "инструкция", "ответрка", "схема", "молоток");
        box1.takeOutItem("шуруповерт");
        box1.printItems();
        box1.putItem("молоток");
    }

    private static void checkUser() {
        int curYear = 2023;
        User[] users = new User[]{new User("Иванов", "Иван", "Иванович", 1967, "ivanov@mail.ru"),
                new User("Петров", "Василий", "Кузьмич", 1986, "petrov@mail.ru"),
                new User("Сидорова", "Анна", "Михайловна", 1995, "sidirov@mail.ru"),
                new User("Белкина", "Элеонора", "Петровна", 1998, "belkina@mail.ru"),
                new User("Михайлов", "Александр", "Александрович", 1970, "mikhailov@mail.ru"),
                new User("Бобов", "Евгений", "Владимирович", 1974, "bobov@mail.ru"),
                new User("Юрин", "Юрий", "Юрьевич", 2009, "urin@mail.ru"),
                new User("Евгеньев", "Евгений", "Евгеньевич", 2001, "evgen@mail.ru"),
                new User("Сафина", "Анастасия", "Олеговна", 2000, "safina@mail.ru"),
                new User("Сафронова", "Юлия", "Ивановна", 1980, "saafronova@mail.ru"),

        };

        for (int i = 0; i < users.length; i++) {
            if (curYear - users[i].getBirthYear() > 40) {
                users[i].info();
            }

        }
    }
}
