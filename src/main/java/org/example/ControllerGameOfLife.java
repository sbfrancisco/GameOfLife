package org.example;
public class ControllerGameOfLife {
    ModelGameOfLife model;
    ViewGameOfLife view;

    public ControllerGameOfLife(ModelGameOfLife model) {
        this.model = model;
        view = new ViewGameOfLife(this,model);
        view.initialize();
        view.computeMenu();
    }
    public void computeNextGeneration(){
        model.computeNextGeneration();
    }
}