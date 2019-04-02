package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
public class GameLogicAPI {

    private final GameJudge gameJudge;
    private BoardConfig boardConfig;
    private Board board;
    private Coordinates coordinates;

    public GameLogicAPI(){
        board = initializeDefaultBoard();
        this.gameJudge = new GameJudge(board);
    }

    public Board getCurrentBoardState(){
        return board;
    }

    void addPlayerToTheGame(Player player){
        boardConfig.addPlayer(player);
    }

    BoardConfig setBoardConfig (int rows, int columns, int winningCondition){
        return boardConfig.setBoardConfig(rows,columns,winningCondition);
    }

    private Board fillBoardWithBlanks(){
        return board.fillBoardWithBlanks();
    }
    //todo wywalic z api?
    public void putMarkerOntoBoard(Coordinates coordinates, Player currentPlayer){
        board.putMarker(coordinates, currentPlayer);
    }

    public Board initializeDefaultBoard(){
        boardConfig.setDefaultBoardConfig();
        return board.initializeDefaultBoard();
    }

    public boolean checkIfCurrentPlayerWon(Coordinates coordinates){
        return gameJudge.checkIfCurrentPlayerWon(coordinates);
    }

    public Player getCurrentPlayer(){
        return boardConfig.getCurrentPlayer();
    }

    public void resetBoard(Board board) {
        board.fillBoardWithBlanks();
    }

    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    public boolean checkIfThereIsADraw(Board board) {
        return gameJudge.checkIfTheresADraw(board);
    }

    public void switchTurns(Board board) {

    }
}
