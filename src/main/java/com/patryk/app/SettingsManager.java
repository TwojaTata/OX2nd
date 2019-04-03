package com.patryk.app;

import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.game_logic.Marker;
import com.patryk.app.game_logic.Player;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patryk Kucharski
 */
class SettingsManager {

    private GameLogicAPI gameLogicAPI;
    private InputAPI inputAPI;
    private OutputAPI outputAPI;
    private int rows;
    private int columns;

    SettingsManager(GameLogicAPI gameLogicAPI, OutputAPI outputAPI, InputAPI inputAPI) {
        this.gameLogicAPI = gameLogicAPI;
        this.inputAPI = inputAPI;
        this.outputAPI = outputAPI; //todo strzelic sobie w lep
    }

    int getDimensionFromUser(String dimensionKey) {
        String userAnswer;
        do {
            outputAPI.printMessageToUserInLine("insertNumberOfDimension");
            outputAPI.printMessageToUserNextLine(dimensionKey);
            userAnswer = inputAPI.getInputFromUser();
        } while (!validateDimension(userAnswer));
        if (dimensionKey.equals("rows")) {
            rows = Integer.valueOf(userAnswer);
        } else {
            columns = Integer.valueOf(userAnswer);
        }
        return Integer.valueOf(userAnswer);
    }

    private boolean validateDimension(String dimension) {
        int dimensionInt;

        if (dimension == null) {
            return false;
        }
        try {
            dimensionInt = Integer.valueOf(dimension);
        } catch (NumberFormatException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            return false;
        }
        if (dimensionInt < 3) {

            outputAPI.printMessageToUserNextLine("dimensionTooSmall");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (dimensionInt > 99) {
            outputAPI.printMessageToUserNextLine("dimensionTooBig");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        return true;
    }

    int getWinningConditionFromUser() {
        String userAnswer;
        do {
            outputAPI.printMessageToUserNextLine("insertWinningCondition");
            userAnswer = inputAPI.getInputFromUser();
        } while (!validateWiningCondition(userAnswer, getBiggerDimension(rows, columns)));
        return Integer.valueOf(userAnswer);

    }

    private boolean validateWiningCondition(String winingCondition, int biggerBoardDimension) {
        int winingConditionInt;

        if (winingCondition == null) {
            return false;
        }
        try {
            winingConditionInt = Integer.valueOf(winingCondition);
        } catch (NumberFormatException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (winingConditionInt < 3) {
            outputAPI.printMessageToUserNextLine("winingConditionTooSmall");
            return false;
        }
        if (winingConditionInt > biggerBoardDimension) {
            outputAPI.printMessageToUserNextLine("conditionImpossibleToFulfill");
            return false;
        }
        return true;
    }

    private int getBiggerDimension(int rows, int columns) {
        if (rows > columns) {
            return rows;
        }
        return columns;
    }

    List<Player> getPlayersInfoFromUser() {
        String userAnswerPlayerOneName;
        String userAnswerPlayerTwoName;
        String markerPlayerOne;
        List<Player> players = new ArrayList<>(2);

        do {
            outputAPI.printMessageToUserNextLine("insertNameOf1Player");
            userAnswerPlayerOneName = inputAPI.getInputFromUser();
        } while (!validateName(userAnswerPlayerOneName));

        do {
            outputAPI.printMessageToUserNextLine("insertMarker");
            outputAPI.print(userAnswerPlayerOneName + " (O,X)");
            markerPlayerOne = inputAPI.getInputFromUser();
        } while (!validateMarker(markerPlayerOne));

        do {
            outputAPI.printMessageToUserNextLine("insertNameOf2Player");
            userAnswerPlayerTwoName = inputAPI.getInputFromUser();
        } while (!validateName(userAnswerPlayerTwoName));

        players.add(new Player(userAnswerPlayerOneName, true, getMarkerBasedOnUserAnswer(markerPlayerOne).get(0), 0));
        players.add(new Player(userAnswerPlayerTwoName, false, getMarkerBasedOnUserAnswer(markerPlayerOne).get(1), 0));
        return players;
    }

    private List<Marker> getMarkerBasedOnUserAnswer(String markerPlayerOne) {

        List<Marker> markers = new ArrayList<>(2);

        if (markerPlayerOne.toLowerCase().equals("o") || markerPlayerOne.toLowerCase().equals("0") || markerPlayerOne.toLowerCase().equals("circle")) {
            markers.add(Marker.CIRCLE);
            markers.add(Marker.CROSS);
        }
        if (markerPlayerOne.toLowerCase().equals("x") || markerPlayerOne.toLowerCase().equals("+") || markerPlayerOne.toLowerCase().equals("cross")) {
            markers.add(Marker.CROSS);
            markers.add(Marker.CIRCLE);
        }
        return markers;

    }

    private boolean validateName(String name) {
        if (name == null) {
            return false;
        }
        if (name.length() > 30) {
            outputAPI.printMessageToUserNextLine("nameTooLong");
            outputAPI.printMessageToUserNextLine("insertProperName");

            return false;
        }
        return true;
    }

    private boolean validateMarker(String markerPlayerOne) {

        if (markerPlayerOne == null) {
            return false;
        }
        if (markerPlayerOne.toLowerCase().equals("x") || markerPlayerOne.toLowerCase().equals("o")) {
            return true;
        }
        outputAPI.printMessageToUserNextLine("notSureWhatYouMean");
        outputAPI.printMessageToUserNextLine("insertMarkerAgain");
        return false;
    }
}