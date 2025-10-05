package org.example.interfaces;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.observers.observers.Observer;

public interface StrategyDisplay {
    void display(Board board) throws InterruptedException;
}
