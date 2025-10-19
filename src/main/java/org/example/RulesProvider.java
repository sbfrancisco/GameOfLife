package org.example;

import org.example.interfaces.Rule;
import org.example.ruleFactory.InmigrationRuleFactory;
import org.example.ruleFactory.RuleFactory;

public class RulesProvider {
    RuleFactory ruleFactory;
    public RulesProvider(){

    }

    public Rule getRule(String rule){
        if(rule.equals("inmigration")){
            ruleFactory = new InmigrationRuleFactory();
        } else if(rule.equals("default")){
            ruleFactory = null;
        }
        return ruleFactory.getRule();
    }
}