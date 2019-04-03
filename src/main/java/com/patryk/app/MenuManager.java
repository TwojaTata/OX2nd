package com.patryk.app;

import com.patryk.app.game_logic.GameLogicAPI;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

import java.io.InputStream;

/**
 * @author Patryk Kucharski
 */
class MenuManager {

    private OutputAPI outputAPI;
    private InputAPI inputAPI;
    private GameLogicAPI gameLogicAPI;
    private RoundManager roundManager;
    private boolean isLanguageValid = false;

    MenuManager(InputStream inputStream) {
        outputAPI = new OutputAPI();
        inputAPI = new InputAPI(inputStream, outputAPI);
        gameLogicAPI = new GameLogicAPI();
        roundManager = new RoundManager(gameLogicAPI, outputAPI, inputAPI, 3);
    }

    void runMenu() {

        String userAnswer;
        outputAPI.printMessageToUserNextLine("welcomeToTheGame");
        do {
            outputAPI.displayMenu();
            userAnswer = inputAPI.getInputFromUser();
            switch (userAnswer) {
                case "1": {
                    roundManager.doMainLoop(gameLogicAPI.getCurrentBoardState());
                    break;
                }
                case "2": {
                    setGameConfig();//todo moduł do ustawiania stołu
                    break;
                }
                case "3": {
                    outputAPI.displayLanguageMenu();
                    setLanguage();
                    break;
                }
                default: {
                    if (userAnswer.toLowerCase().equals("exit")) {
                        outputAPI.printMessageToUserNextLine("thankYouForPlaying");//todo do resource bundle to
                        break;
                    } else {
                        outputAPI.printMessageToUserNextLine("noSuchOption");
                        break;
                    }
                }
            }
        } while (!userAnswer.toLowerCase().equals("exit"));
    }

    private void setLanguage() {
        String language;
        do {
            language = inputAPI.getInputFromUser();
            if (language.toLowerCase().equals("pl") || language.toLowerCase().equals("eng")) {
                outputAPI.setLanguage(language.toLowerCase(), language);
                isLanguageValid = true;
            }
        } while (!isLanguageValid);

    }

    private void setGameConfig() {


        //todo implement
    }
}
