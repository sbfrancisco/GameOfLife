package org.example.board;

import org.example.cells.Cell;
import org.example.interfaces.CellFactory;
import org.example.concrete.factory.ConcreteCellFactory;
import org.example.types.Position;

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

    public Cell getCell(Position position) {
        return board[position.row()][position.col()];
    }

    public void setCell(Position position, Cell cell) { board[position.row()][position.col()] = cell; }
    public boolean isCellAlive(Position position){
        return getCell(position).getState();
    }
    private void fillBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = cellFactory.createCell("dead");
            }
        }
    }

    public boolean isValidCell(Position position) {
        return (position.row() > 0 && position.row() < board.length && position.col() > 0 && position.col() < board[0].length);
    }

    public Cell[][] getBoard() {
        return board;
    }

}
