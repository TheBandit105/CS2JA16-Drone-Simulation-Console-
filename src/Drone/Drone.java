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

    public int getX(){
        return dx;
    }

    public int getY(){
        return dy;
    }

    public Direction getFacing() {
        return facing;
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

    public void tryToMove(DroneArena a){
        switch (facing){
            case North:
                if(a.canMoveHere(dx - 1, dy))
                    dx = dx - 1;
                else
                    facing = facing.nextDirection();
                break;
            case East:
                if(a.canMoveHere(dx, dy + 1))
                    dy = dy + 1;
                else
                    facing = facing.nextDirection();
                break;
            case South:
                if(a.canMoveHere(dx + 1, dy))
                    dx = dx + 1;
                else
                    facing = facing.nextDirection();
                break;
            case West:
                if(a.canMoveHere(dx, dy - 1))
                    dy = dy - 1;
                else
                    facing = facing.nextDirection();
                break;
        }
    }

    public static void main (String[] args) {
        Drone d = new Drone(5,3, Direction.East);
        System.out.println(d.toString());
        Drone d2 = new Drone(8,10, Direction.South);
        System.out.println(d2.toString());
    }
}
