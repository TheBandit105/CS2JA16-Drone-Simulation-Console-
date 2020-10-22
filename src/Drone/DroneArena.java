package Drone;

public class DroneArena {

    private int arenaWidth;
    private int arenaHeight;
    private Drone d;
    

    public DroneArena(int x, int y){
        arenaWidth = x;
        arenaHeight = y;
    }

    public void addDrone(){
        int posX = 10;
        int posY = 5;

        d = new Drone(posX, posY);
        }

    public String toString(){

        return "The size of the arena is: " + arenaWidth + " * " + arenaHeight + " and " + d.toString();

    }

    public static void main(String[] args){
        DroneArena a = new DroneArena(20, 10);
        a.addDrone();
        System.out.println(a.toString());
    }
}

