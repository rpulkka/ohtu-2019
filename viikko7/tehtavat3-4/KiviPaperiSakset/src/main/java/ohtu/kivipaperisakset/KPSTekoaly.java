package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String ekanSiirto() {
        return scanner.nextLine();
    }

    @Override
    protected String tokanSiirto() {
        return tekoaly.annaSiirto();
    }
}