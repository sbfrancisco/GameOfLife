package org.example.observers.observers;

import org.example.ModelGameOfLife;
import org.example.StatsGameOfLife;

public class StatusDisplay implements Observer, DisplayStats {
    ModelGameOfLife game;
    int cell_red = 0;
    int cell_white = 0;
    int cell_blue = 0;
    int cell_dead = 0;

    public StatusDisplay(ModelGameOfLife game) {
        this.game = game;
        game.registerObserver(this);
    }
    @Override
    public void update(Object game) {
    StatsGameOfLife stats = (StatsGameOfLife) game;
     cell_red = stats.getCellRed();
     cell_white = stats.getCellWhite();
     cell_blue = stats.getCellBlue();
     cell_dead = stats.getCellDead();
     display();
    }

    @Override
    public void display() {
        System.out.println("info of status display");
        System.out.println("has registered " + cell_blue + " cells blue");
        System.out.println("has registered " + cell_red + " cells red");
        System.out.println("has registered " + cell_white + " cells white");
        System.out.println("has registered " + cell_dead + " cells dead");
        System.out.println();
    }
}
