package ru.tamno.java.basic.hw13;

public class Bicycle extends MeansOfTransportation {
    Human human;

    public Bicycle(String name, float resourceConsumptionPerKm, int maxAmountResources) {
        super(name, resourceConsumptionPerKm, maxAmountResources);
    }

    @Override
    public boolean conditionForLocation(Location location) {
        if (location == null) {
            System.out.println("Куда едем-то?");
            return false;
        }
        if (location.equals(Location.SWAMP)) {
            System.out.println("На велосипеде не проехать по болоту");
            return false;
        }
        return true;
    }

    @Override
    public boolean move(int distance, Location location, Human human) {
        if (!conditionForLocation(location)) {
            return false;
        }
        if (human.getDistancePower() == 0) {
            System.out.println("Вы устали. Отдохните!");
            return false;
        }
        if (distance >= human.getDistancePower()) {
            System.out.println("Вы проехали на велосипеде " + human.getDistancePower() + " км и устали. Отдохните!");
            human.setDistancePower(0);
            return true;
        }
        if (distance < human.getDistancePower()) {
            human.setDistancePower(human.getDistancePower() - distance);
            System.out.println("Вы проехали на велосипеде " + distance + " км. Осталось сил на " + human.getDistancePower() + " км");
            return true;
        }
        return false;
    }
}
