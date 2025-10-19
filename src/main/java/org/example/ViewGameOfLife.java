package org.example;

import org.example.board.Board;
import org.example.concrete.strategy.FramerDisplayColors;
import org.example.concrete.strategy.StandardDisplay;
import org.example.interfaces.StrategyDisplay;
import org.example.observers.observers.Observer;

import java.util.Scanner;

public class ViewGameOfLife implements Observer {
    int lastOptionUsed;
    final int optionThatsEndsTheGame = 3;
    StrategyDisplay view;
    ControllerGameOfLife controller;
    ModelGameOfLife model;
    boolean isEnd = false;

    public ViewGameOfLife(ControllerGameOfLife controller, ModelGameOfLife model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
    }

    public void initialize() {
        view = new StandardDisplay();
    }

    public void computeMenu(){
     while(!endGame()){
         showOptions();
         processOptions();
     }
    }

    private boolean endGame(){
        return isEnd;
    }
    private void showOptions() {
        System.out.println("Ingrese la opcion que desee");
        System.out.println("1. Mostrar tablero ");
        System.out.println("2. Computar nueva generacion");
        System.out.println("3. Finalizar juego");
    }

    private void processOptions() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            String option = sc.nextLine();
            if (option.equals("1")) {
                display();
            } else if (option.equals("2")) {
                controller.computeNextGeneration();
            } else if(option.equals("3")){
                isEnd = true;
            }
        }
    }


    public void display() {
        Board board = model.getBoard();
        try {
            view.display(board);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void display(Board board) {
        try {
            view.display(board);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Object game) {
        Board board = model.getBoard();
        display(board);
    }
}