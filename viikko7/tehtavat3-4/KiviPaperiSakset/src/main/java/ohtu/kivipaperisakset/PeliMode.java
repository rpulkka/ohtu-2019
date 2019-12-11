
package ohtu.kivipaperisakset;


public class PeliMode {

    private Peli peli;
    
    protected PeliMode(Peli peli) {
        this.peli = peli;
    }
    
    public static PeliMode luoKaksinpeli() {
        return new PeliMode(new KPSPelaajaVsPelaaja());
    }
    
    public static PeliMode luoYksinpeli() {
        return new PeliMode(new KPSTekoaly());
    }
    
    public static PeliMode luoVaikeaYksinpeli() {
        return new PeliMode(new KPSParempiTekoaly());
    }
    
    public void pelaa() {
        peli.pelaa();
    }
}