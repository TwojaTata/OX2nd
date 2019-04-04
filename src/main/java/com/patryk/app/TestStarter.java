package com.patryk.app;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Patryk Kucharski
 */
public class TestStarter {

    public static void main(String[] args) throws FileNotFoundException {

        PrintStream toFile = new PrintStream((new File("./tests_output.txt")));
        PrintStream console = System.out;
        System.setOut(console);

        AutomaticTestsLogic automaticTestsLogic = new AutomaticTestsLogic();
        int rows =  5;
        int columns = 3;
        int winningCondition = 3;

        int roundsHorizontal = (rows-winningCondition+1)*columns;
        int roundsVertical = (columns-winningCondition+1)*rows;
        int roundsDiagonal = (rows-winningCondition+1)*(columns-rows+1);
        int roundsDiagonalV2 = (columns-winningCondition+1)*(rows-columns+1);
        int finalNumberOfRounds;


        StringBuilder stringBuilderCustom = initializeGame(rows, columns, winningCondition);


        automaticTestsLogic.fillMaps(rows, columns);
        List<String> gameOutput = automaticTestsLogic.autoWinDiagonalGeneratorV2(rows, columns, winningCondition);
        for (String string: gameOutput){
            stringBuilderCustom.append(string);
        }


        stringBuilderCustom.append("exit");
        try {
            FileWriter fileWriter =new FileWriter("tests.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(stringBuilderCustom);
            printWriter.close();

        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }



        File file = new File("./tests.txt");
        Game game = new Game(new FileInputStream(file), roundsDiagonalV2 );
        game.run();
    }
    public static void generateAllCombinationsOnGivenBoard(){


    }

    private static StringBuilder initializeGame(int rows, int columns, int winningCondition) {
        StringBuilder stringBuilderCustom = new StringBuilder();
        stringBuilderCustom.append("2\n").append(rows).append("\n").append(columns)
                .append("\n").append(winningCondition).append("\n").append("Patryk").append("\n")
                .append("o").append("\n").append("Tomek").append("\n").append("1").append("\n");
        return stringBuilderCustom;
    }
}
