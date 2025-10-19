package org.example;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.example.board.Board;
import org.example.interfaces.Rule;
import org.example.utils.BoardUtils;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    ModelGameOfLife gameOfLife;
    RulesProvider rulesProvider;
    Rule rule;
    public StepDefinitions(){
        gameOfLife = new ModelGameOfLife();
        rulesProvider = new RulesProvider();
    }

    @Given("este estado inicial del tablero")
    public void esteEstadoInicialDelTablero(String tablero) {
        Board board = BoardUtils.loadBoardFromText(tablero);
        gameOfLife.setBoard(board);
    }

    @And("el juego fue inicializado con la regla {string}")
    public void elJuegoFueInicializadoConLaRegla(String ruleExpected) {
        Rule rule = rulesProvider.getRule(ruleExpected);
        gameOfLife.setRule(rule);9
    }

    @Then("el tablero debería ser")
    public void elTableroDeberíaSer(String expected) {
        Board actualBoard = gameOfLife.getBoard();
        String result = BoardUtils.boardToText(actualBoard);
        assertEquals(expected, result);
    }

    @When("se computa una nueva generacion")
    public void seComputaUnaNuevaGeneracion() {
        gameOfLife.computeNextGeneration();
    }
}