package org.example.observers.subject;

import org.example.observers.observers.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
