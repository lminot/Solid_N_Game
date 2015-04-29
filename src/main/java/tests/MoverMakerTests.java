package tests;

import org.junit.Before;
import org.junit.Test;
import src.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lucien.Minot on 4/10/2015.
 */
public class MoverMakerTests implements MoveMaker, DisplayGame {

    private int moveCounter;
    private GameUtilities gameBoard;
    private DisplayGame newDisplay;
    private GameMovements mover;
    private MoveMaker newMoves;

    private int up = 1;
    private int down = 2;
    private int right = 4;
    private int left = 3;


    @Before
    public void setUp(){

        gameBoard = new GameBoard();
        newDisplay = new GameDisplayer((GameBoard)gameBoard);
        newMoves = new GameMovements((GameBoard)gameBoard);
        mover = new GameMovements();
        moveCounter = mover.moveCount = 0;
        GameMovements.hasShuffled = false;
    }

    @Override
    public void moveMaker(int moveDirection) {}

    @Override
    public boolean shuffleBoard(int shuffles) {
        return false;
    }

    @Override
    public boolean display() {
        return true;
    }

    @Test
    public void itLocatesTheZero() throws Exception
    {
        gameBoard.setSize(4);
        gameBoard.createBoard();
        newDisplay.display();

        assertEquals(true, GameMovements.locateZero());
    }

    @Test
    public void inMovesUp()throws Exception
    {
        gameBoard.setSize(2);
        gameBoard.createBoard();
        mover.moveUp();
        newDisplay.display();

        assertEquals(1, mover.moveCount);
    }

    @Test
     public void inMovesDown()throws Exception
    {
        gameBoard.setSize(3);
        gameBoard.createBoard();
        mover.moveUp();
        mover.moveUp();
        mover.moveDown();
        newDisplay.display();

        assertEquals(3, mover.moveCount);
    }

    @Test
    public void inMovesLeft()throws Exception
    {
        gameBoard.setSize(2);
        gameBoard.createBoard();
        mover.moveLeft();
        newDisplay.display();

        assertEquals(1, mover.moveCount);
    }

    @Test
    public void inMovesRight()throws Exception
    {
        gameBoard.setSize(3);
        gameBoard.createBoard();
        mover.moveLeft();
        mover.moveLeft();
        mover.moveRight();
        newDisplay.display();

        assertEquals(3, mover.moveCount);
    }

    @Test
    public void itShufflesTheBoard()throws Exception
    {
        gameBoard.setSize(3);
        gameBoard.createBoard();
        newMoves.shuffleBoard(10);
        newDisplay.display();

        assertEquals(10, mover.moveCount);
    }

    @Test
    public void itOnlyMovesInsideTheBoard()throws Exception
    {
        gameBoard.setSize(3);
        gameBoard.createBoard();
        mover.moveDown();
        mover.moveRight();

        assertEquals(0, mover.moveCount);
    }

    @Test
    public void itMovesWithMoveMaker() throws Exception
    {
        gameBoard.setSize(3);
        gameBoard.createBoard();
        newDisplay.display();
        newMoves.moveMaker(up);
        newMoves.moveMaker(left);
        newMoves.moveMaker(down);
        newMoves.moveMaker(right);

       assertEquals(4, mover.moveCount);
    }

    @Test
    public void initialShuffleMustBeGreaterThanZero() throws Exception
    {
        gameBoard.setSize(3);
        gameBoard.createBoard();
        newDisplay.display();

        mover.shuffleBoard(0);

        assertEquals(false, GameMovements.hasShuffled);
    }
}
