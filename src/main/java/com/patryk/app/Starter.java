package com.patryk.app;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Patryk Kucharski
 */
class Starter {
    public static void main(String[] args) {

        InputStream inputStream = System.in;

        new Game(inputStream).run();


    }
}
