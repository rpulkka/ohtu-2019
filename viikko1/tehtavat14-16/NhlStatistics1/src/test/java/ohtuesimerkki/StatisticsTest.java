
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rpulkka
 */
public class StatisticsTest {
    
    public StatisticsTest() {
        
    }
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playerSearchWorks() {
        Player p = stats.search("Kurri");
        assertEquals(p.getName(), "Kurri");
        assertEquals(p.getGoals(), 37);
        assertEquals(p.getAssists(), 53);
        assertEquals(p.getTeam(), "EDM");
    }
    
    @Test
    public void playerSearchFails() {
        Player p = stats.search("Granlund");
        assertEquals(p, null);
    }
    
    @Test
    public void playersOfTeamWorks() {
        List<Player> p = stats.team("DET");
        Player yzerman = stats.search("Yzerman");
        assertEquals(p.get(0), yzerman);
    }
    
    @Test
    public void playersOfTeamFails() {
        List<Player> p = stats.team("POP");
        List<Player> e = new ArrayList<Player>();
        assertEquals(p, e);
    }
    
    @Test
    public void topScorersWork() {
        List<Player> ts = stats.topScorers(2);
        Player lemieux = stats.search("Lemieux");
        Player gretzky = stats.search("Gretzky");
        assertEquals(ts.get(1), lemieux);
        assertEquals(ts.get(0), gretzky);
    }
}
