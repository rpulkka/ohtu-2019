package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        
        String status = "";
        
        if(player1Score==player2Score) {
            status = "Scores are even";
        } else if(player1Score >= 4 || player2Score >= 4) {
            status = "Player has advantage";
        }
        
        
        if (status.equals("Scores are even")) {
            score = scoreWhenPointsAreEven();
        } else if (status.equals("Player has advantage")) {
            score = scoreWhenPlayerHasAdvantage();
        } else {
            score = regularScore();
        }
        
        return score;
    }
    
    public String scoreWhenPointsAreEven() {
        String score;
        //Players have less than 40 points
        if(player1Score <= 3) {
            score = playerScore(player1Score) + "-All";
        } else {
        //Players have more than 40 points
            score = "Deuce";
        }
   
        return score;
    }
    
    public String scoreWhenPlayerHasAdvantage() {
        String score;
        int differenceOfPlayer1FromPlayer2 = player1Score-player2Score;
        
        //Player 1 has advantage.
        if (differenceOfPlayer1FromPlayer2==1) score ="Advantage player1";
        
        //Player 2 has advantage.
        else if (differenceOfPlayer1FromPlayer2 ==-1) score ="Advantage player2";
        
        //Player 1 wins.
        else if (differenceOfPlayer1FromPlayer2>=2) score = "Win for player1";
        
        //Player 2 wins.
        else score ="Win for player2";
        
        return score;
    }
    
    public String regularScore() {
        
        //Player 1 Score - Player 2 Score
        String score = score = playerScore(player1Score) + "-" + playerScore(player2Score);
        
        return score;
    }
    
    public String playerScore(int playerPoints) {
        String score = "";
        
        switch(playerPoints) {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        
        return score;
    }
}