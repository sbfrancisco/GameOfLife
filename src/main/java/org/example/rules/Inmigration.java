package org.example.rules;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.concrete.Counter;
import org.example.concrete.factory.ConcreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;
import org.example.types.Direction;
import java.util.*;

public class Inmigration extends Rule {
    public Inmigration() {
        super(new HashSet<>(Set.of(3, 4)), new HashSet<>(Set.of(3)));
    }

    public Cell checkRule(int row, int col, Board board) {
        CellFactory cf = new ConcreteCellFactory();
        RecordOfNeighbors recordOfNeighbors = exploreNeighbors(board, row, col);

        int liveNeighbors = recordOfNeighbors.alive_neighbors;
        Counter colorCountersNeighbors = (Counter) recordOfNeighbors.counter;

        if (board.isCellAlive(row, col)) {
            if(shouldBeBorn(liveNeighbors)) {
                String newColorCell = colorCountersNeighbors.getMayority();
                return cf.createCell(newColorCell);
            }
        } else {
            if (shouldSurvive(liveNeighbors)){
                return board.getCell(row, col);
            }
        }
        return cf.createCell("dead");
    }

    private static record RecordOfNeighbors(int alive_neighbors, ColorCounter counter) {}

    private RecordOfNeighbors exploreNeighbors(Board board, int row, int col) {
        int live_neighbors = 0;
        ColorCounter counter = new Counter();
        for (Direction d : Direction.getNeighbors()) {
            int x_prime = d.x + row;
            int y_prime = d.y + col;
            if (board.isValidCell(x_prime, y_prime)) {
                Cell neighbors = board.getCell(x_prime, y_prime);
                if (board.isCellAlive(x_prime, y_prime)) {
                    live_neighbors++;
                    String color = neighbors.getColor();
                    if (color != null) {
                        counter.incrementColor(color);
                    }
                }
            }
        }
        return new RecordOfNeighbors(live_neighbors, counter);
        }
    }

