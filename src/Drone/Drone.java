package Drone;

public class Drone {

    private Direction facing;
    private int dx, dy, droneID;
    public static int droneCount = 0;

    public Drone (int x, int y, Direction f) {
        dx = x;
        dy = y;
        droneID = droneCount++;
        facing = f;
    }

    public void displayDrone(ConsoleCanvas c){
        char droneRep = 'D';
        c.showIt(dx, dy, droneRep);
    }

    public String toString(){
        return "Drone " + droneID + " at " + dx + ", " + dy + " facing " + facing.toString();
    }

    public boolean isHere (int sx, int sy){
        if (sx == dx && sy == dy)
            return true;
        else
            return false;
    }

    public static void main (String[] args) {
        Drone d = new Drone(5,3, Direction.East);
        System.out.println(d.toString());
        Drone d2 = new Drone(8,10, Direction.South);
        System.out.println(d2.toString());
    }
}
