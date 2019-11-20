
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLukumaara;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        init(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        init(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        init(kapasiteetti, kasvatuskoko);
    }
    
    public void init(int kapasiteetti, int kasvatus) {
        joukko = new int[kapasiteetti];
        for (int i = 0; i < joukko.length; i++) {
            joukko[i] = 0;
        }
        alkioidenLukumaara = 0;
        this.kasvatuskoko = kasvatus;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLukumaara == 0) {
            joukko[0] = luku;
            alkioidenLukumaara++;
            return true;
        }
        if (!kuuluu(luku)) {
            joukko[alkioidenLukumaara] = luku;
            alkioidenLukumaara++;
            if (alkioidenLukumaara % joukko.length == 0) {
                int[] vanhaTaulukko = joukko;
                joukko = new int[alkioidenLukumaara + kasvatuskoko];
                kopioiTaulukko(vanhaTaulukko, joukko);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLukumaara; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLukumaara; i++) {
            if (luku == joukko[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLukumaara - 1; j++) {
                joukko[j] = joukko[j + 1];
                joukko[j + 1] = joukko[j];
            }
            alkioidenLukumaara--;
            return true;
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLukumaara;
    }


    @Override
    public String toString() {
        if (alkioidenLukumaara == 0) {
            return "{}";
        } else {
            String merkkijono = "{";
            for (int i = 0; i < alkioidenLukumaara - 1; i++) {
                merkkijono += joukko[i];
                if(i < alkioidenLukumaara - 1) {
                    merkkijono += ", ";
                }
            }
            merkkijono += joukko[alkioidenLukumaara - 1];
            merkkijono += "}";
            return merkkijono;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLukumaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] joukkoA = a.toIntArray();
        int[] joukkoB = b.toIntArray();
        for (int i = 0; i < joukkoA.length; i++) {
            yhdiste.lisaa(joukkoA[i]);
        }
        for (int i = 0; i < joukkoB.length; i++) {
            yhdiste.lisaa(joukkoB[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] joukkoA = a.toIntArray();
        int[] joukkoB = b.toIntArray();
        for (int i = 0; i < joukkoA.length; i++) {
            for (int j = 0; j < joukkoB.length; j++) {
                if (joukkoA[i] == joukkoB[j]) {
                    leikkaus.lisaa(joukkoB[j]);
                }
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] joukkoA = a.toIntArray();
        int[] joukkoB = b.toIntArray();
        for (int i = 0; i < joukkoA.length; i++) {
            erotus.lisaa(joukkoA[i]);
        }
        for (int i = 0; i < joukkoB.length; i++) {
            erotus.poista(joukkoB[i]);
        }
 
        return erotus;
    }
        
}
