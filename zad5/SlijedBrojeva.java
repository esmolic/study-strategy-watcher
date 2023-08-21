package zad5;

import java.util.ArrayList;

public class SlijedBrojeva {
    private ArrayList<Integer> collection;
    private Source source;
    private ArrayList<IntegerCollectionObserver> collectionObservers;

    public SlijedBrojeva(Source source) {
        collection = new ArrayList<>();
        collectionObservers = new ArrayList<>();
        setSource(source);
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void kreni() {
        int read;
        while ((read = source.readNextInteger()) > -1) {
            collection.add(read);
            collectionObservers.forEach(w -> w.notifyCollectionUpdated(collection));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void registercollectionObserver(IntegerCollectionObserver cw) {
        collectionObservers.add(cw);
    }

}
