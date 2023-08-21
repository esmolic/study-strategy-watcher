package zad6;

public class ReferencedCellObserver {

    public void notifyUpdated(Cell listener, Sheet s) {
        s.evaluate(listener);

    }

}
