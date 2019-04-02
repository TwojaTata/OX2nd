package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
public class Board {

    private final Marker[][] board;
    private BoardConfig boardConfig;

    public Board(BoardConfig boardConfig){
        board = new Marker[boardConfig.rows][boardConfig.columns];
    }
}
