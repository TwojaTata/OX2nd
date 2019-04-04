package com.patryk.app;

import org.testng.annotations.Test;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

/**
 * @author Patryk Kucharski
 */
public class GameTest {

    @Test
    private void allTestsInOne(){
        try {
            PrintStream toFile = new PrintStream((new File("./tests_output.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream console = System.out;
        System.setOut(console);

        int rows =  5;
        int columns = 3;
        int winningCondition = 3;
        int roundsHorizontal = (rows-winningCondition+1)*columns;
        int roundsVertical = (columns-winningCondition+1)*rows;
        int roundsDiagonal = (rows-winningCondition+1)*(columns-rows+1);
        int roundsDiagonalV2 = (columns-winningCondition+1)*(rows-columns+1);



        StringBuilder stringBuilderCustom = new StringBuilder();
        stringBuilderCustom.append("2\n").append(rows).append("\n").append(columns)
                .append("\n").append(winningCondition).append("\n").append("Patryk").append("\n")
                .append("o").append("\n").append("Tomek").append("\n").append("1").append("\n");

        AutomaticTestsLogic automaticTestsLogic = new AutomaticTestsLogic();

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
        Game game = null;
        try {
            game = new Game(new FileInputStream(file), roundsDiagonalV2 );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        game.run();
    }

}