package Drone;

public class Drone {

    private int dx, dy, droneID;
    public static int droneCount = 0;

    public Drone (int x, int y) {
        dx = x;
        dy = y;
        droneID = droneCount++;
    }

    public String toString(){
        return "Drone " + droneID + " at " + dx + ", " + dy;
    }

    public boolean isHere (int sx, int sy){
        if (sx == dx && sy == dy)
            return true;
        else
            return false;
    }

    public static void main (String[] args) {
        Drone d = new Drone(5,3);
        System.out.println(d.toString());
        Drone d2 = new Drone(8,10);
        System.out.println(d2.toString());
    }
}
