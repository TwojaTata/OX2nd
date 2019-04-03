package com.patryk.app;

import com.patryk.app.game_logic.Board;
import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 */

class TurnManager {

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

    void doATurn(Board board) {
        gameLogicAPI.displayBoard();
        if (validateMove(board)) {
            putMarkerOntoBoard(intRow, intColumn, board);
        }
        if (thereIsAWinner()) {
            finalizeRoundWinnerIsPresent(board);
        }
        if (turnHasEnded(board)) {
            finalizeRoundWeHaveADraw();
        }
        gameLogicAPI.switchTurns(board);
    }

    private void finalizeRoundWinnerIsPresent(Board board) {
        gameLogicAPI.displayBoard();
        printWinner(board);
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

    private boolean turnHasEnded(Board board) {
        return !doWeHaveAWinner && gameLogicAPI.checkIfThereIsADraw(board);
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
        String column;
        do {
            outputAPI.printMessageToUserNextLine("insertColumnNumber");
            column = inputAPI.getInputFromUser();
        } while (!inputAPI.validateRow(column, gameLogicAPI.getCurrentConfig().rows));
        return column;
    }

    private void putMarkerOntoBoard(int validRow, int validColumn, Board board) {
        gameLogicAPI.setCoordinates(validRow, validColumn);
        gameLogicAPI.putMarkerOntoBoard(gameLogicAPI.getCoordinates(), gameLogicAPI.getCurrentPlayer(board));
    }

    private void printWinner(Board board) {
        outputAPI.printMessageToUserInLine("player");
        outputAPI.printInLine(": " + gameLogicAPI.getCurrentPlayer(board).getName());
        outputAPI.printMessageToUserInLine("won");
        outputAPI.print("");
    }

    private boolean validateMove(Board board) {
        boolean isMoveValid;
        do {
            intRow = Integer.valueOf(getValidRowFromUser());
            intColumn = Integer.valueOf(getValidColumnFromUser());
            isMoveValid = gameLogicAPI.checkIfMoveIsLegal(intRow - 1, intColumn - 1, board);
            if (!isMoveValid) {
                outputAPI.printMessageToUserNextLine("spotIsAlreadyTaken");
            }
        } while (!isMoveValid);
        return true;
    }
}


