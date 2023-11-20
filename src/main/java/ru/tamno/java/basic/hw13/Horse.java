package ru.tamno.java.basic.hw13;

public class Horse extends MeansOfTransportation {
    public Horse(String name, float resourceConsumptionPerKm, int maxAmountResources) {
        super(name, resourceConsumptionPerKm, maxAmountResources);
    }

    @Override
    public boolean conditionForLocation(Location location) {
        if (location == null) {
            System.out.println("Куда едем-то?");
            return false;
        }
        if (location.equals(Location.SWAMP)) {
            System.out.println("На коне не проехать по болоту");
            return false;
        }
        return true;
    }
}
