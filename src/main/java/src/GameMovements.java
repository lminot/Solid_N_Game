package src;

import java.util.Random;

public class GameMovements implements MoveMaker {

    public static GameBoard gameBoard;
    MessageDisplayer messager = new MessageHandler();

    public GameMovements(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    GameOver exit = new QuitGame();

    public static final int QUIT  = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    public static int zeroXLocation = 0;
    public static int zeroYLocation = 0;

    public static int moveCount = 0;
    public static boolean boardHasShuffled = false;

    public static boolean locateZero() {
        for (int x = 0; x < gameBoard.size; x++)
            for (int y = 0; y < gameBoard.size; y++) {
                if (gameBoard.gameBoard[x][y].hashCode() == 0) {
                    zeroXLocation = x;
                    zeroYLocation = y;
                }
            }
        return true;
    }

    public void moveDown() {
        locateZero();
        if(zeroXLocation == gameBoard.size - 1){
            if (boardHasShuffled) {
                messager.moveDownErrorMessage();
            }
        }
        else {
            gameBoard.gameBoard[zeroXLocation][zeroYLocation] = gameBoard.gameBoard[zeroXLocation + 1][zeroYLocation];
            gameBoard.gameBoard[zeroXLocation + 1][zeroYLocation] = 0; //moves the 00 value to the value below
            moveCount++;
        }
    }

    public void moveUp() {
        locateZero();
        if(zeroXLocation == 0){
            if (boardHasShuffled) {
                messager.moveUpErrorMessage();
            }
        }
        else {
            gameBoard.gameBoard[zeroXLocation][zeroYLocation] = gameBoard.gameBoard[zeroXLocation - 1][zeroYLocation];
            gameBoard.gameBoard[zeroXLocation - 1][zeroYLocation] = 0; //moves the 00 value to the value above
            moveCount++;
        }
    }

    public void moveRight() {
        locateZero();
        if(zeroYLocation == gameBoard.size - 1) {
            if (boardHasShuffled) {
                messager.moveRightErrorMessage();
            }
        }
        else {
            gameBoard.gameBoard[zeroXLocation][zeroYLocation] = gameBoard.gameBoard[zeroXLocation][zeroYLocation +1];
            gameBoard.gameBoard[zeroXLocation][zeroYLocation +1] = 0; //moves the 00 value to the value to the right
            moveCount++;
        }
    }

    public void moveLeft() {
        locateZero();
        if(zeroYLocation == 0){
            if (boardHasShuffled) {
                messager.moveLeftErrorMessage();
            }
        }
        else {
            gameBoard.gameBoard[zeroXLocation][zeroYLocation] = gameBoard.gameBoard[zeroXLocation][zeroYLocation -1];
            gameBoard.gameBoard[zeroXLocation][zeroYLocation -1] = 0; //moves the 00 value to the value to the left
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
                messager.invalidMoveMessage();
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
            while (moveCount < shuffles) {  // while loop to force  movement ONLY inside the bounds of the board
                int randomInterger = random.nextInt((max - min) + 1) + min;

                moveMaker(randomInterger);
            }
            boardHasShuffled = true;
            return true;
        }
    }
}
