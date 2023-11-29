package ru.tamno.java.basic.hw15;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(sequenceMinMax(3, 8));
        System.out.println(sumElementsMore5(sequenceMinMax(3, 8)));
        System.out.println(increaseEachElementByNumber(2, sequenceMinMax(3, 8)));
        System.out.println();

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bob", 18));
        employees.add(new Employee("Gob", 16));
        employees.add(new Employee("Dob", 20));
        employees.add(new Employee("Job", 14));
        employees.add(new Employee("Zob", 17));

        System.out.println(getNames(employees));
        printArrayListOfObjects(new ArrayList<>(legalAge(employees, 18)));
        System.out.println(checkAvgAge(employees, 18));
        System.out.println("Самый молодой сотрудник - " + searchJunior(employees).getName());
    }

    public static List<Integer> sequenceMinMax(int min, int max) {
        List<Integer> arr = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            arr.add(i);
        }
        return arr;
    }

    public static int sumElementsMore5(List<Integer> arr) {
        int sum = 0;
        for (Integer elem : arr) {
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }

    public static List<Integer> increaseEachElementByNumber(int number, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i) + number);
        }
        return arr;
    }

    public static List<String> getNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee elem : employees) {
            names.add(elem.getName());
        }
        return names;
    }

    public static List<Employee> legalAge(List<Employee> employees, int age) {
        List<Employee> employeesLegalAge = new ArrayList<>();
        for (Employee elem : employees) {
            if (elem.getAge() >= age) {
                employeesLegalAge.add(elem);
            }
        }
        return employeesLegalAge;
    }

    public static boolean checkAvgAge(List<Employee> employees, int age) {
        int avgAge = 0;
        for (Employee elem : employees) {
            avgAge += elem.getAge();
        }
        System.out.println(avgAge / employees.size());
        return age < (float) avgAge / employees.size();
    }

    public static Employee searchJunior(List<Employee> employees) {
        int minAge = employees.get(0).getAge();
        Employee junior = null;
        for (Employee elem : employees) {
            if (elem.getAge() < minAge) {
                junior = elem;
            }
        }
        return junior;
    }

    public static void printArrayListOfObjects(ArrayList<Employee> employees) {
        for (Employee o : employees) {
            System.out.println("Name " + o.getName() + ", age " + o.getAge());
        }
    }
}

