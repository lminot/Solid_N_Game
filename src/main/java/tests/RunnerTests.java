package tests;

import console.TextDevice;
import console.TextDevices;
import org.junit.Assert;
import org.junit.Test;
import src.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class RunnerTests implements Runner {

    FakeRunner newGame = new FakeRunner(TextDevices.defaultTextDevice());
    GameBoard gameBoard = new GameBoard();
    GameMovements mover = new GameMovements(gameBoard);
    DisplayGame dis = new GameDisplayer(gameBoard);

    @Override
    public void start() {
    }

    @Test
    public void itStartsTheGame() throws IOException {

        final String input = "2";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));

        newGame = new FakeRunner(fakePlayer);
        assertTrue(FakeRunner.gameStarted);
    }

    @Test
    public void itTakesUserInputForGameBoardSize() throws IOException {

        final String input = "4";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));

        newGame = new FakeRunner(fakePlayer);
        newGame.FakeStart();

        assertEquals(Integer.parseInt(input), gameBoard.size);
    }


    @Test
     public void itTakesUserInputForShuffles(){

        gameBoard.setSize(3);
        gameBoard.createBoard();
        dis.display();
        final String input = "5000";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));
        newGame = new FakeRunner(fakePlayer);
        newGame.shuffle();

        assertEquals(Integer.parseInt(input), mover.moveCount);
    }

    @Test
    public void itTakesUserInputForMovement(){

        gameBoard.setSize(3);
        gameBoard.createBoard();
        dis.display();
        final String input = "1";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        TextDevice fakePlayer = TextDevices.characterDevice(reader, new PrintWriter(System.out, true));
        newGame = new FakeRunner(fakePlayer);
        newGame.moveReader();
        dis.display();

        Assert.assertTrue((mover.moveCount > 0));
    }
}
