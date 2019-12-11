
package ohtu.kivipaperisakset;

public abstract class Peli {
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        while (true) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            
            String ekanSiirto = ekanSiirto();
            System.out.println(ekanSiirto);
            
            System.out.print("Toisen pelaajan siirto: ");
            
            String tokanSiirto = tokanSiirto();
            
            System.out.println(tokanSiirto);
            
            if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract String ekanSiirto();
    
    protected abstract String tokanSiirto();
}
