package org.example;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.concrete.Counter;
import org.example.interfaces.ColorCounter;

public class StatsGameOfLife {
    int cell_red, cell_white, cell_blue;
    int cell_alive;
    int cell_dead;
    int generations;
    int rule_survive;
    int rule_birt;
    int rule_dead;
    ColorCounter counter;

    public StatsGameOfLife(){
        cell_red = 0;
        cell_white = 0;
        cell_blue = 0;
        cell_alive = 0;
        cell_dead = 0;
        generations = 0;
        rule_survive = 0;
        rule_birt = 0;
        rule_dead = 0;
        counter = new Counter();
    }

    public int getGenerations() { return generations; }

    public int getCellAlives(){ return cell_alive; }

    public int getCellDead(){ return cell_dead; }

    public int getCellRed(){ return cell_red; }

    public int getCellWhite(){ return cell_white; }

    public int getCellBlue(){ return cell_blue; }

    public int getRuleSurvive(){ return rule_survive; }

    public int getRuleBirt(){ return rule_birt; }

    public int getRuleDead(){ return rule_dead; }

    public void collectColorCellInfo(){
        this.cell_blue = counter.getCounterColor("BLUE");
        this.cell_red = counter.getCounterColor("RED");
        this.cell_white = counter.getCounterColor("WHITE");
    }

    public void registerNextGeneration(){
        generations++;
    }
    public void collectCellInfo(Cell cell){
        if(isAlive(cell)){
            String colorCell = cell.getColor();
            incrementCountLiveCell();
            incrementCountColorCell(colorCell);
        } else {
            incrementCountCellDead();
        }
    }

    private boolean isAlive(Cell c) {
        return c.getState();
    }

    private void incrementCountColorCell(String color){
            counter.incrementColor(color);
    }


    public void collectGenerationInfo(Board old_board, Board board) {
        for(int row = 0; row < board.row; row++) {
            for(int col = 0; col < board.col ; col++) {
                if(cellBorn(old_board,board,row,col)) { rule_birt++; }
                if(cellSurvive(old_board,board,row,col)) { rule_survive++; }
                if(cellDead(old_board,board,row,col)) { rule_dead++; }
                }
            }
        }


    private boolean cellBorn(Board old_board, Board board, int row, int col){
        return !old_board.isCellAlive(row, col) && board.isCellAlive(row,col);
    }

    private boolean cellSurvive(Board old_board, Board board, int row, int col){
        return old_board.isCellAlive(row,col) && board.isCellAlive(row,col);
    }

    private boolean cellDead(Board old_board, Board board, int row, int col){
        return old_board.isCellAlive(row,col) && !board.isCellAlive(row,col);
    }

    private void incrementCountCellDead(){
        cell_dead++;
    }

    private void incrementCountLiveCell(){
        cell_alive++;
    }

}
