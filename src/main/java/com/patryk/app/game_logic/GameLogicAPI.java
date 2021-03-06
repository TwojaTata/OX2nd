package com.patryk.app.game_logic;

import java.util.List;

/**
 * API class provides methods to turn, round managers
 *
 * @author Patryk Kucharski
 */
public class GameLogicAPI {

    private final GameJudge gameJudge;
    private BoardConfig boardConfig;
    private Board board;
    private Coordinates coordinates;

    public GameLogicAPI() {
        boardConfig = new BoardConfig(3, 3, 3);
        boardConfig.addPlayer(new Player("Player1", true, Marker.CIRCLE, 0));
        boardConfig.addPlayer(new Player("Player1", false, Marker.CROSS, 0));
        board = new Board(boardConfig);
        board.fillBoardWithBlanks();
        this.gameJudge = new GameJudge(board);
    }

    Board getCurrentBoardState() {
        return board;
    }

    public BoardConfig createNewBoardConfig(int rows, int columns, int winningCondition, List<Player> players) {
        return boardConfig.setBoardConfig(rows, columns, winningCondition, players);
    }

    public void fillBoardWithBlanks() {
        board.fillBoardWithBlanks();
    }

    public void putMarkerOntoBoard(Coordinates coordinates, Player currentPlayer) {
        board.putMarker(coordinates, currentPlayer);
    }

    public boolean checkIfCurrentPlayerWon(Coordinates coordinates) {
        return gameJudge.checkIfCurrentPlayerWon(coordinates);
    }

    public Player getCurrentPlayer() {
        return boardConfig.getCurrentPlayer(board);
    }

    public void resetBoard() {
        board.fillBoardWithBlanks();
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public boolean checkIfThereIsADraw() {
        return gameJudge.checkIfTheresADraw();
    }

    public void switchTurns() {
        boardConfig.switchTurns();
    }

    public void setCoordinates(int row, int column) {
        coordinates = new Coordinates(row - 1, column - 1);
    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public boolean checkIfMoveIsLegal(int row, int column) {
        return gameJudge.checkIfMoveIsLegal(row, column);
    }

    public void setBoard(Board board) {
        this.board = board;
        gameJudge.setBoard(board);
    }

    public int getRows(){
        return boardConfig.rows;
    }

    public int getColumns() {
        return boardConfig.columns;
    }
}
