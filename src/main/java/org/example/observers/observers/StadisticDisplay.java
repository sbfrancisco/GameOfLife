package org.example.observers.observers;

import org.example.ModelGameOfLife;
import org.example.StatsGameOfLife;

public class StadisticDisplay implements Observer, DisplayStats {
    ModelGameOfLife game;
    int goal;
    int cell_alive;
    int cell_dead;

    public StadisticDisplay(ModelGameOfLife game, int goal) {
        this.cell_alive = 0;
        this.cell_dead = 0;
        this.game = game;
        this.goal = goal;
        game.registerObserver(this);
    }

    @Override
    public void update(Object game){
        StatsGameOfLife stats = (StatsGameOfLife) game;
        this.cell_alive += stats.getCellAlives();
        this.cell_dead += stats.getCellDead();
        if(goal==stats.getGenerations()){
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("info of stadistic display");
        System.out.println("the average of cells live is: " + (cell_alive / goal));
        System.out.println("the average of cells dead is: " + (cell_dead / goal));
        System.out.println();
    }
}
