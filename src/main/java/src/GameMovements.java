package src;

import java.util.Random;

/**
 * Created by Lucien.Minot on 4/8/2015.
 */
public class GameMovements implements MoveMaker {

    public static GameBoard gameBoard;

    public GameMovements(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public GameMovements(){
    }

    GameOver exit = new QuitGame();

    public static final int QUIT  = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    private static int zeroLocX = 0;
    private static int zeroLocY = 0;

    public static int moveCount = 0;
    public static boolean hasShuffled = false;

    public static boolean locateZero() {
        for (int x = 0; x < gameBoard.size; x++)
            for (int y = 0; y < gameBoard.size; y++) {
                if (gameBoard.gameBoard[x][y] == 0) {
                    zeroLocX = x;
                    zeroLocY = y;
                }
            }
        return true;
    }

    public void moveDown() {

        locateZero();
        if(zeroLocX == gameBoard.size - 1){
            if (hasShuffled) {
                System.out.println("Cannot move down from current position!");
            }
        }
        else {
            gameBoard.gameBoard[zeroLocX][zeroLocY] = gameBoard.gameBoard[zeroLocX + 1][zeroLocY];
            gameBoard.gameBoard[zeroLocX + 1][zeroLocY] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    public void moveUp() {
        locateZero();
        if(zeroLocX == 0){
            if (hasShuffled) {
                System.out.println("Cannot move up from current position!");
            }
        }
        else {
            gameBoard.gameBoard[zeroLocX][zeroLocY] = gameBoard.gameBoard[zeroLocX - 1][zeroLocY];
            gameBoard.gameBoard[zeroLocX - 1][zeroLocY] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    public void moveRight() {

        locateZero();
        if(zeroLocY == gameBoard.size - 1) {
            if (hasShuffled) {
                System.out.println("Cannot move right from current position!");
            }
        }
        else {
            gameBoard.gameBoard[zeroLocX][zeroLocY] = gameBoard.gameBoard[zeroLocX][zeroLocY +1];
            gameBoard.gameBoard[zeroLocX][zeroLocY+1] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    public void moveLeft() {
        locateZero();
        if(zeroLocY == 0){
            if (hasShuffled) {
                System.out.println("Cannot move left from current position!");
            }
        }
        else {
            gameBoard.gameBoard[zeroLocX][zeroLocY] = gameBoard.gameBoard[zeroLocX][zeroLocY-1];
            gameBoard.gameBoard[zeroLocX][zeroLocY-1] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    @Override
    public void moveMaker(int moveDirection) {

        switch (moveDirection) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case QUIT:
                exit.quitGame();
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    @Override
    public boolean shuffleBoard(int shuffles) {
        int max = 4;
        int min = 1;
        Random random = new Random();
        if (shuffles == 0) {
            return false;
        }
        else {
            // while loop to force  movement ONLY inside the bounds of the board
            while (moveCount < shuffles) {
                int randomInterger = random.nextInt((max - min) + 1) + min;

                moveMaker(randomInterger);
            }

            hasShuffled = true;
            return true;
        }
    }
}
