package org.example;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    int a, b, resultado;

    @Given("tengo los números {int} y {int}")
    public void tengo_los_numeros(int x, int y) {
        a = x;
        b = y;
    }

    @When("los sumo")
    public void los_sumo() {
        resultado = a + b;
    }

    @Then("el resultado debe ser {int}")
    public void el_resultado_debe_ser(int esperado) {
        assertEquals(esperado, resultado);
    }
}