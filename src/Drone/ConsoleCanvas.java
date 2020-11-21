package Drone;

public class ConsoleCanvas {
    private int blockX;
    private int blockY;
    private char[][] block;

    // Week 5 Demo Tested
    // Author: Shavin Croos
    // ConsoleCanvas class visually displays the arena made

    /* ConsoleCanvas constructor initialises a canvas for the arena, based of the
    dimension inputs made by the user in DroneInterface, by indicating the #
    as the barriers of the arena and the spaces as the movable area for the drone to move */

    public ConsoleCanvas(int x, int y) {

        blockX = x;
        blockY = y;
        block = new char[x][y];
        for (int i = 0; i < blockX; i++) {
            for (int j = 0; j < blockY; j++) {
                if (i == 0 || i == blockX - 1) {
                    block[i][j] = '#';
                } else if (j == 0 || j == blockY - 1) {
                    block[i][j] = '#';
                } else {
                    block[i][j] = ' ';
                }
            }
        }
    }

    public void showIt(int dx, int dy, char ch) { /* Prints the drone within the arena created */
        block[dx + 1][dy + 1] = ch; /* Prevents the drone from being printed within the arena border */
    }

    public String toString() { /* Prints the drone arena in string form */
        String print = "";
        for (int i = 0; i < blockX; i++) {
            for (int j = 0; j < blockY; j++) {
                print += block[i][j] + " ";
            }
            print += "\n";
        }
        return print;
    }

}
