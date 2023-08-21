package zad4;

import java.util.Collection;

public class DistributionTester {
    private IntegerGenerationStrategy igs;
    private PercentileComputationStrategy pcs;

    public DistributionTester(IntegerGenerationStrategy igs, PercentileComputationStrategy pcs) {
        this.igs = igs;
        this.pcs = pcs;
    }

    public void run() {
        Collection<Integer> collection = igs.generate();
        System.out.println("collection: " + collection);
        System.out.println("result: " + pcs.getPercentile(60, collection));
    }

    public static void main(String[] args) {
        DistributionTester dt = new DistributionTester(new StepIntegerGenerator(), new ClosestPercentileComputer());

        System.out.println("step integer, closest percentile");
        dt.run();

    }
}