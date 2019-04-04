package com.patryk.app;

import java.io.InputStream;

/**
 * @author Patryk Kucharski
 */
class Starter {
    public static void main(String[] args) {

        InputStream inputStream = System.in;
        new Game(inputStream, 1).run();
    }
}
