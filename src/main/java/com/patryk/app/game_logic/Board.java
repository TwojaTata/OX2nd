package com.patryk.app.game_logic;

import java.util.Arrays;

/**
 * @author Patryk Kucharski
 */
public class Board {

    private final Marker[][] board;
    private BoardConfig boardConfig;

    Board(BoardConfig boardConfig){
        board = new Marker[boardConfig.rows][boardConfig.columns];
        this.boardConfig = boardConfig;
    }

    Marker[][] getCurrentBoard(){
        return board;
    }

    BoardConfig getCurrentBoardConfig(){
        return  boardConfig;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                ", boardConfig=" + boardConfig +
                '}';

        //todo drukowanie!!! stołu
    }
    /**
     * Sets up a board filled with Marker.BLANK enum,
     * which is initial state of board
     */

    Board fillBoardWithBlanks() {
        for (int i = 0; i < boardConfig.rows; i++) {
            for (int j = 0; j < boardConfig.columns; j++) {
                board[i][j] = Marker.BLANK;
            }
        }
        return this;
    }

    /**
     * @param coordinates   coordinates of target field for marker
     * @param currentPlayer player who currently has turn
     *                      <p>
     *                      Puts given marker in specified position on board
     */

    void putMarker(Coordinates coordinates, Player currentPlayer) {
        board[coordinates.row][coordinates.column] = currentPlayer.getMarker();
    }

    Board initializeDefaultBoard(){
        Board board = new Board(boardConfig.setDefaultBoardConfig());
        board.fillBoardWithBlanks();
        return board;
    }
}
