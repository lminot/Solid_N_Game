package tests; /**
 * Created by Lucien.Minot on 10/2/2014.
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import src.*;

import static org.junit.Assert.*;

public class GameBoardTests {

    private GameUtilities gameBoard;
    private DisplayGame displayer;
    private GameMovements mover;

    private int moveCounter;

    @Before
    public void setUp(){

        gameBoard = new GameBoard();
        displayer = new GameDisplayer((GameBoard) gameBoard);
        mover = new GameMovements((GameBoard) gameBoard);

        moveCounter = mover.moveCount = 0;

    }

    @Test
    public void itCreatesABoard() throws Exception
    {
        gameBoard.setSize(4);
        gameBoard.createBoard();

        Assert.assertEquals(4, gameBoard.createBoard().length);

    }

    @Test
    public void itDisplaysTheBoard() throws Exception
    {

        gameBoard.setSize(6);
        gameBoard.createBoard();

        Assert.assertEquals(true, displayer.display());
    }

    @Test
    public void itLocatesTheZero() throws Exception
    {
        gameBoard.setSize(4);
        gameBoard.createBoard();
        displayer.display();

        assertEquals(true, GameMovements.locateZero());
    }

    @Test
    public void itChecksNonWinningBoard() throws Exception
    {

        gameBoard.setSize(3);
        gameBoard.createBoard();
        displayer.display();
        mover.moveLeft();
        displayer.display();
        gameBoard.isWinner();

        assertFalse(gameBoard.isWinner());

    }

    @Test
    public void itChecksWinningBoard() throws Exception
    {

        gameBoard.setSize(3);
        gameBoard.createBoard();
        displayer.display();
        mover.shuffleBoard(1);
        mover.moveRight();
        mover.moveDown();
        displayer.display();

        assertEquals(true, gameBoard.isWinner());

    }

    @Rule
    public final ExpectedSystemExit exits = ExpectedSystemExit.none();

    @Test
    public void itCanQuitTheGame()throws Exception
    {
        GameOver exit = new QuitGame();
        QuitGame quitGame = new QuitGame();

        exits.expectSystemExitWithStatus(0);
        gameBoard.setSize(3);
        gameBoard.createBoard();
        displayer.display();
        mover.shuffleBoard(100);

        exit.quitGame();
        assertEquals(true, quitGame.GameExited());
    }
}
