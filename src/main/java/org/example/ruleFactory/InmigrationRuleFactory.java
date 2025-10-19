package org.example.ruleFactory;

import org.example.interfaces.Rule;
import org.example.rules.Inmigration;

public class InmigrationRuleFactory extends RuleFactory{
    public Rule getRule(){
        return new Inmigration();
    }
}
