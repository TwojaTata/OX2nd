package com.patryk.app;

import com.patryk.app.output.OutputAPI;
import java.io.InputStream;

/**
 * @author Patryk Kucharski
 */
class Game {


    private final RoundManager roundManager;
    private final OutputAPI outputAPI;

    Game(InputStream userInputProvider){
        this.roundManager = new RoundManager();
        this.outputAPI = new OutputAPI();
    }

    void run() {
        roundManager.doMainLoop();
    }
}
