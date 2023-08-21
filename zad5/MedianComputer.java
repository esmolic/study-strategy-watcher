package zad5;

import java.util.Collection;
import java.util.Comparator;

public class MedianComputer extends IntegerCollectionObserver {
    double median = 0;

    @Override
    void notifyCollectionUpdated(Collection<Integer> collection) {

        int[] sorted = collection.stream().sorted(Comparator.naturalOrder()).mapToInt(x -> x).toArray();

        int index = (int) Math.floor(sorted.length / 2);
        if (sorted.length % 2 == 1)
            median = sorted[index];

        else
            median = sorted[index - 1] + sorted[index] / 2;

        System.out.println("median of collection elements: " + median);
    }

}
