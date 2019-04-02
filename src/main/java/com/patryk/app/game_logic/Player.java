package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
public class Player {

    private final String name;
    private boolean hasTurn;
    private final Marker marker;
    private int score;

    public Player(String name, boolean hasTurn, Marker marker, int score) {
        this.name = name;
        this.hasTurn = hasTurn;
        this.marker = marker;
        this.score = score;
    }

    Marker getMarker() {
        return marker;
    }

    boolean hasTurn() {
        return hasTurn;
    }

    void setTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }


}
