package src;

import java.util.Arrays;

/**
 * Created by Lucien.Minot on 10/2/2014.
 */
public class GameBoard implements GameUtilities {

    public static int size;
    public static Object[][] gameBoard;
    public static Object[][] winningBoard;

    @Override
    public Object[][] createBoard(){

        gameBoard = new Object[size][size];
        int k = 1;
        //puts values inside the game board based off the size passed in
        for(int i = 0; i <size; i++)
            for (int j = 0; j < size; j++) {
                gameBoard[i][j] = k;
                k++;
            }
       gameBoard[size-1][size-1] = 0;
       return gameBoard;
    }

    @Override
    public void setSize(int gameBoardSize) {
        size = gameBoardSize;
    }

    @Override
    public boolean isWinner(){
        createWinningBoard();
             if(GameMovements.hasShuffled) {
                 if (Arrays.deepEquals(winningBoard, gameBoard)) {
                     System.out.println("YOU WIN!!!!");
                     return true;
                 }
             }
        return false;
    }

    public static Object[][] createWinningBoard(){

        winningBoard = new Object[size][size];
        int k = 1;
        for(int i = 0; i <size; i++)
            for (int j = 0; j < size; j++) {
                winningBoard[i][j] = k;
                k++;
            }
        winningBoard[size-1][size-1] = 0;
        return winningBoard;
    }
}
