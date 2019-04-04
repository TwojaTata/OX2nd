package com.patryk.app.game_logic;

/**
 *
 * represents markers to be put on board
 * @author Patryk Kucharski
 */
public enum Marker {

    CROSS("X"), CIRCLE("O"), BLANK(" ");
    public final String valueToDisplay;

    Marker(String valueToDisplay) {
        this.valueToDisplay = valueToDisplay;
    }

}
