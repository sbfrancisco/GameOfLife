package org.example;
import org.example.concrete.factory.ConcreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.types.Position;
import org.example.board.Board;

public class GeneratePatternsGameOfLife {
    CellFactory cellFactory = new ConcreteCellFactory();
    public GeneratePatternsGameOfLife() {
    }

    public void getBoardWithPatternOne(Board board) {
        board.setCell(new Position(8, 10), cellFactory.createCell("RED"));
        board.setCell(new Position(9, 10), cellFactory.createCell("RED"));
        board.setCell(new Position(10, 10), cellFactory.createCell("RED"));

        board.setCell(new Position(8, 12), cellFactory.createCell("RED"));
        board.setCell(new Position(9, 12), cellFactory.createCell("RED"));
        board.setCell(new Position(10, 12), cellFactory.createCell("RED"));

        board.setCell(new Position(12, 10), cellFactory.createCell("BLUE"));
        board.setCell(new Position(13, 10), cellFactory.createCell("BLUE"));
        board.setCell(new Position(14, 10), cellFactory.createCell("BLUE"));

        board.setCell(new Position(12, 12), cellFactory.createCell("BLUE"));
        board.setCell(new Position(13, 12), cellFactory.createCell("BLUE"));
        board.setCell(new Position(14, 12), cellFactory.createCell("BLUE"));

        board.setCell(new Position(8, 8), cellFactory.createCell("RED"));
        board.setCell(new Position(9, 8), cellFactory.createCell("RED"));
        board.setCell(new Position(10, 8), cellFactory.createCell("RED"));

        board.setCell(new Position(12, 8), cellFactory.createCell("RED"));
        board.setCell(new Position(13, 8), cellFactory.createCell("RED"));
        board.setCell(new Position(14, 8), cellFactory.createCell("RED"));

        board.setCell(new Position(8, 14), cellFactory.createCell("BLUE"));
        board.setCell(new Position(9, 14), cellFactory.createCell("BLUE"));
        board.setCell(new Position(10, 14), cellFactory.createCell("BLUE"));

        board.setCell(new Position(12, 14), cellFactory.createCell("BLUE"));
        board.setCell(new Position(13, 14), cellFactory.createCell("BLUE"));
        board.setCell(new Position(14, 14), cellFactory.createCell("BLUE"));
        }

}
