package com.patryk.app.output;

/**
 * provides printer to other classes
 *
 * @author Patryk Kucharski
 */
public class OutputAPI {

    private final Printer printer;

    public OutputAPI() {
        this.printer = new Printer();
    }

    public void print(String message) {
        printer.print(message);
    }

    public void setLanguage(String languageVersion, String countryCode) {
        printer.setLanguage(languageVersion, countryCode);
    }

    public void printMessageToUserNextLine(String key) {
        printer.printMessageToUserNextLine(key);
    }

    public void displayMenu() {
        printer.printMenu();
    }

    public void printInLine(String message) {
        printer.printInLine(message);
    }

    public void printMessageToUserInLine(String key) {
        printer.printMessageToUserInLine(key);
    }

    public void displayLanguageMenu() {
        printer.printLanguageMenu();
    }
}
