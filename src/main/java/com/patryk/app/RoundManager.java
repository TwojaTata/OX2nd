package com.patryk.app;

import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.game_logic.Player;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 */
class RoundManager {

    private final TurnManager turnManager;

    private final OutputAPI outputAPI;
    private final GameLogicAPI gameLogicAPI;
    private int numberOfRounds;
    private Player startingPlayer;
    private boolean weHaveAWinner = false;
    private boolean weHaveADraw = false; // WTF?

    RoundManager(GameLogicAPI gameLogicAPI, OutputAPI outputAPI, InputAPI inputAPI, int numberOfRounds) {
        this.outputAPI = outputAPI;
        this.numberOfRounds = numberOfRounds;
        this.gameLogicAPI = gameLogicAPI;
        turnManager = new TurnManager(inputAPI, outputAPI, gameLogicAPI);
        startingPlayer = gameLogicAPI.getCurrentPlayer();
    }

    void doMainLoop() {

        for (int i = 0; i < numberOfRounds; i++) {
            gameLogicAPI.resetBoard();
            resetGameOutcome();
            doARound(i);
            changeStartingPlayer();
            if (weHaveAWinner || weHaveADraw) {
                break;
            }
        }
    }

    private void changeStartingPlayer() {

    }

    private void doARound(int roundNumber) {
        boolean gameEnded;
        gameEnded = false;
        outputAPI.printMessageToUserInLine("RoundNumber");
        outputAPI.print(String.valueOf(roundNumber + 1));
        while (!gameEnded) {
            turnManager.doATurn();
            gameEnded = turnManager.checkIfGameEnded();
        }
    }

    private void resetGameOutcome() {
        turnManager.doWeHaveAWinner = false;
        turnManager.doWeHaveADraw = false;
    }

    void giveAwayPointsToPlayers() {
        // TODO: 02.04.19 implement
    }
}

