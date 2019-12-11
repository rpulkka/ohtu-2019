package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Peli {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String ekanSiirto() {
        return scanner.nextLine();
    }

    @Override
    protected String tokanSiirto() {
        return scanner.nextLine();
    }
}