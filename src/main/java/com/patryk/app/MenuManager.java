package com.patryk.app;

import com.patryk.app.game_logic.Board;
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

    MenuManager(InputStream inputStream) {
        outputAPI = new OutputAPI();
        inputAPI = new InputAPI(inputStream);
        gameLogicAPI = new GameLogicAPI();
        roundManager = new RoundManager(outputAPI, inputAPI, 3);
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
                    setGameConfig();
                    break;
                }
                case "3": {
                    setLanguage();
                    break;
                }
                default: {
                    if (userAnswer.toLowerCase().equals("exit")) {
                        outputAPI.printMessageToUserNextLine("ThankYouForPlaying");//todo do resource bundle to
                        break;
                    } else {
                        outputAPI.printMessageToUserNextLine("noSuchOption");
                        break;
                    }
                }
            }
        } while (!userAnswer.equals("exit"));//todo poprawić warunek
    }

    private void setLanguage() {
        //todo implement
//        do {
//            outputAPI.printLanguageMenu();
//            String language = scanner.nextLine();
//            if (language.toLowerCase().equals("pl") || language.toLowerCase().equals("eng")) {
//                outputAPI.setLanguage(language.toLowerCase(), language);
//                isLanguageValid = true;
//            }
//        } while (!isLanguageValid);
    }

    private void setGameConfig() {


        //todo implement
    }
}
