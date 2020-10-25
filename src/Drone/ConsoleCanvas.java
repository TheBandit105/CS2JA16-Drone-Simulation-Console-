package Drone;

public class ConsoleCanvas {

    public static void main(String[] args){
        ConsoleCanvas c = new ConsoleCanvas(10, 5);
        c.showIt(4,3,'D');
        System.out.println(c.toString());
    }
}
