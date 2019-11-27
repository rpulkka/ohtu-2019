
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Miinus extends Command {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int oldValue;
    private int value;
    
    public Miinus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }


    @Override
    public void execute() {
        try {
            value = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            
        }
        
        try {
            oldValue = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
            
        }
        
        sovellus.miinus(value);
        
        int result = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + result);
        
        if (result == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        
        undo.disableProperty().set(false);
    }

    @Override
    public void cancel() {
        sovellus.set(oldValue);
        
        syotekentta.setText("");
        tuloskentta.setText("" + oldValue);
        
        undo.disableProperty().set(true);
    }
    
}
