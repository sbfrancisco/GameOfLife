package org.example.interfaces;

import org.example.cells.Cell;

public abstract class CellFactory {
    public abstract Cell createCell(String color);
}
