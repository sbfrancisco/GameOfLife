package org.example.concrete.strategy;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.interfaces.StrategyDisplay;

public class BlackAliveWhiteDeadDisplay implements StrategyDisplay {
    @Override
    public void display(Board board) {
        Cell[][] matrix = board.getBoard();
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(matrix[row][col].toString().equals("dead")){
                    System.out.print("white ");
                } else {
                    System.out.print("black ");
                }
            }
            System.out.println();
        }
    }
}
