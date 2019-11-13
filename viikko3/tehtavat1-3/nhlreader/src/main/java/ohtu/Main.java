package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        for(Player player : players) {
            player.setPoints(player.getGoals() + player.getAssists());
        }
        
        ArrayList<Player> playersList = new ArrayList<Player>();
        
        for(int i = 0;i<players.length;i++) {
           playersList.add(players[i]);
        }
        
        Collections.sort(playersList);
        
        System.out.println("Finnish NHL Players:");
        System.out.println("");
        
        //System.out.println("Oliot:");
        for (Player player : playersList) {
            if(player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }   
    }
  
}
