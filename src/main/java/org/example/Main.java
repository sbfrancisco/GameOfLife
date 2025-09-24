package org.example;

import org.example.board.Board;
import org.example.concrete.strategy.*;
import org.example.interfaces.Rule;
import org.example.observers.observers.Observer;
import org.example.observers.observers.StadisticDisplay;
import org.example.observers.observers.StadisticRuleDisplay;
import org.example.observers.observers.StatusDisplay;
import org.example.rules.Inmigration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(8,8);
        Rule rule = new Inmigration();
        GameOfLife gol = new GameOfLife(board, rule);
        Observer stadisticDisplay = new StadisticDisplay(gol, 10);
        Observer stadisticRuleDisplay = new StadisticRuleDisplay(gol, 10);
        Observer statusDisplay = new StatusDisplay(gol);
        gol.setStrategyDisplay(new FramerDisplayColors());

        for(int i = 0; i < 20; i++){
            gol.display();
            gol.computeNextGeneration();
            System.out.println();
        }
    }
}

