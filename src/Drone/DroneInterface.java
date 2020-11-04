package Drone;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DroneInterface {
    private Scanner s;					// scanner used for input from user
    private DroneArena myArena;				// arena in which drones are shown

    public DroneInterface() {
        s = new Scanner(System.in);			    // set up scanner for user input
        myArena = new DroneArena(10, 20);	    // create arena of size 20*6

        char ch = ' ';
        System.out.println("\n ---------------- WELCOME TO THE DRONE SIMULATOR ------------------");
        do {
            System.out.print("\nPlease select one of the following options: " + "\n\tAdd drone -> A " +  "\n\tGet info -> I "
                    + "\n\tDisplay arena -> D " + "\n\tMove drones -> M " + "\n\tMove drones 10 times -> T" + "\n\tExit -> X " + "\n\n\t> ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A' :
                case 'a' :
                    myArena.addDrone();	// add a new drone to arena
                    break;
                case 'I' :
                case 'i' :
                    System.out.print("\n" + myArena.toString() + "\n");
                    break;
                case 'x' : 	ch = 'X';				// when X detected program ends
                    break;
                case 'd':
                case 'D':
                    System.out.println("\n");
                    doDisplay();
                    break;
                case 'm':
                case 'M':
                    System.out.println("\n");
                    myArena.moveAllDrones(myArena);
                    doDisplay();
                    break;
                case 't':
                case 'T':
                    if (myArena.numDrone.isEmpty() == false){
                        for(int i = 0; i < 10; i++){
                            myArena.moveAllDrones(myArena);
                            doDisplay();
                            System.out.println(myArena.toString());
                            try {
                                TimeUnit.MILLISECONDS.sleep(200); // Wait for 200ms
                            } catch (InterruptedException e) {
                                System.err.format("IOException: %s%n", e);
                            }
                        }
                    } else if (myArena.numDrone.isEmpty() == true){
                    System.out.println("Warning! Please insert drones to move!");
                }
                    break;
            }
        } while (ch != 'X');						// test if end

        s.close();									// close scanner
    }

    void doDisplay(){
        //myArena = new DroneArena(10, 10);
        ConsoleCanvas field = new ConsoleCanvas(myArena.getArenaWidth() + 2, myArena.getArenaHeight() + 2);
        myArena.showDrones(field);
        System.out.println(field.toString());
    }
    public static void main(String[] args) {
        DroneInterface r = new DroneInterface();	// just call the interface
    }
}


