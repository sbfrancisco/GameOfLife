package org.example.interfaces;

import java.util.Map;

public interface ColorCounter {
    void incrementColor(String color);
    int getCounterColor(String color);
    String getMayority();
}
