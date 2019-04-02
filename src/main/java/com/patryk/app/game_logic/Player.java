package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
class Player {

    private final String name;
    private boolean hasTurn;
    private final Marker marker;

    public Player(String name, boolean hasTurn, Marker marker) {
        this.name = name;
        this.hasTurn = hasTurn;
        this.marker = marker;
    }

    public Marker getMarker() {
        return marker;
    }

    public boolean hasTurn() {
        return hasTurn;
    }

    public void setTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }


}
