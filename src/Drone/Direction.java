package Drone;

import java.util.Random;

// Week 5 Demo Tested
// Author: Shavin Croos
// Direction class determines which way the drones can move

public enum Direction {

    North, North_East, North_West, East, South, South_East, South_West, West;

    public static Direction getRandomDirection() {
        Random random = new Random(); // Creates a randomiser
        return values()[random.nextInt(values().length)]; // Returns random direction

        /* Randomly gets and returns a value from one of the 4 directions in the enum, in which the directions are in the
         * form of the 4 compass points being North, East, South and West */
    }

    public Direction nextDirection() { /* Checks if the drone can go in the direction given.
    If it can, it keeps the direction it was assigned to and if not, the drone then changes
    to the next direction.*/

        int change = Direction.values().length - 1;
        if (this.ordinal() == change)
            return values()[0];
        else
            return values()[this.ordinal() + 1];
    }
}
