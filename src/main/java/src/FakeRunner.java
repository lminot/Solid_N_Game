package src;

import utils.TextDevice;
import utils.TextDevices;

/**
 * Created by Lucien.Minot on 4/2/2015.
 */
public class FakeRunner implements Runner {

    public static boolean gameStarted = false;
    public static int shuffleNum = 0;
    public static int size = 0;
    public static int move = 0;
    private final TextDevice io;

    GameUtilities gameBoard = new GameBoard();
    GameDisplayer displayer = new GameDisplayer((GameBoard) gameBoard);
    MoveMaker mover = new GameMovements((GameBoard) gameBoard);

    public FakeRunner(TextDevice io) {
        this.io = io;
        gameStarted = true;
    }

    public void FakeStart() {
        io.printf("Enter an integer greater than 1 for the game board size: \n", size);
        int enteredSize = readNumber();

        if (enteredSize < 2 ) {
            System.out.println("Error please enter a number greater than 1...");
            start();
        } else {
            gameBoard.setSize(enteredSize);
            gameBoard.createBoard();
            displayer.display();


//            shuffle();
//            GameMovements.moveCount = 0;
//            while (!gameBoard.isWinner()) {
//                moveReader();
//                displayer.display();
//                System.out.println("Moves made: " + GameMovements.moveCount);
//            }
        }
    }

    @Override
    public void start() {
        io.printf("Enter an integer greater than 1 for the game board size: \n", size);
        int enteredSize = readNumber();

        if (enteredSize < 2 ) {
            System.out.println("Error please enter a number greater than 1...");
            start();
        } else {
            gameBoard.setSize(enteredSize);
            gameBoard.createBoard();
            displayer.display();


            shuffle();
            GameMovements.moveCount = 0;
                while (!gameBoard.isWinner()) {
                    moveReader();
                    displayer.display();
                    System.out.println("Moves made: " + GameMovements.moveCount);
                }
        }
    }

    public void moveReader(){
        io.printf("1 = up, 2 = down, 3 = left, 4 = right, 0 = quit\n", move);
        int enteredMove = readNumber();
        mover.moveMaker(enteredMove);
    }

    public void shuffle(){
        io.printf("Shuffle the board how many times?\n", shuffleNum);

        int shuffleNumber = readNumber();
        if(shuffleNumber == 0) {
            System.out.println("Error please enter a number greater than 0...");
            shuffle();
        }
        else {
            mover.shuffleBoard(shuffleNumber);
            displayer.display();
        }
    }

    private int readNumber() {
        while (true) {
            try {
                return Integer.parseInt(io.readLine());
            } catch (NumberFormatException e) {}
        }
    }

    public static void main(String[] args) {
        Runner newGame = new FakeRunner(TextDevices.defaultTextDevice());
        newGame.start();
    }
}
