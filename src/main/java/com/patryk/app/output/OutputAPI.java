package com.patryk.app.output;

import java.io.OutputStream;
import java.util.function.Consumer;

/**
 * @author Patryk Kucharski
 */
public class OutputAPI {

    private final Printer printer;
    private LanguageManager languageManager = new LanguageManager();

    public OutputAPI() {
        this.printer = new Printer();
    }

    public void print(String message){
        printer.printMessage(message);
    }

    public void setLanguage(String languageVersion, String countryCode){
        languageManager.setLanguageVersion(languageVersion, countryCode);
    }
}
