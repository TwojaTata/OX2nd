package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
public class Board {//todo niepubliczne?

    private final Marker[][] board;
    private BoardConfig boardConfig;

    public Board(BoardConfig boardConfig){
        board = new Marker[boardConfig.rows][boardConfig.columns];
        this.boardConfig = boardConfig;
    }

    Marker[][] getCurrentBoard(){
        return board;
    }

    BoardConfig getCurrentBoardConfig(){
        return  boardConfig;
    }

//    @Override
//    public String toString() {
////        return "Board{" +
////                "board=" + Arrays.toString(board) +
////                ", boardConfig=" + boardConfig +
////                '}';
//
    void displayBoard(){ //todo poprawić
            StringBuilder stringBuilder = new StringBuilder();

            System.out.print("   ");
            for (int i = 0; i < boardConfig.columns; i++) {
                if (i + 1 > 9) {
                    System.out.print("|" + (i + 1) + " ");
                } else {
                    System.out.print("|" + (i + 1) + "  ");
                }
            }
            System.out.print("|");
            System.out.println();
            for (int k = 0; k < boardConfig.columns + 1; k++) {
                System.out.print("----");
            }
            for (int i = 0; i < boardConfig.rows; i++) {
                System.out.println();
                if (i + 1 > 9) {
                    System.out.print((i + 1) + " ");
                } else {
                    System.out.print((i + 1) + "  ");
                }
                for (int j = 0; j < boardConfig.columns; j++) {
                    System.out.print("| " + board[i][j].valueToDisplay + " ");
                }
                System.out.print("|");
                System.out.println();
                for (int k = 0; k < boardConfig.columns + 1; k++) {
                    System.out.print("----");
                }
            }
            System.out.println();
            System.out.println();

    }
        //todo drukowanie!!! stołu

    /**
     * Sets up a board filled with Marker.BLANK enum,
     * which is initial state of board
     */

    void fillBoardWithBlanks() {
        for (int i = 0; i < boardConfig.rows; i++) {
            for (int j = 0; j < boardConfig.columns; j++) {
                board[i][j] = Marker.BLANK;
            }
        }
    }

    /**
     * @param coordinates   coordinates of target field for marker
     * @param currentPlayer player who currently has turn
     *                      <p>
     *                      Puts given marker in specified position on board
     */

    void putMarker(Coordinates coordinates, Player currentPlayer) {
        board[coordinates.row][coordinates.column] = currentPlayer.getMarker();
    }

    Board initializeDefaultBoard(){
        Board board = new Board(BoardConfig.setDefaultBoardConfig());
        board.fillBoardWithBlanks();
        return board;
    }
}
