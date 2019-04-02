package com.patryk.app.output;

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
        printer.print(message);
    }

    public void setLanguage(String languageVersion, String countryCode){
        languageManager.setLanguageVersion(languageVersion, countryCode);
    }

    public void printMessageToUserNextLine(String key) {
        printer.printMessageToUserNextLine(key);
    }

    public void displayMenu() {

        //todo menu
    }

    public void printInLine(String message) {
        printer.printInLine(message);
    }

    public void printMessageToUserInLine(String player) {
        printer.printMessageToUserInLine(player);
    }
}
