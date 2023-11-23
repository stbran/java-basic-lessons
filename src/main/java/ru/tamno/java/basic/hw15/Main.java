package ru.tamno.java.basic.hw15;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println(sequenceMinMax(3, 8));
        System.out.println(sumElementsMore5(sequenceMinMax(3, 8)));
        System.out.println(increaseEachElementByNumber(2, sequenceMinMax(3, 8)));
        System.out.println();

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bob", 18));
        employees.add(new Employee("Gob", 16));
        employees.add(new Employee("Dob", 20));
        employees.add(new Employee("Job", 14));
        employees.add(new Employee("Zob", 17));

        System.out.println(getNames(employees));
        printArrayListOfObjects(legalAge(employees, 18));
        System.out.println(checkAvgAge(employees, 18));
        System.out.println("Самый молодой сотрудник - " + searchJunior(employees).getName());
    }

    public static ArrayList sequenceMinMax(int min, int max) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            arr.add(i);
        }
        return arr;
    }

    public static int sumElementsMore5(ArrayList<Integer> arr) {
        int sum = 0;
        for (Integer elem : arr) {
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }

    public static ArrayList increaseEachElementByNumber(int number, ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i) + number);
        }
        return arr;
    }

    public static ArrayList<String> getNames(ArrayList<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee elem : employees) {
            names.add(elem.getName());
        }
        return names;
    }

    public static ArrayList<Employee> legalAge(ArrayList<Employee> employees, int age) {
        ArrayList<Employee> employeesLegalAge = new ArrayList<>();
        for (Employee elem : employees) {
            if (elem.getAge() >= age) {
                employeesLegalAge.add(new Employee(elem.getName(), elem.getAge()));
            }
        }
        return employeesLegalAge;
    }

    public static boolean checkAvgAge(ArrayList<Employee> employees, int age) {
        int avgAge = 0;
        for (Employee elem : employees) {
            avgAge += elem.getAge();
        }
        System.out.println(avgAge / employees.size());
        return age < (float) avgAge / employees.size();
    }

    public static Employee searchJunior(ArrayList<Employee> employees) {
        int minAge = employees.get(0).getAge();
        int index = 0;
        for (int i = 1; i < employees.size(); i++) {
            if (employees.get(i).getAge() < minAge) {
                minAge = employees.get(i).getAge();
                index = i;
            }
        }
        return employees.get(index);
    }

    public static void printArrayListOfObjects(ArrayList<Employee> employees) {
        for (Employee o : employees) {
            System.out.println("Name " + o.getName() + ", age " + o.getAge());
        }
    }
}

