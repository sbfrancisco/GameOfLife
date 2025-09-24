package org.example.concrete.strategy;

import org.example.board.Board;
import org.example.cells.Cell;
import org.example.interfaces.StrategyDisplay;

import javax.swing.*;
import java.awt.*;

    public class FramerDisplayColors extends JPanel implements StrategyDisplay {
        private Cell[][] matrix;
        private final int cellSize = 20;

        @Override
        public void display(Board board) throws InterruptedException {
            this.matrix = board.getBoard();
            JFrame frame = new JFrame("Game of Life - BlackAliveWhiteDead");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(this);
            frame.setSize(matrix[0].length * cellSize + 20, matrix.length * cellSize + 40);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            Thread.sleep(300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (matrix == null) return;

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] != null && matrix[row][col].toString().equals("dead")) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(stringToColor(matrix[row][col].toString()));
                    }
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
            }
        }

        private Color stringToColor(String colorStr) {
            if (colorStr == null) return Color.BLACK; // fallback
            switch (colorStr.toUpperCase()) {
                case "BLACK": return Color.BLACK;
                case "WHITE": return Color.WHITE;
                case "RED": return Color.RED;
                case "GREEN": return Color.GREEN;
                case "BLUE": return Color.BLUE;
                case "YELLOW": return Color.YELLOW;
                case "ORANGE": return Color.ORANGE;
                case "PINK": return Color.PINK;
                case "GRAY": return Color.GRAY;
                default: return Color.BLACK; // color por defecto
            }
        }
    }



