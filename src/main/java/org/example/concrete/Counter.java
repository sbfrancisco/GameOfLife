package org.example.concrete;

import org.example.interfaces.ColorCounter;

import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.Map;

public class Counter implements ColorCounter {
    Map<String, Integer> neighbors_colors;
    public Counter() {
        neighbors_colors = new HashMap<>();
        neighbors_colors.put("BLUE", 0);
        neighbors_colors.put("RED", 0);
        neighbors_colors.put("WHITE", 0);
    }

    @Override
    public void incrementColor(String color) {
        neighbors_colors.put(color, neighbors_colors.get(color) + 1);
    }

    public int getCounterColor(String color){
        return neighbors_colors.get(color);
    }
    public String getMayority() {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : neighbors_colors.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return (maxEntry != null) ? maxEntry.getKey() : null;
    }
}
