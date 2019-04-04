package com.patryk.app.output;

/**
 * contains print methods using languageManager class
 *
 * @author Patryk Kucharski
 */
class Printer {

    private LanguageManager languageManager;

    Printer() {
        languageManager = new LanguageManager();
    }

    void print(String message) {
        System.out.println(message);
    }

    void printMessageToUserNextLine(String key) {
        System.out.println(languageManager.getResourceBundleInstance().getString(key));
    }

    void printMessageToUserInLine(String key) {
        System.out.print(languageManager.getResourceBundleInstance().getString(key));
    }

    void setLanguage(String languageCode, String countryCode) {
        languageManager.setLanguageVersion(languageCode, countryCode);
    }

    void printInLine(String message) {
        System.out.print(message);
    }

    void printMenu() {
        printMessageToUserNextLine("chooseOption");
        printMessageToUserNextLine("option1Play");
        printMessageToUserNextLine("option2ConfigureSettings");
        printMessageToUserNextLine("option3SetLanguage");
        printMessageToUserNextLine("exitToCloseTheGame");
    }

    void printLanguageMenu() {
        printMessageToUserNextLine("chooseLanguage");
        printMessageToUserNextLine("english");
        printMessageToUserNextLine("polish");
        printMessageToUserNextLine("typeExitToQuitSettings");
    }
}
