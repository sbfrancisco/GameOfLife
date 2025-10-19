package org.example;

import org.example.concrete.factory.ConcreteCellFactory;
import org.example.concrete.strategy.*;
import org.example.interfaces.CellFactory;
import org.example.interfaces.Rule;
import org.example.interfaces.StrategyDisplay;
import org.example.observers.observers.Observer;
import org.example.observers.observers.StadisticDisplay;
import org.example.observers.observers.StadisticRuleDisplay;
import org.example.observers.observers.StatusDisplay;
import org.example.ruleFactory.InmigrationRuleFactory;
import org.example.ruleFactory.RuleFactory;
import org.example.rules.Inmigration;
import org.example.types.Position;

public class   Main {
    public static void main(String[] args) throws InterruptedException {
        RulesProvider rulesProvider = new RulesProvider();
        Rule rule = rulesProvider.getRule("inmigration");
        ModelGameOfLife gol = new ModelGameOfLife(rule);
        Observer stadisticDisplay = new StadisticDisplay(gol, 10);
        Observer stadisticRuleDisplay = new StadisticRuleDisplay(gol, 10);
        Observer statusDisplay = new StatusDisplay(gol);
        ControllerGameOfLife controller = new ControllerGameOfLife(gol);
    }
}

