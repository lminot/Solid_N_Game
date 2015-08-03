package src;

/**
 * Created by Lucien.Minot on 7/31/2015.
 */
public class MessageHandler implements MessageDisplayer{
    String boardError = "Error please enter a number greater than 1...";
    String movesMade = "Moves made: ";
    String shuffleError = "Error please enter a number greater than 0...";

    public String showError() {
        return "error";
    }

    public boolean createBoardError() {
        System.out.println(boardError);
        return true;
    }

    public boolean movesMade(int moveNumber) {
       //int movesMade = GameMovements.moveCount;
        System.out.println(movesMade + moveNumber);
        return true;
    }

    public boolean shuffleError() {
        System.out.println(shuffleError);
        return true;
    }
}
