package org.example;
import org.example.board.Board;
import org.example.cells.Cell;
import org.example.concrete.strategy.*;
import org.example.interfaces.Rule;
import org.example.interfaces.StrategyDisplay;
import org.example.observers.observers.Observer;
import org.example.observers.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife implements Subject {
    StatsGameOfLife stats;
    List<Observer> observers;
    Board board;
    Rule rule;
    StrategyDisplay strategyDisplay;

    public GameOfLife(Board board, Rule rule) {
        this.observers = new ArrayList<Observer>();
        this.board = board;
        this.rule = rule;
        initializeGame();
        setStrategyDisplay(new BlackAliveWhiteDeadDisplay());
    }

    private void initializeGame(){
        stats = new StatsGameOfLife();
    }

    public void setStrategyDisplay(StrategyDisplay strategyDisplay) {
        this.strategyDisplay = strategyDisplay;
    }

    public void display() throws InterruptedException {
        strategyDisplay.display(board);
    }

    public void computeNextGeneration() {
        Board next = getEmptyBoard();
        for (int row = 0; row < board.row; row++) {
            for (int col = 0; col < board.col; col++) {
                processCell(row,col,next);
            }
        }
        stats.registerNextGeneration();
        stats.collectGenerationInfo(board, next);
        setNextGeneration(next);
        stats.collectColorCellInfo();
        notifyObservers();
        resetStatsOfGame();
    }

    private void processCell(int row, int col, Board board) {
        Cell cell = rule.checkRule(row, col, board);
        board.setCell(row, col, cell);
        stats.collectCellInfo(cell);
    }

    private Board getEmptyBoard() {
        return new Board(board.row, board.col);
    }

    private void setNextGeneration(Board board){
        this.board = board;
    }

    private void resetStatsOfGame() {
        stats = new StatsGameOfLife();
    }

    public Board getBoard() {
        return board;
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this.stats);
        }
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

}
