package ru.tamno.java.basic.hw13;

public abstract class MeansOfTransportation implements Transportation {

    protected String name;
    protected Human driver;
    protected float resourceConsumptionPerKm; // расход ресурсов на км
    protected int maxAmountResources; // максимальный объем ресурсов
    protected float currentAmountResources; // текущий объем ресурсов

    public MeansOfTransportation(String name, float resourceConsumptionPerKm, int maxAmountResources) {
        this.name = name;
        this.resourceConsumptionPerKm = resourceConsumptionPerKm;
        this.maxAmountResources = maxAmountResources;
        currentAmountResources = maxAmountResources;
    }

    public String getName() {
        return this.name;
    }

    public Human getDriver() {
        return driver;
    }

    @Override
    public abstract boolean conditionForLocation(Location location);

    @Override
    public boolean move(int distance, Location location, Human human) {
        if (!conditionForLocation(location)) {
            return false;
        }
        if (currentAmountResources > 0) {
            currentAmountResources -= distance * resourceConsumptionPerKm;
            if (currentAmountResources <= 0) {
                distance += currentAmountResources / resourceConsumptionPerKm;
                System.out.println(driver.getName() + " проехал на " + name + " " + distance + " км. Пора пополнить ресурсы!");
                currentAmountResources = 0;
                return true;
            }
            System.out.println(driver.getName() + " проехал на " + name + " " + distance + " км");
            return true;
        }
        System.out.println("У " + name + " закончились ресурсы!");
        return false;
    }

    @Override
    public void resuplly(float resources) {
        if (resources <= 0) {
            System.out.println("Не понимаю вас!");
            return;
        }
        if (resources >= maxAmountResources - currentAmountResources) {
            resources = maxAmountResources - currentAmountResources;
            currentAmountResources = maxAmountResources;
            System.out.println("У " + name + " максимальное количество ресурсов!");
        }
        System.out.println("У " + name + " уровень ресурсов " + resources);

    }
}
