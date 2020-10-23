package Drone;

import java.util.ArrayList;
import java.util.Random;

public class DroneArena {
    private int arenaWidth;
    private int arenaHeight;
    Random randomCoords;
    ArrayList <Drone> numDrone;

    public DroneArena(int x, int y){
        arenaWidth = x;
        arenaHeight = y;
        randomCoords = new Random();
        numDrone = new ArrayList<Drone>();
        Drone d = new Drone(1,1);
    }

    public void addDrone(){
        int posX = randomCoords.nextInt(arenaWidth);
        int posY = randomCoords.nextInt(arenaHeight);

        Drone test = new Drone(posX, posY);
        numDrone.add(test);
    }

    public String toString(){
        String spot = "";
        if (numDrone.isEmpty() == false){
            spot = "";
            spot += "The size of the arena is: " + arenaWidth + " * " + arenaHeight;
            for (int i = 0; i < numDrone.size(); i++){
                spot += "\n" + numDrone.get(i).toString();
            }
        }
        return spot;
    }

    public static void main(String[] args){
        DroneArena a = new DroneArena(20, 10);
        a.addDrone();
        a.addDrone();
        System.out.println(a.toString());
    }
}

