package zad4;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciIntegerGenerator implements IntegerGenerationStrategy {

    @Override
    public ArrayList<Integer> generate() {
        int count = 0;
        try (Scanner sc = new Scanner(System.in)) {

            // assuming the user will input only appropriately-parsable characters
            // for simplicity
            System.out.print("number of integers to generate > ");
            if (sc.hasNextLine())
                count = Integer.parseInt(sc.nextLine());
        }

        ArrayList<Integer> generatedIntegers = new ArrayList<>();

        storeNextFibonacci(0, 1, count, generatedIntegers);
        
        return generatedIntegers;
    }

    private void storeNextFibonacci(int i, int j, int count, ArrayList<Integer> store) {
        if (count == 0)
            return;

        if (store.size() == 0)
            store.add(i);
        else if (store.size() == 1)
            store.add(j);
        else {
            int generated = i + j;
            store.add(generated);
            storeNextFibonacci(j, generated, --count, store);
        }

    }

}
