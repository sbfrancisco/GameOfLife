package org.example.utils;

import org.example.board.Board;
import org.example.concrete.factory.ConcreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.types.Position;

public class BoardUtils {
    private static final CellFactory cellFactory = new ConcreteCellFactory();

    public static Board loadBoardFromText(String patternText) {
        String[] lines = patternText.strip().split("\\R");
        int height = lines.length;
        int width = lines[0].trim().split("\\s+").length;

        Board board = new Board(height, width);

        for (int y = 0; y < height; y++) {
            String[] symbols = lines[y].trim().split("\\s+");
            for (int x = 0; x < width; x++) {
                String symbol = symbols[x];
                if (!symbol.equals(".")) {
                    String color = switch (symbol) {
                        case "R" -> "RED";
                        case "B" -> "BLUE";
                        case "G" -> "GREEN";
                        case "Y" -> "YELLOW";
                        case "P" -> "PURPLE";
                        default -> "UNKNOWN";
                    };
                    board.setCell(new Position(y, x), cellFactory.createCell(color));
                }
            }
        }
        return board;
    }

    public static String boardToText(Board board) {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < board.row; y++) {
            for (int x = 0; x < board.col; x++) {
                var cell = board.getCell(new Position(y, x));
                String symbol;

                if (cell == null || !cell.getState()) symbol = ".";
                else {
                    symbol = switch (cell.getColor()) {
                        case "RED" -> "R";
                        case "BLUE" -> "B";
                        case "GREEN" -> "G";
                        case "YELLOW" -> "Y";
                        case "PURPLE" -> "P";
                        default -> "?";
                    };
                }
                sb.append(symbol);
                if (x < board.row- 1) sb.append(" "); // no espacio al final
            }
            if (y < board.col - 1) sb.append("\n"); // no salto al final
        }

        return sb.toString();
    }


}
