package org.example.concrete.factory;

import org.example.cells.Cell;
import org.example.colors.*;
import org.example.interfaces.CellFactory;

public class ConcreteCellFactory extends CellFactory {
  public Cell createCell(String color){
      if(color.equals("RED")){
          return new Cell(new Red());
      } else if (color.equals("BLUE")){
          return new Cell(new Blue());
      } else if (color.equals("WHITE")){
          return new Cell(new White());
      }
      return new Cell(null);
  }
}
