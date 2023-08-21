package zad5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatotecniIzvor implements Source {
    private Scanner sc;

    public DatotecniIzvor(File file) {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int readNextInteger() {
        if (sc.hasNextInt())
            return sc.nextInt();

            return -1;

    }

}
