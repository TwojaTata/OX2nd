package com.patryk.app.game_logic;

import java.util.Objects;

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
    public String getName(){
        return name;
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hasTurn=" + hasTurn +
                ", marker=" + marker +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return hasTurn == player.hasTurn &&
                score == player.score &&
                Objects.equals(name, player.name) &&
                marker == player.marker;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hasTurn, marker, score);
    }
}
