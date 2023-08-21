package zad4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NormalDistributionIntegerGenerator implements IntegerGenerationStrategy {

    @Override
    public ArrayList<Integer> generate() {

        Random random = new Random();
        double mean = 0, stddev = 0;
        int count = 0;

        try (Scanner sc = new Scanner(System.in)) {

            // assuming the user will input only appropriately-parsable characters
            // for simplicity
            System.out.print("mean > ");
            if (sc.hasNextLine())
                mean = Double.parseDouble(sc.nextLine());

            System.out.print("standard deviation > ");
            if (sc.hasNextLine())
                stddev = Double.parseDouble(sc.nextLine());

            System.out.print("number of integers to generate > ");
            if (sc.hasNextLine())
                count = Integer.parseInt(sc.nextLine());

        }

        ArrayList<Integer> generatedIntegers = new ArrayList<>();

        double generated;
        while (count-- > 0) {
            generated = random.nextGaussian() * stddev + mean;

            if (generated % 1 < 5)
                generatedIntegers.add((int) generated);

            else
                generatedIntegers.add((int) generated + 1);
        }

        return generatedIntegers;
    }

}
