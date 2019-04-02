package com.patryk.app.game_logic;

import java.util.List;

/**
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
    }

    void setBoardConfig(int rows, int columns, int winningConditionLength){
        this.rows = rows;
        this.columns = columns;
        this.winningConditionLength = winningConditionLength;
    }

    void addPlayer(Player player) {

        //todo validate null
        players.add(player);
    }
}
