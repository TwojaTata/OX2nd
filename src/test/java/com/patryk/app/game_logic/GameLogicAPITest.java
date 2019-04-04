package com.patryk.app.game_logic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

import static org.testng.Assert.*;

/**
 * @author Patryk Kucharski
 */

@Test
public class GameLogicAPITest {

    @DataProvider(name = "fillBoardWithBlanksDP")
    public static Object[][] fillBoardWithBlanksDP() {

        return new Object[][]{
                {3, 3, 3, 2, 1, 2, 1},
                {4, 3, 4, 2, 2, 2, 1},
                {5, 3, 3, 2, 3, 2, 1},
                {3, 5, 3, 1, 2, 2, 1},
                {13, 23, 5, 5, 3, 2, 1},
                {33, 43, 6, 23, 30, 2, 1},
                {10, 18, 8, 8, 9, 2, 1},};
    }

    @Test(dataProvider = "fillBoardWithBlanksDP")
    public void testFillBoardWithBlanks(int rows, int columns, int winningCondition, int row1, int row2, int row3, int column) {
        Player player = new Player("player", true, Marker.CIRCLE, 0);
        Board board = new Board(new BoardConfig(rows, columns, winningCondition));
        board.putMarker(new Coordinates(row1, column), player);
        board.putMarker(new Coordinates(row2, column), player);
        board.putMarker(new Coordinates(row3, column), player);
        board.fillBoardWithBlanks();
        assert board.getCurrentBoard()[row2][column].equals(Marker.BLANK);
    }

    @DataProvider(name = "putMarkerDP")
    public static Object[][] putMarkerDP() {
        return new Object[][]{{Marker.CIRCLE, 3, 3, 3, 1, 1},
                {Marker.CROSS, 5, 8, 3, 4, 2},
                {Marker.CIRCLE, 15, 20, 3, 10, 10},
                {Marker.CROSS, 30, 40, 3, 29, 29},
                {Marker.CIRCLE, 10, 10, 3, 4, 7},
        };
    }

    @Test(dataProvider = "putMarkerDP")
    public void testPutMarkerOntoBoard(Marker marker, int rows, int columns, int winningCondition, int row, int column) {
        Player player = new Player("player", true, marker, 0);
        Board board = new Board(new BoardConfig(rows, columns, winningCondition));
        board.fillBoardWithBlanks();
        board.putMarker(new Coordinates(row, column), player);
        assert (board.getCurrentBoard()[row][column]).equals(player.getMarker());
    }

    @Test
    public void testCheckIfCurrentPlayerWon() {
        GameLogicAPI gameLogicAPI = new GameLogicAPI();
        Board board = gameLogicAPI.getCurrentBoardState();
        GameJudge gameJudge = new GameJudge(board);
        Player player = board.getCurrentBoardConfig().getCurrentPlayer(board);
        board.putMarker(new Coordinates(0, 0), player);
        board.putMarker(new Coordinates(1, 1), player);
        board.putMarker(new Coordinates(2, 2), player);
        assert gameJudge.checkIfCurrentPlayerWon(new Coordinates(2,2));
    }
}