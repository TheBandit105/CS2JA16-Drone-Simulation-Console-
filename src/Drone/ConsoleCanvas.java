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
                if (i == 0 || i == blockX - 1) {
                    block[i][j] = '#';
                }
                else if (j == 0 || j == blockY - 1){
                    block[i][j] = '#';
                }
                else {
                    block[i][j] = ' ';
                }
            }
        }
    }

    public void showIt(int dx, int dy, char ch) {
        block[dx + 1][dy + 1] = ch;
    }

    public static void main(String[] args){
        ConsoleCanvas c = new ConsoleCanvas(10, 5);
        c.showIt(4,3,'D');
        System.out.println(c.toString());
    }
}
