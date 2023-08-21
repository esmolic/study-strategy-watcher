package zad4;

import java.util.Collection;

public class ClosestPercentileComputer implements PercentileComputationStrategy {

    @Override
    public double getPercentile(double percentile, Collection<Integer> collection) {
        if (percentile <= 0 || percentile > 100)
            throw new IllegalArgumentException("Percentile must be greater than 0 and smaller than or equal to 100");

        if (collection.size() == 0)
            throw new IllegalArgumentException("Collection must contain at least one element");

        double rank = percentile / 100 * collection.size() + 0.5;

        return collection.stream().min((x,y) -> Double.compare(Math.abs(x-rank), Math.abs(y-rank))).get();
    }

}
