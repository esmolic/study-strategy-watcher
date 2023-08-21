package zad6;

import java.util.HashMap;

public class Cell {
    String exp = "";
    double value = 0;
    HashMap<ReferencedCellObserver, Cell> observers = new HashMap<>();
    HashMap<Cell, ReferencedCellObserver> otherCellSubscriptions = new HashMap<>();

    public void setContent(String content) {
        exp = content;
    }

    public String getExp() {
        return exp;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return exp + ": " + value;
    }

    public void registerObserver(ReferencedCellObserver o, Cell listener) {
        observers.put(o, listener);
    }

    public void removeObserver(ReferencedCellObserver o) {
        observers.remove(o);
    }

    public HashMap<Cell, ReferencedCellObserver> getOtherCellSubscriptions() {
        return otherCellSubscriptions;
    }

    public void removeOtherCellSubscription(Cell other) {
        otherCellSubscriptions.remove(other);
    }

    public HashMap<ReferencedCellObserver, Cell> getObservers() {
        return observers;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
