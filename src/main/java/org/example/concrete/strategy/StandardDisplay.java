package org.example.concrete.strategy;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.interfaces.StrategyDisplay;
import org.example.types.Position;

public class StandardDisplay implements StrategyDisplay {
    public void display(Board board) {
        for (int y = 0; y < board.row; y++) {
            for (int x = 0; x < board.col; x++) {
                var cell = board.getCell(new Position(x, y));
                if (cell == null || !cell.getState()) {
                    System.out.print(". ");
                } else {
                    switch (cell.getColor()) {
                        case "RED" -> System.out.print("R ");
                        case "BLUE" -> System.out.print("B ");
                        case "GREEN" -> System.out.print("G ");
                        case "YELLOW" -> System.out.print("Y ");
                        case "PURPLE" -> System.out.print("P ");
                        default -> System.out.print("? ");
                    }
                }
            }
            System.out.println();
        }
    }
}