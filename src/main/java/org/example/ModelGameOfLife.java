package org.example;
import org.example.board.Board;
import org.example.cells.Cell;
import org.example.interfaces.Rule;
import org.example.interfaces.StrategyDisplay;
import org.example.interfaces.Subject;
import org.example.observers.observers.Observer;
import org.example.types.Position;
import org.example.GeneratePatternsGameOfLife;
import java.util.ArrayList;
import java.util.List;

public class ModelGameOfLife implements Subject {
    GeneratePatternsGameOfLife gpgol = new GeneratePatternsGameOfLife();
    StatsGameOfLife stats;
    List<Observer> observers;
    Board board;
    Rule rule;
    StrategyDisplay strategyDisplay;
    //  debugging constructor
    public ModelGameOfLife(){
        this.stats = new StatsGameOfLife();
        this.observers = new ArrayList<>();
    }
    public ModelGameOfLife(Rule rule) {
        initializeBoard();
        gpgol.getBoardWithPatternOne(board);
        this.observers = new ArrayList<>();
        this.rule = rule;
        this.stats = new StatsGameOfLife();
    }
    public void initializeBoard(){
        board = new Board(5,5);
    }

    public void computeNextGeneration() {
        Board next = getEmptyBoard();
        for (int row = 0; row < board.row; row++) {
            for (int col = 0; col < board.col; col++) {
                Position pos = new Position(row, col);
                processCell(pos, next);
            }
        }
        stats.registerNextGeneration();
        stats.collectGenerationInfo(board, next);
        setNextGeneration(next);
        stats.collectColorCellInfo();
        notifyObservers();
        resetStatsOfGame();
    }

    private void processCell(Position pos, Board nextBoard) {
        Cell cell = rule.checkRule(pos, board);
        nextBoard.setCell(pos, cell);
        stats.collectCellInfo(cell);
    }

    private Board getEmptyBoard() {
        return new Board(board.row, board.col);
    }

    private void setNextGeneration(Board board){
        this.board = board;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void setRule(Rule rule){
        this.rule = rule;
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