package ru.tamno.java.basic.hw13;

public class Bicycle extends MeansOfTransportation {

    public Bicycle(String name, float resourceConsumptionPerKm, int maxAmountResources) {
        super(name, resourceConsumptionPerKm, maxAmountResources);
    }

    @Override
    public boolean conditionForLocation(Location location) {
        if (location == null) {
            System.out.println("Куда едем-то?");
            return false;
        }
        if (location == Location.SWAMP) {
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
        human.go(distance, location, "проехал на велосипеде");
        return false;
    }
}
