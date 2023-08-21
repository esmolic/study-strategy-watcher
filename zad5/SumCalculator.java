package zad5;

import java.util.Collection;

public class SumCalculator extends IntegerCollectionObserver {

    @Override
    void notifyCollectionUpdated(Collection<Integer> collection) {
        
        System.out.println("sum of collection elements: " + collection.stream().mapToInt(x -> x).sum());

    }

}
