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
        int posX;
        int posY;
        if (numDrone.size() < arenaWidth * arenaHeight) {
            do {
                posX = randomCoords.nextInt(arenaWidth);
                posY = randomCoords.nextInt(arenaHeight);
            } while (getDroneAt(posX, posY) != null);

            Drone anyPlace = new Drone(posX, posY);
            numDrone.add(anyPlace);
        }

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

    public Drone getDroneAt(int x, int y){
        Drone temp = null;
        for (Drone a : numDrone){
            if (a.isHere(x,y) == true){
                temp = a;
            }
        }
        return temp;
    }


    public static void main(String[] args){
        DroneArena a = new DroneArena(3, 3);
        a.addDrone();
        a.addDrone();
        a.addDrone();
        a.addDrone();
        a.addDrone();

        System.out.println(a.toString());
    }
}

