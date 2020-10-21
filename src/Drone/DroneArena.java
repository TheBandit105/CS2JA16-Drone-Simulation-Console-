package Drone;

public class DroneArena {

    private int arenaLength;
    private int arenaWidth;


    DroneArena(int x, int y){
        arenaLength = x;
        arenaWidth = y;
    }

    public void addDrone(){
        int posX, posY;

    }


    public String toString(){

        return "The size of the arena is: " + arenaLength + " * " + arenaWidth;

    }


    public static void main(String[] args){
        DroneArena a = new DroneArena(20, 10);
        a.addDrone();
        System.out.println(a.toString());
    }
}
