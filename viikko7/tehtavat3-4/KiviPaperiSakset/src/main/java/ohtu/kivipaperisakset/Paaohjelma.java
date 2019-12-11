package ohtu.kivipaperisakset;
import java.util.Scanner;

public class Paaohjelma {
    
    public static void main(String[] args) {
        Kaynnistys k = new Kaynnistys(new Scanner(System.in));
        k.kaynnista();
    }
}
