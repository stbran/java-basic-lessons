package ru.tamno.java.basic.hw13;

public class Human {
    final private String name;
    private MeansOfTransportation currentTransport;
    private float distancePower;
    private float maxDistance;


    public float getDistancePower() {
        return distancePower;
    }

    public float getMaxDistance() {
        return maxDistance;
    }

    public String getCurrentTransport() {
        if (currentTransport != null) {
            return currentTransport.getName();
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public Human(String name, MeansOfTransportation transport) {
        this.name = name;
        currentTransport = transport;
    }

    public boolean getIn(MeansOfTransportation transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже занял " + currentTransport.getName());
            return false;
        } else {
            System.out.println(name + " cел в " + transport.getName());
            currentTransport = transport;
            currentTransport.driver = this;
            return true;
        }
    }

    public boolean getOut() {
        if (currentTransport == null) {
            System.out.println(name + " стоит на земле");
            return false;
        } else {
            System.out.println(name + " вышел из " + currentTransport.getName());
            currentTransport.driver = null;
            currentTransport = null;
            return true;
        }
    }

    public boolean move(int distance, Location location) {
        if (distance <= 0) {
            System.out.println("Ничего не выйдет. Постоим?");
            return false;
        }
        if (currentTransport == null) {
            this.go(distance, location, "прошел");
            return true;
        }
        currentTransport.move(distance, location, this);
        return true;
    }

    private boolean checkConditionForWalk(Location location) {
        if (location == null) {
            System.out.println("Куда идем-то?");
            return false;
        }
        if (location == Location.SWAMP || location == Location.FOREST) {
            System.out.println("Опасно ходить в " + location);
            return false;
        }
        return true;
    }

    public boolean go(int distance, Location location, String movement) {
        if (currentTransport == null && !this.checkConditionForWalk(location)) {
            return false;
        }
        if (distancePower == 0) {
            System.out.println(name + " устал. Отдохни!");
            return false;
        }
        if (distance >= distancePower) {
            System.out.println(name + " " + movement + " " + distancePower + " км и устал. Отдохни!");
            distancePower = 0;
            return true;
        }
        if (distance < distancePower) {
            distancePower -= distance;
            System.out.println(name + " " + movement + " " + distance + " км. Осталось сил на " + distancePower + " км");
            return true;
        }
        return false;
    }

    public void relax(int maxDistance) {
        if (this.maxDistance == 0) {
            this.maxDistance = maxDistance;
        }
        if (distancePower == 0) {
            distancePower = maxDistance;
        }
        System.out.println(name + " полон сил!");
    }
}
