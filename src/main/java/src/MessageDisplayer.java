package src;

/**
 * Created by Lucien.Minot on 7/31/2015.
 */
public interface MessageDisplayer {

   public boolean createBoardError();

   public boolean movesMade(int moveNumber);

   public boolean shuffleError();

   public boolean newBoardDispalyMessage();

   public boolean howToMoveMessage();

   public boolean moveUpErrorMessage();

   public boolean moveDownErrorMessage();

   public boolean moveLeftErrorMessage();

   public boolean moveRightErrorMessage();

   public boolean invalidMoveMessage();

   public boolean quittingGameMessage();
}
