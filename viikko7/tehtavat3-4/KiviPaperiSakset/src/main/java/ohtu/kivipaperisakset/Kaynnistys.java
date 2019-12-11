package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Kaynnistys {

    private Scanner scanner;
    private PeliMode peliMode;
    
    public Kaynnistys(Scanner scanner) {
        this.scanner = scanner;
        this.peliMode = null;
    }

    public void kaynnista() {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetetaan");

            String vastaus = scanner.nextLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            if (vastaus.endsWith("a")) {
                peliMode = PeliMode.luoKaksinpeli();
                peliMode.pelaa();
            } else if (vastaus.endsWith("b")) {
                peliMode = PeliMode.luoYksinpeli();
                peliMode.pelaa();
            } else if (vastaus.endsWith("c")) {
                peliMode = PeliMode.luoVaikeaYksinpeli();
                peliMode.pelaa();
            } else {
                break;
            }
        }
    }
}
