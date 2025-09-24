package org.example.observers.observers;

import org.example.GameOfLife;
import org.example.StatsGameOfLife;

public class StatusDisplay implements Observer, DisplayStats {
    GameOfLife game;
    int cell_red = 0;
    int cell_white = 0;
    int cell_blue = 0;
    int cell_dead = 0;

    public StatusDisplay(GameOfLife game) {
        this.game = game;
        game.registerObserver(this);
    }

    @Override
    public void update(StatsGameOfLife game) {
     cell_red = game.getCellRed();
     cell_white = game.getCellWhite();
     cell_blue = game.getCellBlue();
     cell_dead = game.getCellDead();
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
