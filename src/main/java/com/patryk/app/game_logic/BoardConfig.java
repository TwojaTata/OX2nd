package com.patryk.app.game_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Patryk Kucharski
 */
public class BoardConfig {

    int rows;
    int columns;
    int winningConditionLength;
    List<Player> players;

    private BoardConfig(int rows, int columns, int winningConditionLength) {
        this.rows = rows;
        this.columns = columns;
        this.winningConditionLength = winningConditionLength;
        players = new ArrayList<>(2);
    }

    BoardConfig setBoardConfig(int rows, int columns, int winningConditionLength){
        this.rows = rows;
        this.columns = columns;
        this.winningConditionLength = winningConditionLength;
        return this;
    }

    BoardConfig setDefaultBoardConfig(){
        BoardConfig boardConfig = new BoardConfig(3,3,3);
        boardConfig.addPlayer(new Player("Player1",true, Marker.CIRCLE, 0));
        boardConfig.addPlayer(new Player("Player2",false, Marker.CROSS, 0));
        return boardConfig;
    }

    void addPlayer(Player player) {
        //todo validate null
        players.add(player);
    }

    Player getCurrentPlayer(){
        return players.stream()
                .filter(Player::hasTurn)
                .collect(Collectors.toList())
                .get(0);
    }

    void switchTurns(Board board){
        for (Player player : board.getCurrentBoardConfig().players
        ) {
            if (player.hasTurn()) {
                player.setTurn(false);
            } else {
                player.setTurn(true);
            }
        }
    }

    @Override
    public String toString() {
        return "BoardConfig{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", winningConditionLength=" + winningConditionLength +
                ", players=" + players +
                '}';

        //todo zaimplementowac
    }
}
