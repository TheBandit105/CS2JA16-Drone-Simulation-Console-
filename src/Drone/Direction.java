package Drone;

import java.util.Random;

public enum Direction {
    North, East, South, West;


    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];

    }

    public Direction nextDirection() {
        int change = Direction.values().length - 1;
        System.out.println(change);
        if(this.ordinal() == change)
            return values()[0];
        else
            return values()[this.ordinal() + 1];
    }
}
