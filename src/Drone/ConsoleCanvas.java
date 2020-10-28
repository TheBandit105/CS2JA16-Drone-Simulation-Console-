package Drone;

public class ConsoleCanvas {
    private int blockX;
    private int blockY;
    private char[][] block;

    public ConsoleCanvas(int x, int y){
        blockX = x;
        blockY = y;
        block = new char[x][y];
        for (int i = 0; i < blockX; i++){
            for (int j = 0; j < blockY; j++){
                block[i][j] = ' ';
                if (i == 0 || i == blockX - 1) {
                    block[i][j] = '#';
                }
                else if (j == 0 || j == blockY - 1){
                    block[i][j] = '#';
                }
            }
        }
    }

    public static void main(String[] args){
        ConsoleCanvas c = new ConsoleCanvas(10, 5);
        c.showIt(4,3,'D');
        System.out.println(c.toString());
    }
}
