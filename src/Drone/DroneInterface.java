package Drone;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.net.NoRouteToHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DroneInterface {
    private Scanner s;					// scanner used for input from user
    private DroneArena myArena;				// arena in which drones are shown
    private int dCounter = 1;

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
                    + "\n\tMove drones 10 times -> T " + "\n\tFile Routes -> F " + "\n\tCredits -> C " + "\n\tExit -> X " + "\n\n\t> ");
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
                        System.out.println("\nAdded drone!");
                        System.out.println("Total number of drones in arena = " + myArena.arenaDroneNum());
                    }
                    break;
                case 'I' :
                case 'i' :
                    if (myArena.getArenaHeight() == 0 || myArena.getArenaWidth() == 0) {
                        System.err.println("Error! No arena detected! Please create a new arena.\n");
                    }
                    else if (myArena.numDrone.isEmpty() == true){
                        System.err.println("Warning! Please insert drones to move!");
                        System.out.println("\nArena dimensions: " + inputX + " * " + inputY + ".");
                    }
                    else{
                        System.out.print("\n" + myArena.toString() + "\n");
                    }
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
                        if (myArena.numDrone.isEmpty() == false) {
                            System.out.println("\n");
                            myArena.moveAllDrones(myArena);
                            doDisplay();
                        } else if (myArena.numDrone.isEmpty() == true) {
                            System.err.println("Warning! Please insert drones to move!\n");
                        }
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
                                System.out.println("============================================");
                                myArena.moveAllDrones(myArena);
                                doDisplay();
                                System.out.println(myArena.toString());
                                try {
                                    TimeUnit.MILLISECONDS.sleep(200); // Wait for 200ms
                                } catch (InterruptedException e) {
                                    System.err.format("IOException: %s%n", e);
                                }
                            }
                        } else if (myArena.numDrone.isEmpty() == true) {
                            System.err.println("Warning! Please insert drones to move!\n");
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
                    System.out.println("Arena created! Dimensions: " + inputX + " * " + inputY + ".");
                    break;
                case 'f':
                case 'F':
                    fileRoutes();
                    break;
                case 'c':
                case 'C':
                    System.out.println("\n\tDRONE SIMULATOR 2020");
                    System.out.println("\tProduced by Shavin Croos");
                    break;
                case 'x' : 	ch = 'X';				// when X detected program ends
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

    void fileRoutes(){
        s = new Scanner(System.in);
        char ch = ' ';
        System.out.print("\nPlease select one of the following options: " + "\n\tSave file -> S "
                + "\n\tLoad file -> L " + "\n\tReturn to main menu -> R " +  "\n\n\t> ");
        ch = s.next().charAt(0);
        s.nextLine();
        switch (ch) {
            case 's':
            case 'S':
                try {
                    fileSave();
                } catch (Exception a) {
                    System.err.print(" ");
                }
                break;
            case 'l':
            case 'L':
                try {
                    fileLoad();
                } catch (Exception b) {
                    System.err.print(" ");
                }
                break;
            case 'e':
            case 'E':
                break;
            case 'r':
            case 'R':
                break;
            default:
                break;
        }
    }

    void fileSave() throws IOException {

        JFileChooser chooser = new JFileChooser("C:\\Users\\shavi\\OneDrive\\Desktop\\Drone Files");
        chooser.setDialogTitle("Select directory to save file ");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        chooser.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "Arena Files (*.arena)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String fileName = f.getName().toLowerCase();
                    return fileName.endsWith(".arena");
                }
            }
        });

        s = new Scanner(System.in);
        String nameFile = " ";
        System.out.println("\nCreate the name of file being saved: ");
        nameFile = s.next();
        chooser.setApproveButtonText("Save");
        chooser.setApproveButtonToolTipText("Save location");
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
                File userFile = new File(chooser.getSelectedFile() + "\\" + nameFile + ".arena");
                System.out.println("\nFile saved as: " + nameFile + ".arena in directory " + userFile.getAbsolutePath());

            if(dCounter != 1){
                dCounter = 1;
            }

                FileWriter fileWriter = new FileWriter(userFile);
                BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("Size of arena: ");
            writer.write(Integer.toString(myArena.getArenaWidth()));
            writer.write(" * ");
            writer.write(Integer.toString(myArena.getArenaHeight()));
            writer.newLine();
                for (Drone d : myArena.numDrone){
                    writer.write("Drone " + dCounter++ + " at ");
                    writer.write(Integer.toString(d.getX()));
                    writer.write(", ");
                    writer.write(Integer.toString(d.getY()));
                    writer.write(" facing ");
                    writer.write(d.getFacing().toString());
                    writer.newLine();
                }
                writer.close();
            }
        }

    void fileLoad() throws IOException{
        JFileChooser chooser = new JFileChooser("C:\\Users\\shavi\\OneDrive\\Desktop\\Drone Files");
        chooser.setDialogTitle("Select directory to load file ");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        String fileContents = " ";

        chooser.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "Arena Files (*.arena)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String fileName = f.getName().toLowerCase();
                    return fileName.endsWith(".arena");
                }
            }
        });

        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File userFile = chooser.getSelectedFile();
            if(chooser.getSelectedFile().isFile()){
                System.out.println("File loaded!\n Name: " + userFile.getName() + " from directory "
                        + userFile.getAbsolutePath());

                if (!myArena.numDrone.isEmpty()) {
                    myArena.numDrone.clear();
                    myArena.numDroneArena = 0;
                    Drone.droneCount = 1;
                }

                FileReader fileReader = new FileReader(userFile);
                BufferedReader reader = new BufferedReader(fileReader);

                fileContents = reader.readLine();
                String[] loadSize = fileContents.split(" ");
                int openX = Integer.parseInt(loadSize[0]);
                int openY = Integer.parseInt(loadSize[1]);
                myArena = new DroneArena(openX,openY);
                while (fileContents != null){
                    fileContents = reader.readLine();
                    String [] numbers = fileContents.split(" ");
                    int x = Integer.parseInt(numbers[0]);
                    int y = Integer.parseInt(numbers[1]);
                    int ordinal = Integer.parseInt(numbers[2]);
                    myArena.numDrone.add(new Drone(x, y, Direction.values()[ordinal]));

                }
                reader.close();
            }
        }

    }

    public static void main(String[] args) {
        DroneInterface r = new DroneInterface();	// just call the interface
    }
}


