package org.example.cells;

import org.example.colors.Red;
import org.example.interfaces.Color;

public class Cell {
    Color color;
    public Cell(Color color) {
        this.color = color;
    }

    public String getColor(){
      return color.getColor();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getState() {
        return color != null;
    }

    @Override
    public String toString(){
        if(getState()){
            return color.getColor();
        } else {
            return "dead";
        }
    }
}
