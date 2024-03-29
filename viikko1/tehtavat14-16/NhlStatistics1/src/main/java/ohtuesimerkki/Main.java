package ohtuesimerkki;

public class Main {
    public static void main(String[] args) {
        PlayerReader reader = new PlayerReader("https://nhlstatisticsforohtu.herokuapp.com/players.txt");
        Statistics stats = new Statistics(reader);
          
        System.out.println("Edmonton Oilers");
        for (Player player : stats.team("EDM") ) {
            System.out.println( player );
        }
        
        System.out.println("");
        
        System.out.println("Top scorers");
        for (Player player : stats.topScorers(10) ) {
            System.out.println( player );
        }        
    }
}
