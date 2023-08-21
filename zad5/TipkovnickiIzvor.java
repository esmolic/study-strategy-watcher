package zad5;

import java.util.Scanner;

public class TipkovnickiIzvor implements Source {
    private Scanner sc;

    public TipkovnickiIzvor() {
        sc = new Scanner(System.in);
    }

    @Override
    public int readNextInteger() {

        if (sc.hasNextInt())
            return sc.nextInt();

        return -1;
    }
    
}
