package zad4;

import java.util.Collection;

public class InterpolatedPercentileComputer implements PercentileComputationStrategy {

    @Override
    public double getPercentile(double percentile, Collection<Integer> collection) {
        int i = 0, n = collection.size();
        double v1 = percentile - 1;
        double v2 = percentile;
        for (int element : collection) {
            i++;

            v1 = v2;
            v2 = getRank(i, n);

            // Only >/< or also equal?
            if (v1 <= percentile && v2 >= percentile)
                break;

            return v2;
        }

        return v1 + n * (percentile - getRank(i - 1, n)) * (v2 - v1) / 100;
    }

    private double getRank(int index, int collectionSize) {
        return 100 * (index - 0.5) / collectionSize;
    }
}
