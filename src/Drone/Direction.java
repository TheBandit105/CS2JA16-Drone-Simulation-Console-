package Drone;

import java.util.Random;

public enum Direction {
    North, East, South, West;


    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
