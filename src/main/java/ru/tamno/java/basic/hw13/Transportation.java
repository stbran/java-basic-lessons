package ru.tamno.java.basic.hw13;

public interface Transportation {
    boolean move(int distance, Location location, Human human);

    void resuplly(float resources);

    boolean conditionForLocation(Location location);
}
