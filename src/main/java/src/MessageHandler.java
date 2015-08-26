package src;

import utils.PropertyLoader;

/**
 * Created by Lucien.Minot on 7/31/2015.
 */
public class MessageHandler implements MessageDisplayer{

    static PropertyLoader propLoader = new PropertyLoader();
    private static String fileName = "messages.properties";

    public static String enterBoardSize = propLoader.getPropertyValue(fileName,"enterBoardSize");
    public static String enterMoveDirection = propLoader.getPropertyValue(fileName,"enterMoveDirection");
    public static String enterShuffleNumber = propLoader.getPropertyValue(fileName,"enterShuffleNumber");

    private String newBoardMessage = propLoader.getPropertyValue(fileName,"newBoardMessage");
    private String howToMakeMoves = propLoader.getPropertyValue(fileName,"howToMakeMoves");
    private String boardError = propLoader.getPropertyValue(fileName,"boardError");
    private String movesMade = propLoader.getPropertyValue(fileName,"movesMade");
    private String shuffleError = propLoader.getPropertyValue(fileName,"shuffleError");

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
}
