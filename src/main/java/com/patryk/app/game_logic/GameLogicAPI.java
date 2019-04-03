package com.patryk.app.game_logic;

import java.util.List;

/**
 * @author Patryk Kucharski
 */
public class GameLogicAPI {

    private final GameJudge gameJudge;
    private BoardConfig boardConfig;
    private Board board;
    private Coordinates coordinates;

    public GameLogicAPI() {//todo logika w konstruktorze!!!
        boardConfig = new BoardConfig(3, 3, 3);
        boardConfig.addPlayer(new Player("Player1", true, Marker.CIRCLE, 0));
        boardConfig.addPlayer(new Player("Player1", false, Marker.CROSS, 0));
        board = new Board(boardConfig);
        board.fillBoardWithBlanks();
        this.gameJudge = new GameJudge(board);
    }

//    public static GameLogicAPI createDefaultBoard (){
//        GameLogicAPI gameLogicAPI = new GameLogicAPI();
//        gameLogicAPI.board = initializeDefaultBoard();
//        return gameLogicAPI;
//    }

    public Board getCurrentBoardState() {
        return board;
    }

    void addPlayerToTheGame(Player player) {
        boardConfig.addPlayer(player);
    }

    public BoardConfig createNewBoardConfig(int rows, int columns, int winningCondition, List<Player> players) {
        return boardConfig.setBoardConfig(rows, columns, winningCondition, players);
    }

    public void fillBoardWithBlanks() {
        board.fillBoardWithBlanks();
    }

    //todo wywalic z api?
    public void putMarkerOntoBoard(Coordinates coordinates, Player currentPlayer) {
        board.putMarker(coordinates, currentPlayer);
    }

//    private Board initializeDefaultBoard() {
//        return board.initializeDefaultBoard();
//    }

    public boolean checkIfCurrentPlayerWon(Coordinates coordinates) {
        return gameJudge.checkIfCurrentPlayerWon(coordinates);
    }

    public Player getCurrentPlayer() {
        return boardConfig.getCurrentPlayer(board); // to może być this.board i będzie działać tak samo
    }

    public void resetBoard() {
        board.fillBoardWithBlanks();
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public boolean checkIfThereIsADraw() {
        return gameJudge.checkIfTheresADraw(board);
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

    public BoardConfig getCurrentConfig() {
        return boardConfig;
    }

    public boolean checkIfMoveIsLegal(int row, int column) {

        return gameJudge.checkIfMoveIsLegal(row, column, board);
    }

    public void setBoard(Board board) {
        this.board = board;
        gameJudge.setBoard(board);
    }

    public Player changeStartingPlayer(Player startingPlayer) {
        return boardConfig.changeStartingPlayer(startingPlayer);
    }
}
