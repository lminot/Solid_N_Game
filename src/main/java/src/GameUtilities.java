package src;

/**
 * Created by Lucien.Minot on 4/14/2015.
 */
public interface GameUtilities {

    boolean isWinner();

    Object[][] createBoard();

    public void setSize(int gameBoardSize);

}
