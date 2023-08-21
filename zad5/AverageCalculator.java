package zad5;

import java.util.Collection;

public class AverageCalculator extends IntegerCollectionObserver {

    @Override
    void notifyCollectionUpdated(Collection<Integer> collection) {
        
        System.out.println("average of collection elements : " + collection.stream().mapToInt(x -> x).average());
    }

}
