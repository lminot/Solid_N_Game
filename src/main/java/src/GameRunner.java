package src;


import utils.TextDevice;
import utils.TextDevices;

/**
 * Created by Lucien.Minot on 4/2/2015.
 */
public class GameRunner implements Runner{

    private final TextDevice io;
    private String enterBoardSizeMessage = MessageHandler.enterBoardSize;
    private String enterMoveDirectionMessage = MessageHandler.enterMoveDirection;
    private String enterShuffleNumberMessage = MessageHandler.enterShuffleNumber;

    private int size = 0;
    private int move = 0;
    private int shuffleNum = 0;

    GameUtilities gameBoard = new GameBoard();
    GameDisplayer displayer = new GameDisplayer((GameBoard) gameBoard);
    MoveMaker mover = new GameMovements((GameBoard) gameBoard);
    MessageDisplayer messager = new MessageHandler();

    public GameRunner(TextDevice io) {
        this.io = io;
    }

    @Override
    public void start() {
        io.printf(enterBoardSizeMessage, size);
        int enteredSize = readNumber();

        if(enteredSize < 2 ) {
            messager.createBoardError();
            start();
        } else {
        gameBoard.setSize(enteredSize);
        gameBoard.createBoard();
        messager.newBoardDispalyMessage();
        displayer.display();

        shuffle();
        messager.howToMoveMessage();
        GameMovements.moveCount = 0;

            while (!gameBoard.isWinner()) {
                moveReader();
                displayer.display();
                messager.movesMade(GameMovements.moveCount);
            }
        }
    }

    public void moveReader(){
        io.printf(enterMoveDirectionMessage, move);
        int enteredMove = readNumber();
        mover.moveMaker(enteredMove);
    }

    public void shuffle(){
        io.printf(enterShuffleNumberMessage, shuffleNum);
        int shuffleNumber = readNumber();
        if(shuffleNumber == 0) {
            messager.shuffleError();
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
        Runner newGame = new GameRunner(TextDevices.defaultTextDevice());
        newGame.start();
    }
}
