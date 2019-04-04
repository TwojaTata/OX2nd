package com.patryk.app.game_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stores all configuration for current board,
 * once given config, board has all information to
 * be created
 *
 * @author Patryk Kucharski
 */
class BoardConfig {

    int rows;
    int columns;
    int winningConditionLength;
    List<Player> players;

    BoardConfig(int rows, int columns, int winningConditionLength) {
        this.rows = rows;
        this.columns = columns;
        this.winningConditionLength = winningConditionLength;
        players = new ArrayList<>(2);
    }

    /**
     *
     * @param rows                   rows of board
     * @param columns                columns of board
     * @param winningConditionLength winning condition to fulfill
     * @param players                List of players who are playing game
     * @return                       returns same object instance with changed config
     */
    BoardConfig setBoardConfig(int rows, int columns, int winningConditionLength, List<Player> players){

        this.rows = rows;
        this.columns = columns;
        this.winningConditionLength = winningConditionLength;
        this.players = players;
        return this;
    }

    void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * returns player that has hasTurn variable set to true
     */

    Player getCurrentPlayer(Board board){
        return board.getCurrentBoardConfig().players.stream()
                .filter(Player::hasTurn)
                .collect(Collectors.toList())
                .get(0);
    }

    /**
     * switches turns after player did his move
     */
    void switchTurns(){
        for (Player player : players
        ) {
            if (player.hasTurn()) {
                player.setTurn(false);
            } else {
                player.setTurn(true);
            }
        }
    }
}
