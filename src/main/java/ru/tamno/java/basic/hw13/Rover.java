package ru.tamno.java.basic.hw13;

public class Rover extends MeansOfTransportation {

    public Rover(String name, float resourceConsumptionPerKm, int maxAmountResources) {
        super(name, resourceConsumptionPerKm, maxAmountResources);
    }

    @Override
    public boolean conditionForLocation(Location location) {
        if (location == null) {
            System.out.println("Куда едем-то?");
            return false;
        }
        return true;
    }
}
