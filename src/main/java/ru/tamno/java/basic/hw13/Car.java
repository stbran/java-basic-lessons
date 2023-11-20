package ru.tamno.java.basic.hw13;

public class Car extends MeansOfTransportation {
    public Car(String name, float resourceConsumptionPerKm, int maxAmountResources) {
        super(name, resourceConsumptionPerKm, maxAmountResources);
    }

    @Override
    public boolean conditionForLocation(Location location) {
        if (location == null) {
            System.out.println("Куда едем-то?");
            return false;
        }
        if (location.equals(Location.SWAMP) || location.equals(Location.FOREST)) {
            System.out.println("На машине не проехать по " + location);
            return false;
        }
        return true;
    }
}
