package tests;

import org.junit.Test;
import src.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Lucien.Minot on 7/31/2015.
 */
public class MessagerTests {

    @Test public void itDisplaysAnErrorMessage()throws Exception {
        MessageHandler messenger = new MessageHandler();
        String errorMessage = messenger.showError();

        assertEquals("error", errorMessage);
    }

    @Test public void itDisplaysABoardSizeErrorForValuesUnderOne() throws Exception {
        MessageHandler messenger = new MessageHandler();
        assertTrue("error message shown", messenger.createBoardError());
        //assertEquals("Error please enter a number greater than 1...", boardSizeError);
    }

    @Test public void itDisplaysAMessageForMovesMade() throws Exception{
        MessageHandler messenger = new MessageHandler();
        int moveNumber = 1;
        assertTrue("error message shown", messenger.movesMade(moveNumber));
    }

    @Test public void itDisplaysAShuffleNumberErrorForValuesUnderZero() throws Exception {
        MessageHandler messenger = new MessageHandler();
        assertTrue("error message shown", messenger.shuffleError());
    }

}
