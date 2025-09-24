package org.example.observers.observers;

import org.example.GameOfLife;
import org.example.StatsGameOfLife;

public class StadisticRuleDisplay implements Observer, DisplayStats {
    GameOfLife game;
    int goal;
    int rule_birt;
    int rule_dead;
    int rule_survive;

    public StadisticRuleDisplay(GameOfLife game, int goal) {
        this.game = game;
        this.goal = goal;
        game.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Rule Stadistics Display");
        System.out.println("the average of rule birt apply is:" + rule_birt/goal);
        System.out.println("the average of rule dead apply is:" + rule_dead/goal);
        System.out.println("the average of rule survive apply is:" + rule_survive/goal);
    }

    @Override
    public void update(StatsGameOfLife game) {
        this.rule_birt += game.getRuleBirt();
        this.rule_dead += game.getRuleDead();
        this.rule_survive += game.getRuleSurvive();
        if(game.getGenerations() == goal){
            display();
        }
    }
}
