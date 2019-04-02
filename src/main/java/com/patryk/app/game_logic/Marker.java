package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
enum Marker {

    CROSS("X"), CIRCLE("O"), BLANK(" ");
    public final String valueToDisplay;

    Marker(String valueToDisplay) {
        this.valueToDisplay = valueToDisplay;
    }

}
