package ru.tamno.java.basic.hw13;

public class Human {
    final private String name;
    private boolean isInTransport;
    private Transportation currentTransport;
    private float distancePower;
    private float maxDistance;

    public boolean isInTransport() {
        return isInTransport;
    }

    public float getDistancePower() {
        return distancePower;
    }

    public float getMaxDistance() {
        return maxDistance;
    }

    public void setDistancePower(float distancePower) {
        this.distancePower = distancePower;
    }

    public String getCurrentTransport() {
        if (currentTransport != null) {
            return currentTransport.getName();
        }
        return "";
    }

    public Human(String name, Transportation transport) {
        this.name = name;
        currentTransport = transport;
        isInTransport = false;
    }

    public void setMaxDistance(float maxDistance) {
        if (this.maxDistance == 0) {
            this.maxDistance = maxDistance;
            distancePower = maxDistance;
        }
    }

    public boolean getIn(Transportation transport) {
        if (isInTransport) {
            System.out.println("Вы уже заняли " + currentTransport.getName());
            return false;
        } else {
            System.out.println("Сели в " + transport.getName());
            isInTransport = true;
            currentTransport = transport;
            return true;
        }
    }

    public boolean getOut(Transportation transport) {
        if (!isInTransport) {
            System.out.println("Вы стоите на земле");
            return false;
        } else if (currentTransport == transport) {
            System.out.println("Вышли из " + currentTransport.getName());
            isInTransport = false;
            currentTransport = null;
            return true;
        } else {
            System.out.println("Вы не в " + transport.getName());
            return false;
        }
    }

    public boolean go(int distance, Location location, Transportation transport) {
        if (distance <= 0) {
            System.out.println("Ничего не выйдет. Постоим?");
            return false;
        }
        if (transport == null) {
            this.go(distance, location);
            return true;
        }
        if (currentTransport != transport || !isInTransport) {
            System.out.println("Вы не сидите в " + transport.getName());
            return false;
        }
        transport.move(distance, location, this);
        return true;
    }

    private boolean checkCondition(Location location) {
        if (location == null) {
            System.out.println("Куда идем-то?");
            return false;
        }
        if (location.equals(Location.SWAMP) || location.equals(Location.FOREST)) {
            System.out.println("Опасно ходить в " + location);
            return false;
        }
        return true;
    }

    public boolean go(int distance, Location location) {
        if (!this.checkCondition(location)) {
            return false;
        }
        if (distancePower == 0) {
            System.out.println("Вы устали. Отдохните!");
            return false;
        }
        if (distance >= distancePower) {
            System.out.println("Вы прошли " + distancePower + " км и устали. Отдохните!");
            distancePower = 0;
            return true;
        }
        if (distance < distancePower) {
            distancePower -= distance;
            System.out.println("Вы прошли " + distance + " км. Осталось сил на " + distancePower + " км");
            return true;
        }
        return false;
    }

    public void relax() {
        if (distancePower == 0) {
            distancePower = maxDistance;
        }
        System.out.println("Вы полны сил!");
    }

}
