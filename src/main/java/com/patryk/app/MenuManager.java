package com.patryk.app;

import com.patryk.app.game_logic.Board;
import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * Main menu and helping methods
 *
 * @author Patryk Kucharski
 */
class MenuManager {

    private OutputAPI outputAPI;
    private InputAPI inputAPI;
    private GameLogicAPI gameLogicAPI;
    private RoundManager roundManager;
    private SettingsManager settingsManager;

    MenuManager(OutputAPI outputAPI, InputAPI inputAPI, int numberOfRounds) {
        this.outputAPI = outputAPI;
        this.inputAPI = inputAPI;
        gameLogicAPI = new GameLogicAPI();
        roundManager = new RoundManager(gameLogicAPI, outputAPI, inputAPI, numberOfRounds);
        settingsManager = new SettingsManager(outputAPI, inputAPI);
    }

    void runMenu() {
        String userAnswer;
        outputAPI.printMessageToUserNextLine("welcomeToTheGame");
        do {
            outputAPI.displayMenu();
            userAnswer = inputAPI.getInputFromUser();
            switch (userAnswer) {
                case "1": {
                    roundManager.doMainLoop();
                    break;
                }
                case "2": {
                    getConfigFromUser();
                    break;
                }
                case "3": {
                    outputAPI.displayLanguageMenu();
                    getLanguageFromUser();
                    break;
                }
                case "exit": {
                    outputAPI.printMessageToUserNextLine("thankYouForPlaying");
                    break;
                }
                default: {
                    outputAPI.printMessageToUserNextLine("noSuchOption");
                }
            }
        } while (!isInputGivenString(userAnswer, "exit"));
    }

    private boolean isInputGivenString(String userAnswer, String string) {
        return userAnswer.toLowerCase().equals(string);
    }

    private void getLanguageFromUser() {
        boolean isLanguageValid = false;
        String language;
        do {
            language = inputAPI.getInputFromUser();
            if (isInputGivenString(language, "exit")) {
                return;
            }
            if (isInputGivenString(language, "pl") || isInputGivenString(language, "eng")) {
                outputAPI.setLanguage(language.toLowerCase(), language.toUpperCase());
                isLanguageValid = true;
            } else {
                outputAPI.printMessageToUserNextLine("noSuchOption");
            }
        } while (!isLanguageValid);
    }

    private void getConfigFromUser() {
        Board board = new Board(gameLogicAPI.createNewBoardConfig(
                settingsManager.getDimensionFromUser("rows"),
                settingsManager.getDimensionFromUser("columns"),
                settingsManager.getWinningConditionFromUser(),
                settingsManager.getPlayersInfoFromUser()));
        gameLogicAPI.setBoard(board);
        gameLogicAPI.fillBoardWithBlanks();
    }
}
