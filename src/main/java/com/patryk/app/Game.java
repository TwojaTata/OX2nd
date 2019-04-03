package com.patryk.app;

import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

import java.io.InputStream;

/**
 * @author Patryk Kucharski
 */
class Game {

    private final MenuManager menuManager;


    Game(InputStream inputStream) {
        OutputAPI outputAPI = new OutputAPI();
        InputAPI inputAPI = new InputAPI(inputStream, outputAPI);
        this.menuManager = new MenuManager(outputAPI, inputAPI);
    }

    void run() {
        menuManager.runMenu();
    }
}
