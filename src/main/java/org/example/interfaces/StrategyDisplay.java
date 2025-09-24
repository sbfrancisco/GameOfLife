package org.example.interfaces;

import org.example.board.Board;
import org.example.cells.Cell;

public interface StrategyDisplay {
    void display(Board board) throws InterruptedException;
}
