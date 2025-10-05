package org.example.observers.observers;

import org.example.ModelGameOfLife;
import org.example.StatsGameOfLife;

public class StadisticRuleDisplay implements Observer, DisplayStats {
    ModelGameOfLife game;
    int goal;
    int rule_birt;
    int rule_dead;
    int rule_survive;

    public StadisticRuleDisplay(ModelGameOfLife game, int goal) {
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
    public void update(Object game) {
        StatsGameOfLife stats = (StatsGameOfLife) game;
        this.rule_birt += stats.getRuleBirt();
        this.rule_dead += stats.getRuleDead();
        this.rule_survive += stats.getRuleSurvive();
        if(stats.getGenerations() == goal){
            display();
        }
    }
}
