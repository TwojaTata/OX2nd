package com.patryk.app;

import java.io.InputStream;

/**
 * @author Patryk Kucharski
 */
class Game {

    private final MenuManager menuManager;

    Game(InputStream inputStream){
        this.menuManager = new MenuManager(inputStream);
    }

    void run() {
        menuManager.runMenu();
    }
}
