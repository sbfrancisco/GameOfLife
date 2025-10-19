package org.example;

import org.example.concrete.factory.ConcreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.types.Position;
import org.example.board.Board;

public class GeneratePatternsGameOfLife {
    private final CellFactory cellFactory = new ConcreteCellFactory();

    public GeneratePatternsGameOfLife() {
    }

    public void getBoardWithPatternOne(Board board) {
        // Cruz central (patrón simple 5x5)
        board.setCell(new Position(2, 2), cellFactory.createCell("RED"));
        board.setCell(new Position(1, 2), cellFactory.createCell("RED"));
        board.setCell(new Position(3, 2), cellFactory.createCell("BLUE"));
        board.setCell(new Position(2, 1), cellFactory.createCell("BLUE"));
        board.setCell(new Position(2, 3), cellFactory.createCell("RED"));
    }
}
