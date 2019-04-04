package com.patryk.app.game_logic;

import java.util.stream.Collectors;

/**
 * main game logic class
 * decides if player won or draw after last move
 *
 * @author Patryk Kucharski
 */
class GameJudge {

    private Board board;

    GameJudge(Board board) {
        this.board = board;
    }

    void setBoard(Board board) {
        this.board = board;
    }

    private boolean checkIfWonHorizontally(Coordinates coordinates) {

        int counter = 0;
        Marker currentMarker = getCurrentMarker();

        for (int i = coordinates.column; i < board.getCurrentBoardConfig().columns; i++) {
            if (board.getCurrentBoard()[coordinates.row][i].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        for (int i = coordinates.column - 1; i >= 0; i--) {
            if (board.getCurrentBoard()[coordinates.row][i].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }

    private boolean checkIfWonVertically(Coordinates coordinates) {

        int counter = 0;
        Marker currentMarker = getCurrentMarker();

        for (int i = coordinates.row; i < board.getCurrentBoardConfig().rows; i++) {
            if (board.getCurrentBoard()[i][coordinates.column].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        for (int i = coordinates.row - 1; i >= 0; i--) {
            if (board.getCurrentBoard()[i][coordinates.column].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }

    private boolean checkIfWonDiagonallyUpToDown(Coordinates coordinates) {

        int counter = 0;
        Marker currentMarker = getCurrentMarker();

        for (int i = coordinates.row, i1 = coordinates.column; i < board.getCurrentBoardConfig().rows && i1 < board.getCurrentBoardConfig().columns; i++, i1++) {
            if (board.getCurrentBoard()[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        for (int i = coordinates.row - 1, i1 = coordinates.column - 1; i >= 0 && i1 >= 0; i--, i1--) {
            if (board.getCurrentBoard()[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }

    private boolean checkIfWonDiagonallyDownToUp(Coordinates coordinates) {

        int counter = 0;
        Marker currentMarker = getCurrentMarker();

        for (int i = coordinates.row, i1 = coordinates.column; i >= 0 && i1 < board.getCurrentBoardConfig().columns; i--, i1++) {
            if (board.getCurrentBoard()[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        for (int i = coordinates.row + 1, i1 = coordinates.column - 1; i < board.getCurrentBoardConfig().rows && i1 >= 0; i++, i1--) {
            if (board.getCurrentBoard()[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.getCurrentBoardConfig().winningConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }


    /**
     * @param coordinates last move
     * @return true if last move was winning
     */
    boolean checkIfCurrentPlayerWon(Coordinates coordinates) {
        return checkIfWonDiagonallyDownToUp(coordinates)
                || checkIfWonDiagonallyUpToDown(coordinates)
                || checkIfWonHorizontally(coordinates)
                || checkIfWonVertically(coordinates);
    }

    /**
     * @return true is game ended in draw
     */
    boolean checkIfTheresADraw() {
        int counter = 0;

        for (int i = 0; i < board.getCurrentBoardConfig().rows; i++) {
            for (int j = 0; j < board.getCurrentBoardConfig().columns; j++) {
                if (board.getCurrentBoard()[i][j].equals(Marker.BLANK)) {
                    counter++;
                }
            }
        }
        return counter <= 0;
    }

    /**
     * @return marker of player that has turn
     */
    private Marker getCurrentMarker() {
        return board.getCurrentBoardConfig().players.stream()
                .filter(Player::hasTurn)
                .map(Player::getMarker)
                .collect(Collectors.toList())
                .get(0);
    }

    /**
     * @param row    coordinate
     * @param column coordinate
     * @return false if given field is already taken
     */
    boolean checkIfMoveIsLegal(int row, int column) {
        return board.getCurrentBoard()[row][column].equals(Marker.BLANK);
    }
}
