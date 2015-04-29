package tests;

import console_utils.TextDevice;
import console_utils.TextDevices;
import org.junit.Test;
import src.*;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by Lucien.Minot on 4/14/2015.
 */
public class RunnerTests implements Runner {

    Runner newGame = new GameRunner(TextDevices.defaultTextDevice());


    @Override
    public void start() {

    }

//    @Test
//    public void itRunsTheGame() throws Exception
//    {
//        newGame.start();
//    }

//    @Test
//    public void itTakesUserInputForBoardSize(){
//
//        final String input = "2";
//        BufferedReader reader = new BufferedReader(new StringReader(input));
//        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));
//        //GameRunner game = new GameRunner(fake);
//
//        newGame = new GameRunner(fakePlayer);
//        newGame.start();
//
//
//    }
//
//    @Test
//     public void itTakesUserInputForShuffles(){
//
//        GameBoard gameBoard = new GameBoard();
//
//        gameBoard.setSize(3);
//        gameBoard.createBoard();
//
//        final String input = "5";
//        BufferedReader reader = new BufferedReader(new StringReader(input));
//        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));
//        GameRunner game = new GameRunner(fakePlayer);
//
//        game.shuffle();
//
//    }

//    @Test
//    public void itTakesUserInputForMovement(){
//
//        itTakesUserInputForShuffles();
//
//        final String input = "2";
//        BufferedReader reader = new BufferedReader(new StringReader(input));
//        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));
//        GameRunner game = new GameRunner(fakePlayer);
//
//        game.moveReader();
//        game.moveReader();
//
//    }
}
