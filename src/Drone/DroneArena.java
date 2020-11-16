package Drone;

import java.util.ArrayList;
import java.util.Random;

public class DroneArena {
    private int arenaWidth;
    private int arenaHeight;
    Random randomCoords;
    ArrayList <Drone> numDrone;
    public int numDroneArena;

    public DroneArena(int x, int y){
        arenaWidth = x;
        arenaHeight = y;
        randomCoords = new Random();
        numDrone = new ArrayList<Drone>();
        Drone d = new Drone(1,1, Direction.North);
    }

    public void addDrone(){
        int posX;
        int posY;
        if (numDrone.size() < arenaWidth * arenaHeight) {
            do {
                posX = randomCoords.nextInt(arenaWidth);
                posY = randomCoords.nextInt(arenaHeight);
            } while (getDroneAt(posX, posY) != null);

            Drone anyPlace = new Drone(posX, posY, Direction.getRandomDirection());
            numDrone.add(anyPlace);
        }
    }

    public int getArenaWidth(){
        return arenaWidth;
    }

    public int getArenaHeight() {
        return arenaHeight;
    }

    public int arenaDroneNum(){
        if(numDroneArena < (arenaWidth * arenaHeight)){
            numDroneArena++;
        } else {
            System.err.println("\nMaximum drone capacity reached!");
        }
        return numDroneArena;
    }

    public void showDrones(ConsoleCanvas c){
        for (Drone d : numDrone){
            d.displayDrone(c);
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

    public boolean canMoveHere(int x, int y){
        if (getDroneAt(x,y) != null || x >= arenaWidth || y >= arenaHeight || x < 0 || y < 0){
            return false;
        } else {
            return true;
        }
    }

    public void moveAllDrones(DroneArena a){
        for (Drone d : numDrone)
            d.tryToMove(a);
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
        DroneArena a = new DroneArena(20, 10);
        a.addDrone();
        a.addDrone();

        System.out.println(a.toString());
    }
}

