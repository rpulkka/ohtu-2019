package laskin;

import java.util.HashMap;
import java.util.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private Button undo;
    private Sovelluslogiikka sovellus;
    
    private Map<Button, Command> commands;
    private Command previous = null;
 

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        commands = new HashMap<>();
        commands.put(plus, new Plus(tuloskentta, syotekentta,  nollaa, undo, sovellus) );
        commands.put(miinus, new Miinus(tuloskentta, syotekentta, nollaa, undo, sovellus) );
        commands.put(nollaa, new Nollaa(tuloskentta, syotekentta,  nollaa, undo, sovellus) );
    }
    
    @Override
    public void handle(Event event) {
        if ( event.getTarget() != undo ) {
            Command command = commands.get((Button)event.getTarget());
            command.execute();
            previous = command;
        } else {
            previous.cancel();
            previous = null;
        }                  
    }

}
