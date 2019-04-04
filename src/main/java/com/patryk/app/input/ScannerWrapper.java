package com.patryk.app.input;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
class ScannerWrapper {

    private Scanner scanner;

    ScannerWrapper(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    String returnNextLine() {
        return scanner.nextLine();
    }
}
