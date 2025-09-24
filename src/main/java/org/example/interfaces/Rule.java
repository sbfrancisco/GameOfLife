package org.example.interfaces;

import org.example.board.Board;
import org.example.cells.Cell;

import java.util.List;
import java.util.Set;

public abstract class Rule {
        protected Set<Integer> birth;
        protected Set<Integer> survival;

        public Rule(Set<Integer> birth, Set<Integer> survival) {
            this.birth = birth;
            this.survival = survival;
        }

        public abstract Cell checkRule(int row, int col, Board board);

        public boolean shouldBeBorn(int aliveNeighbors) {
            return birth.contains(aliveNeighbors);
        }

        public boolean shouldSurvive(int aliveNeighbors) {
            return survival.contains(aliveNeighbors);
        }
    }