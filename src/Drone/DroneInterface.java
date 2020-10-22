package Drone;

import java.util.Scanner;

public class DroneInterface {
    private Scanner s;					// scanner used for input from user
    private DroneArena myArena;				// arena in which drones are shown

    public DroneInterface() {
        s = new Scanner(System.in);			    // set up scanner for user input
        myArena = new DroneArena(20, 6);	    // create arena of size 20*6

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd drone, get (I)nformation or e(X)it > ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A' :
                case 'a' :
                    myArena.addDrone();	// add a new drone to arena
                    break;
                case 'I' :
                case 'i' :
                    System.out.print(myArena.toString());
                    break;
                case 'x' : 	ch = 'X';				// when X detected program ends
                    break;
            }
        } while (ch != 'X');						// test if end

        s.close();									// close scanner
    }

    public static void main(String[] args) {
        DroneInterface r = new DroneInterface();	// just call the interface
    }

}


