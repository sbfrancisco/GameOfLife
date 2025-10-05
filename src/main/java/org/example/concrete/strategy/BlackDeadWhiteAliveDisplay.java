package org.example.concrete.strategy;

import org.example.StatsGameOfLife;
import org.example.board.Board;
import org.example.cells.Cell;
import org.example.interfaces.StrategyDisplay;

public class BlackDeadWhiteAliveDisplay implements StrategyDisplay {
    @Override
    public void display(Board board){
        Cell[][] matrix = board.getBoard();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].toString().equals("dead")) {
                    System.out.print("black ");
                } else {
                    System.out.print("white ");
                }
            }
            System.out.println(); // salto de línea después de cada fila
        }
        System.out.println(); // espacio extra entre generaciones
    }
}
