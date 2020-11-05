package Drone;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DroneInterface {
    private Scanner s;					// scanner used for input from user
    private DroneArena myArena;				// arena in which drones are shown

    public DroneInterface() {
        s = new Scanner(System.in);			    // set up scanner for user input
        myArena = new DroneArena(0, 0);	    // create arena of size 20*6
        int inputX = 0;
        int inputY = 0;

        char ch = ' ';
        System.out.println("\n ---------------- WELCOME TO THE DRONE SIMULATOR ------------------");
        do {
            System.out.print("\nNote: Before you start, please create a new arena.");
            System.out.print("\n\nPlease select one of the following options: " + "\n\tAdd drone -> A " +  "\n\tGet info -> I "
                    + "\n\tDisplay arena -> D " + "\n\tCreate arena -> N " + "\n\tMove drones -> M "
                    + "\n\tMove drones 10 times -> T" + "\n\tExit -> X " + "\n\n\t> ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A' :
                case 'a' :
                    if (myArena.getArenaHeight() == 0 || myArena.getArenaWidth() == 0) {
                        System.err.println("Error! No arena detected! Please create a new arena.\n");
                    }
                    else {
                        myArena.addDrone();
                    }// add a new drone to arena
                    break;
                case 'I' :
                case 'i' :
                    if (myArena.getArenaHeight() == 0 || myArena.getArenaWidth() == 0) {
                        System.err.println("Error! No arena detected! Please create a new arena.\n");
                    }
                    else {
                        System.out.print("\n" + myArena.toString() + "\n");
                    }
                    break;
                case 'x' : 	ch = 'X';				// when X detected program ends
                    break;
                case 'd':
                case 'D':
                    if (myArena.getArenaHeight() == 0 || myArena.getArenaWidth() == 0) {
                        System.err.println("Error! No arena detected! Please create a new arena.\n");
                    }
                    else {
                        System.out.println("\n");
                        doDisplay();
                    }
                    break;
                case 'm':
                case 'M':
                    if(inputX == 0 || inputY == 0){
                        System.err.println("Error! No arena detected! Please create a new arena.\n");
                    } else {
                        System.out.println("\n");
                        myArena.moveAllDrones(myArena);
                        doDisplay();
                    }
                    break;
                case 't':
                case 'T':
                    if (myArena.getArenaHeight() == 0 || myArena.getArenaWidth() == 0) {
                        System.err.println("Error! No arena detected! Please create a new arena.\n");
                    }
                    else {
                        if (myArena.numDrone.isEmpty() == false) {
                            for (int i = 0; i < 10; i++) {
                                myArena.moveAllDrones(myArena);
                                doDisplay();
                                System.out.println(myArena.toString());
                                try {
                                    TimeUnit.MILLISECONDS.sleep(200); // Wait for 200ms
                                } catch (InterruptedException e) {
                                    System.err.format("IOException: %s%n", e);
                                }
                            }
                        } else if (myArena.numDrone.isEmpty() == true && myArena.getArenaHeight() == 0 || myArena.getArenaWidth() == 0) {
                            System.err.println("Warning! Please insert drones to move!");
                        }
                    }
                    break;
                case 'n':
                case 'N':
                    System.out.print("\n Input arena dimensions: ");
                    System.out.print("\n X = ");
                    try {
                        inputX = s.nextInt();
                    } catch (Exception a){
                        System.err.println("Error! Invalid input! Please insert whole numbers.");
                        System.out.print("\n\n X = ");
                        s.nextLine();
                        inputX = s.nextInt();
                    }
                    System.out.print(" Y = ");
                    try {
                        inputY = s.nextInt();
                    } catch (Exception b){
                        System.err.println("Error! Invalid input! Please insert whole numbers.");
                        System.out.print("\n\n Y = ");
                        s.nextLine();
                        inputY = s.nextInt();
                    }
                    myArena = new DroneArena(inputX, inputY);
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


