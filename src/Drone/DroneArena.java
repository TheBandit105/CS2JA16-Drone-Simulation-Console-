package Drone;

import java.util.Random;

public class DroneArena {

    private int arenaWidth;
    private int arenaHeight;
    Random randomCoords;
    private Drone d;

    public DroneArena(int x, int y){
        arenaWidth = x;
        arenaHeight = y;
        randomCoords = new Random();
    }

    public void addDrone(){
        int posX = randomCoords.nextInt(arenaWidth);
        int posY = randomCoords.nextInt(arenaHeight);

        d = new Drone(posX, posY);
    }

    public String toString(){
        return "The size of the arena is: " + arenaWidth + " * " + arenaHeight + "\n" + d.toString();
    }

    public static void main(String[] args){
        DroneArena a = new DroneArena(20, 10);
        a.addDrone();
        System.out.println(a.toString());
    }
}

