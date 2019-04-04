package com.patryk.app;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * testing class using AutomaticTestsLogic
 *
 * @author Patryk Kucharski
 */
public class EndToEndTestStarter {


    public static void main(String[] args) throws FileNotFoundException {

        PrintStream toFile = new PrintStream((new File("./tests_output.txt")));
        PrintStream console = System.out;
        System.setOut(toFile);

        AutomaticTestsLogic automaticTestsLogic = new AutomaticTestsLogic();
        int rows = 3;
        int columns = 3;
        int winningCondition = 3;

        //generateBadConditions();
        generateAllCombinationsOnGivenBoard(rows, columns, winningCondition, automaticTestsLogic);
    }

    private static void generateAllCombinationsOnGivenBoard(int rows, int columns, int winningCondition, AutomaticTestsLogic automaticTestsLogic) throws FileNotFoundException {
        int finalRoundCount = 0;

        StringBuilder stringBuilderCustom = initializeGame(rows, columns, winningCondition);

        List<String> gameOutput = automaticTestsLogic.autoDrawGenerator(rows, columns, winningCondition);
        for (String string : gameOutput) {
            stringBuilderCustom.append(string);
        }
        finalRoundCount += 1;


        List<String> gameOutput1 = automaticTestsLogic.autoHorizontalWinGenerator(rows, columns, winningCondition);
        for (String string : gameOutput1) {
            stringBuilderCustom.append(string);
        }
        finalRoundCount += (rows - winningCondition + 1) * columns;

        List<String> gameOutput2 = automaticTestsLogic.autoWinVerticalGenerator(rows, columns, winningCondition);
        for (String string : gameOutput2) {
            stringBuilderCustom.append(string);
        }
        finalRoundCount += (columns - winningCondition + 1) * rows;

        if (columns >= rows) {

            List<String> gameOutput3 = automaticTestsLogic.autoWinDiagonalGenerator(rows, columns, winningCondition);
            for (String string : gameOutput3) {
                stringBuilderCustom.append(string);
            }
            finalRoundCount += (rows - winningCondition + 1) * (columns - rows + 1);

            List<String> gameOutput4 = automaticTestsLogic.autoWinAntiDigonalGenerator(rows, columns, winningCondition);
            for (String string : gameOutput4) {
                stringBuilderCustom.append(string);
            }
            finalRoundCount += (rows - winningCondition + 1) * (columns - rows + 1);

        } else {

            List<String> gameOutput5 = automaticTestsLogic.autoWinDiagonalGeneratorV2(rows, columns, winningCondition);
            for (String string : gameOutput5) {
                stringBuilderCustom.append(string);
            }
            finalRoundCount += (columns - winningCondition + 1) * (rows - columns + 1);

            List<String> gameOutput6 = automaticTestsLogic.autoWinAntiDiagonalGeneratorV2(rows, columns, winningCondition);
            for (String string : gameOutput6) {
                stringBuilderCustom.append(string);
            }
            finalRoundCount += (columns - winningCondition + 1) * (rows - columns + 1);
        }

        stringBuilderCustom.append("exit");

        try {
            FileWriter fileWriter = new FileWriter("tests.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(stringBuilderCustom);
            printWriter.close();

        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }

        File file = new File("./tests.txt");
        Game game = new Game(new FileInputStream(file), finalRoundCount);
        game.run();
    }

    private static StringBuilder initializeGame(int rows, int columns, int winningCondition) {
        StringBuilder stringBuilderCustom = new StringBuilder();

        stringBuilderCustom
                .append("2\n").append(rows).append("\n").append(columns)
                .append("\n").append(winningCondition).append("\n").append("Patryk").append("\n")
                .append("o").append("\n").append("Tomek").append("\n").append("1").append("\n");
        return stringBuilderCustom;
    }

    private static void generateBadConditions() throws FileNotFoundException {


        StringBuilder stringBuilder = new StringBuilder()
                .append("3").append("\n")
                .append("fr").append("\n").append("pl").append("\n")
                .append("3").append("\n").append("eng").append("\n").append("2").append("\n")
                .append("120").append("\n").append("5").append("\n").append("500").append("\n")
                .append("7").append("\n").append("8").append("\n").append("3").append("\n")
                .append("Tomek").append("\n").append("2").append("\n").append("o").append("\n")
                .append("Patryk").append("\n").append("1").append("\n").append("asdasda").append("\n").append("1")
                .append("\n").append("qwerty").append("\n").append("1").append("\n").append("-5")
                .append("\n").append("2").append("\n").append("100")
                .append("\n").append("2").append("\n").append("1")
                .append("\n").append("2").append("\n").append("2").append("\n").append("2").append("\n").append("3")
                .append("\n").append("3")
                .append("\n").append("1").append("\n").append("3").append("\n").append("exit");

        try {
            FileWriter fileWriter = new FileWriter("testsBadInput.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(stringBuilder);
            printWriter.close();

        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }

        File file = new File("./testsBadInput.txt");
        Game game = new Game(new FileInputStream(file), 1);
        game.run();

    }
}
