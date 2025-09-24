package org.example.board;

import org.example.cells.Cell;
import org.example.interfaces.CellFactory;
import org.example.concrete.factory.ConcreteCellFactory;

public class Board {
    CellFactory cellFactory;
    Cell[][] board;
    public int row;
    public int col;

    public Board(int row, int col) {
        cellFactory = new ConcreteCellFactory();
        board = new Cell[row][col];
        this.row = row;
        this.col = col;
        fillBoard();
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }
    public void setCell(int row, int col, Cell cell) {
        board[row][col] = cell;
    }
    public boolean isCellAlive(int row, int col){
        return board[row][col].getState();
    }
    private void fillBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = cellFactory.createCell("dead");
            }
        }
    }

    public boolean isValidCell(int row, int col) {
        return (row > 0 && row < board.length && col > 0 && col < board[0].length);
    }

    public Cell[][] getBoard() {
        return board;
    }

}
