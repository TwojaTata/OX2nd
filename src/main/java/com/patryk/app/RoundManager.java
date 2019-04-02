package com.patryk.app;

import com.patryk.app.game_logic.Board;
import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 */
class RoundManager {

    private final TurnManager turnManager;
    private final InputAPI inputAPI;
    private final OutputAPI outputAPI;
    private final GameLogicAPI gameLogicAPI;
    private int numberOfRounds;
    private boolean weHaveAWinner = false;
    private boolean weHaveADraw = false;

    RoundManager(OutputAPI outputAPI, InputAPI inputAPI, int numberOfRounds) {
        this.inputAPI = inputAPI;
        this.outputAPI = outputAPI;
        this.numberOfRounds = numberOfRounds;
        this.gameLogicAPI = new GameLogicAPI();
        turnManager = new TurnManager(inputAPI, outputAPI, gameLogicAPI);

    }

    void doMainLoop(Board board) {

        for (int i = 0; i < numberOfRounds; i++) {
            gameLogicAPI.resetBoard(board);
            doARound(board, i);
            if (weHaveAWinner || weHaveADraw) {
                break;
            }
        }

        //TODO implement
    }

    void doARound(Board board, int roundNumber) {

        outputAPI.printMessageToUserNextLine("RoundNumber");
        outputAPI.printInLine(String.valueOf(numberOfRounds));

        while (!weHaveAWinner || !weHaveADraw) {
            turnManager.doATurn(board);
        }

    }

    void giveAwayPointsToPlayers() {
        // TODO: 02.04.19 implement
    }


//            Player currentPlayer = gameLogicAPI.getCurrentPlayer();
//            gameLogicAPI.displayBoard();
//            outputAPI.printCurrentPlayer(board);
//            validateMove(board);
//            boardServiceAPI.putMarker(board, row - 1, column - 1, currentPlayer);
//            if (boardServiceAPI.checkIfCurrentPlayerWon(row - 1, column - 1, board)) {
//                boardServiceAPI.displayBoard(board);
//                outputAPI.printMessageToUserInLine("player");
//                outputAPI.printMessage(currentPlayer.getName());
//                outputAPI.printMessageToUserInLine("won");
//                outputAPI.printMessage("");
//                doWeHaveAWinner = true;
//                doWeHaveADraw = true;
//            }
//            if (!doWeHaveAWinner) {
//                if (boardServiceAPI.checkIfTheresADraw(board)) {
//                    boardServiceAPI.displayBoard(board);
//                    outputAPI.printMessageToUserNextLine("itsADraw");
//                    doWeHaveADraw = true;
//                    doWeHaveAWinner = true;
//                }
//            }
//            boardServiceAPI.switchTurns(board);
//        }
//

    // TODO: 02.04.19 implement

}

