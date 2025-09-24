package org.example.concrete.strategy;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.interfaces.StrategyDisplay;

public class StandardDisplay implements StrategyDisplay {
    public void display(Board board) {
        for(Cell[] cells: board.getBoard()){
            for(Cell cell: cells){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
