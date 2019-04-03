package com.patryk.app;

import com.patryk.app.game_logic.Board;
import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 */

class TurnManager {

    /**
     * TODO kurwa mać. Po kiego chuja pchasz wszędzie ten board?
     */

    private OutputAPI outputAPI;
    private InputAPI inputAPI;
    private GameLogicAPI gameLogicAPI;
    boolean doWeHaveAWinner = false;
    boolean doWeHaveADraw = false;
    private int intRow;
    private int intColumn;

    TurnManager(InputAPI inputAPI, OutputAPI outputAPI, GameLogicAPI gameLogicAPI) {
        this.gameLogicAPI = gameLogicAPI;
        this.inputAPI = inputAPI;
        this.outputAPI = outputAPI;
    }

    void doATurn() {
        gameLogicAPI.displayBoard();
        makeSureMoveIsValid(); // tego ifa może tu nie być, a i tak zadziała
        putMarkerOntoBoard(intRow, intColumn);

        if (thereIsAWinner()) {
            finalizeRoundWinnerIsPresent();
        }
        if (turnHasEnded()) {
            finalizeRoundWeHaveADraw();
        }
        gameLogicAPI.switchTurns();
    }

    private void finalizeRoundWinnerIsPresent() {
        gameLogicAPI.displayBoard();
        printWinner();
        doWeHaveADraw = true;
        doWeHaveAWinner = true;
    }

    private boolean thereIsAWinner() {
        return gameLogicAPI.checkIfCurrentPlayerWon(gameLogicAPI.getCoordinates());
    }

    private void finalizeRoundWeHaveADraw() {
        gameLogicAPI.displayBoard();
        outputAPI.printMessageToUserNextLine("itsADraw");
        doWeHaveADraw = true;
        doWeHaveAWinner = true;
    }

    private boolean turnHasEnded() {
        return !doWeHaveAWinner && gameLogicAPI.checkIfThereIsADraw();
    }

    boolean checkIfGameEnded() {
        return doWeHaveADraw || doWeHaveAWinner;
    }

    private String getValidRowFromUser() {
        String row;
        do {
            outputAPI.printMessageToUserNextLine("insertRowNumber");
            row = inputAPI.getInputFromUser();
        } while (!inputAPI.validateRow(row, gameLogicAPI.getCurrentConfig().rows));
        return row;
    }

    private String getValidColumnFromUser() {
        String column; // row a nie column
        do {
            outputAPI.printMessageToUserNextLine("insertColumnNumber");
            column = inputAPI.getInputFromUser();
        } while (!inputAPI.validateRow(column, gameLogicAPI.getCurrentConfig().rows));
        return column;
    }

    private void putMarkerOntoBoard(int validRow, int validColumn) {
        gameLogicAPI.setCoordinates(validRow, validColumn);
        gameLogicAPI.putMarkerOntoBoard(gameLogicAPI.getCoordinates(), gameLogicAPI.getCurrentPlayer());
    }

    private void printWinner() {
        outputAPI.printMessageToUserInLine("player");
        outputAPI.printInLine(": " + gameLogicAPI.getCurrentPlayer().getName() + " ");
        outputAPI.printMessageToUserNextLine("won");
    }

    private void makeSureMoveIsValid() {
        boolean isMoveValid;
        do {
            intRow = Integer.valueOf(getValidRowFromUser());
            intColumn = Integer.valueOf(getValidColumnFromUser());
            isMoveValid = gameLogicAPI.checkIfMoveIsLegal(intRow - 1, intColumn - 1);
            if (!isMoveValid) {
                outputAPI.printMessageToUserNextLine("spotIsAlreadyTaken");
            }
        } while (!isMoveValid);
    }
}


