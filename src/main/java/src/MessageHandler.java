package src;

import utils.PropertyLoader;

/**
 * Created by Lucien.Minot on 7/31/2015.
 */
public class MessageHandler implements MessageDisplayer{

    static PropertyLoader propLoader = new PropertyLoader();
    private static String propFileName = "messages.properties";

    public static String enterBoardSize = propLoader.getPropertyValue(propFileName,"enterBoardSize");
    public static String enterMoveDirection = propLoader.getPropertyValue(propFileName,"enterMoveDirection");
    public static String enterShuffleNumber = propLoader.getPropertyValue(propFileName,"enterShuffleNumber");

    private String newBoardMessage = propLoader.getPropertyValue(propFileName,"newBoardMessage");
    private String howToMakeMoves = propLoader.getPropertyValue(propFileName,"howToMakeMoves");
    private String boardError = propLoader.getPropertyValue(propFileName,"boardError");
    private String movesMade = propLoader.getPropertyValue(propFileName,"movesMade");
    private String shuffleError = propLoader.getPropertyValue(propFileName,"shuffleError");

    private String moveUpError = propLoader.getPropertyValue(propFileName,"moveUpError");
    private String moveDownError = propLoader.getPropertyValue(propFileName,"moveDownError");
    private String moveLeftError = propLoader.getPropertyValue(propFileName,"moveLeftError");
    private String moveRightError = propLoader.getPropertyValue(propFileName,"moveRightError");
    private String invalidMove = propLoader.getPropertyValue(propFileName,"invalidMove");

    private String quittingGame = propLoader.getPropertyValue(propFileName,"quittingGame");

    public boolean createBoardError() {
        System.out.println(boardError);
        return true;
    }

    public boolean movesMade(int moveNumber) {
        System.out.println(movesMade + moveNumber);
        return true;
    }

    public boolean shuffleError() {
        System.out.println(shuffleError);
        return true;
    }

    public boolean newBoardDispalyMessage(){
        System.out.println(newBoardMessage);
        return true;
    }

    public boolean howToMoveMessage(){
        System.out.println(howToMakeMoves);
        return true;
    }

    public boolean moveUpErrorMessage() {
        System.out.println(moveUpError);
        return true;
    }

    public boolean moveDownErrorMessage() {
        System.out.println(moveDownError);
        return true;
    }

    public boolean moveLeftErrorMessage() {
        System.out.println(moveLeftError);
        return true;
    }

    public boolean moveRightErrorMessage(){
        System.out.println(moveRightError);
        return true;
    }

    public boolean invalidMoveMessage(){
        System.out.println(invalidMove);
        return true;
    }

    public boolean quittingGameMessage(){
        System.out.println(quittingGame);
        return true;
    }
}
