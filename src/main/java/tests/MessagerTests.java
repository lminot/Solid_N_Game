package tests;

import org.junit.Before;
import org.junit.Test;
import src.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Lucien.Minot on 7/31/2015.
 */
public class MessagerTests {

    MessageHandler messenger;

    @Before
    public void setUp(){
       messenger = new MessageHandler();
    }

    @Test public void itDisplaysABoardSizeErrorForValuesUnderOne() throws Exception {

        assertTrue("error message not shown", messenger.createBoardError());
    }

    @Test public void itDisplaysAMessageForMovesMade() throws Exception{
        int moveNumber = 1;
        assertTrue("error message not shown", messenger.movesMade(moveNumber));
    }

    @Test public void itDisplaysAShuffleNumberErrorForValuesUnderZero() throws Exception {

        assertTrue("error message not shown", messenger.shuffleError());
    }

    @Test public void itDisplaysNewBoardMessage() throws Exception {

        assertTrue("error message not shown", messenger.newBoardDispalyMessage());
    }

    @Test public void itDisplaysHowToMoveMessage() throws Exception {

        assertTrue("error message not shown", messenger.howToMoveMessage());
    }

    @Test public void itDisplaysEnterBoardSizeMessage() throws Exception {

        assertEquals(messenger.enterBoardSize, "Please enter an integer greater than 1 for the game board size: \n");
    }

    @Test public void itDisplaysEnterMoveDirectionMessage() throws Exception {

        assertEquals(messenger.enterMoveDirection, "1 = up, 2 = down, 3 = left, 4 = right, 0 = quit\n");
    }

    @Test public void itDisplaysEnterShuffleNumbernMessage() throws Exception {

        assertEquals(messenger.enterShuffleNumber, "Shuffle the board how many times?\n");
    }
}
