package org.example.rules;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.concrete.Counter;
import org.example.concrete.factory.ConcreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;
import org.example.types.Direction;
import org.example.types.Position;

import java.util.*;

public class Inmigration extends Rule {
    public Inmigration() {
        super(new HashSet<>(Set.of(3, 4)), new HashSet<>(Set.of(3)));
    }
    @Override
    public Cell checkRule(Position position, Board board) {
        CellFactory cf = new ConcreteCellFactory();
        RecordOfNeighbors recordOfNeighbors = exploreNeighbors(board, position);

        int liveNeighbors = recordOfNeighbors.alive_neighbors;
        Counter colorCountersNeighbors = (Counter) recordOfNeighbors.counter;

        if (!board.isCellAlive(position)) {
            if(shouldBeBorn(liveNeighbors)) {
                String newColorCell = colorCountersNeighbors.getMayority();
                return cf.createCell(newColorCell);
            }
        } else {
            if (shouldSurvive(liveNeighbors)){
                return board.getCell(position);
            }
        }
        return cf.createCell("dead");
    }

    private static record RecordOfNeighbors(int alive_neighbors, ColorCounter counter) {}

    private RecordOfNeighbors exploreNeighbors(Board board, Position position) {
        int live_neighbors = 0;
        ColorCounter counter = new Counter();
        for (Direction direction : Direction.getNeighbors()) {
            Position position_prime = direction.transformate(position.row(), position.col());
            Cell neighbor = getCellNeighbor(board, position_prime);
            if (neighbor != null) {
                if (board.isCellAlive(position_prime)) {
                    live_neighbors++;
                    registerColorOfNeighbor(neighbor, counter);
                }
            }
        }
        return new RecordOfNeighbors(live_neighbors, counter);
        }

        private void registerColorOfNeighbor(Cell neighbor, ColorCounter counter) {
            String colorNeighbor = neighbor.getColor();
            if (colorNeighbor != null) {
                counter.incrementColor(colorNeighbor);
            }
        }
        private Cell getCellNeighbor(Board board, Position position){
            if (board.isValidCell(position)) return board.getCell(position);
            return null;
        }
    }

