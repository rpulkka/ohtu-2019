package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSParempiTekoaly extends Peli {

    private static final Scanner scanner = new Scanner(System.in);
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String ekanSiirto() {
        return scanner.nextLine();
    }

    @Override
    protected String tokanSiirto() {
        return tekoaly.annaSiirto();
    }
}
