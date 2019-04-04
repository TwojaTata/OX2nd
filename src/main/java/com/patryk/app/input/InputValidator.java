package com.patryk.app.input;

import com.patryk.app.output.OutputAPI;

/**
 * validates user input
 *
 * @author Patryk Kucharski
 */
class InputValidator {

    private OutputAPI outputAPI;

    InputValidator(OutputAPI outputAPI) {
        this.outputAPI = outputAPI;
    }

    boolean validateRow(String row, int rows) {
        int rowInt;

        try {
            rowInt = Integer.valueOf(row);
        } catch (IllegalArgumentException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (rowInt < 1) {
            outputAPI.printMessageToUserNextLine("noSuchField");
            return false;
        }
        if (rowInt > rows) {
            outputAPI.printMessageToUserNextLine("outOfBoard");
            return false;
        }
        return true;
    }

    boolean validateColumn(String column, int columns) {
        int columnsInt;

        try {
            columnsInt = Integer.valueOf(column);
        } catch (IllegalArgumentException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (columnsInt < 1) {
            outputAPI.printMessageToUserNextLine("noSuchField");
            return false;
        }
        if (columnsInt > columns) {
            outputAPI.printMessageToUserNextLine("outOfBoard");
            return false;
        }
        return true;
    }
}
