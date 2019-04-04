package com.patryk.app;

import java.io.InputStream;

/**
 * starts the game with given inputStream and Rounds number
 *
 * @author Patryk Kucharski
 */
class Starter {
    public static void main(String[] args) {

        InputStream inputStream = System.in;
        new Game(inputStream, 3).run();
    }
}
