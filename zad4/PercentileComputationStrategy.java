package zad4;

import java.util.Collection;

public interface PercentileComputationStrategy {

    double getPercentile(double percentile, Collection<Integer> collection);
}
