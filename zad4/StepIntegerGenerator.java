package zad4;

import java.util.ArrayList;
import java.util.Scanner;

public class StepIntegerGenerator implements IntegerGenerationStrategy {

    @Override
    public ArrayList<Integer> generate() {
        int lowerBound = 0, upperBound = 0, step = 0;

        try (Scanner sc = new Scanner(System.in)) {

            // assuming the user will input only Integer-parsable characters
            // for simplicity
            System.out.print("lower bound > ");
            if (sc.hasNextLine())
                lowerBound = Integer.parseInt(sc.nextLine());

            do {
                System.out.print("upper bound > ");
                if (sc.hasNextLine())
                    upperBound = Integer.parseInt(sc.nextLine());

            } while (upperBound < lowerBound);

            System.out.print("step > ");
            if (sc.hasNextLine())
                step = Integer.parseInt(sc.nextLine());

        }
        ArrayList<Integer> generatedIntegers = new ArrayList<>();

        for (int generated = lowerBound; generated <= upperBound; generated += step) {
            generatedIntegers.add(generated);
        }

        return generatedIntegers;
    }

}
