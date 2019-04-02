package com.patryk.app;

import com.patryk.app.game_logic.Board;
import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.game_logic.Player;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 */
class TurnManager {

    private OutputAPI outputAPI;
    private InputAPI inputAPI;
    private GameLogicAPI gameLogicAPI;
    private String row, column;
    private boolean doWeHaveAWinner;
    private boolean doWeHaveADraw;

    TurnManager(InputAPI inputAPI, OutputAPI outputAPI, GameLogicAPI gameLogicAPI) {
        this.gameLogicAPI = gameLogicAPI;
        this.inputAPI = inputAPI;
        this.outputAPI = outputAPI;
    }

    void doATurn(Board board) {
        //TODO implement

        gameLogicAPI.getCurrentBoardState().toString();//todo to zamienic na wyświetlanie
        outputAPI.printMessageToUserNextLine("insertRow");
        row = inputAPI.getInputFromUser();
        outputAPI.printMessageToUserNextLine("insertColumn");
        column = inputAPI.getInputFromUser();
        //   gameLogicAPI.setCoordinates();//todo w tej metodzie odnośnik do validacji
        gameLogicAPI.putMarkerOntoBoard(gameLogicAPI.getCoordinates(), gameLogicAPI.getCurrentPlayer());

        if (gameLogicAPI.checkIfCurrentPlayerWon(gameLogicAPI.getCoordinates())) {
            gameLogicAPI.getCurrentBoardState().toString();
            outputAPI.printMessageToUserInLine("player");
        //    outputAPI.printInLine(" :" + gameLogicAPI.getCurrentPlayer().getName());
            outputAPI.printMessageToUserInLine("won");
            outputAPI.printMessageToUserNextLine("");
            doWeHaveADraw = true;
            doWeHaveAWinner = true;
        }
        if (!doWeHaveAWinner) {
            if (gameLogicAPI.checkIfThereIsADraw(board)) {
                gameLogicAPI.getCurrentBoardState().toString();
                outputAPI.printMessageToUserNextLine("itsADraw");
                doWeHaveADraw = true;
                doWeHaveAWinner = true;
            }
        }
        gameLogicAPI.switchTurns(board);
    }
}
//
//
//        Player currentPlayer = boardServiceAPI.getCurrentPLayer(board);
//        boardServiceAPI.displayBoard(board);
//        outputAPI.printCurrentPlayer(board);
//        validateMove(board);
//        boardServiceAPI.putMarker(board, row - 1, column - 1, currentPlayer);
//        if (boardServiceAPI.checkIfCurrentPlayerWon(row - 1, column - 1, board)) {
//            boardServiceAPI.displayBoard(board);
//            outputAPI.printMessageToUserInLine("player");
//            outputAPI.printMessage(currentPlayer.getName());
//            outputAPI.printMessageToUserInLine("won");
//            outputAPI.printMessage("");
//            doWeHaveAWinner = true;
//            doWeHaveADraw = true;
//        }
//        if (!doWeHaveAWinner) {
//            if (boardServiceAPI.checkIfTheresADraw(board)) {
//                boardServiceAPI.displayBoard(board);
//                outputAPI.printMessageToUserNextLine("itsADraw");
//                doWeHaveADraw = true;
//                doWeHaveAWinner = true;
//            }
//        }
//        boardServiceAPI.switchTurns(board);
//    }

