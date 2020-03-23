import java.util.ArrayList;

public class Game {

    ArrayList<Player> players;
    Deck deck;

    public Game(Deck deck) {
        this.players = new ArrayList<Player>();
        this.deck = deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int playerCount(){
        return this.players.size();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void start(int amountOfCards){
        for(Player player:this.players){
            for (int i = 0; i < amountOfCards; i ++){
                Card card = deck.dealOne();
                player.takeCard(card);
                player.changeToFalse();
            }
        }
    }


    public void pickedG(Player player){
        player.takeCard(deck.dealOne());
    }
    public void pickedP(Player player){
        player.changeToTrue();
    }
    public boolean checkDraw() {
        boolean drawgame = true;
        if (this.players.get(0).handTotal() < 22) {
            int handTotal = this.players.get(0).handTotal();
            for (Player player : this.players) {
                if (player.handTotal() != handTotal) {
                    drawgame = false;
                }
            }
        }
            return drawgame;
        }


    public Player checkWinner(){
        int highest = 0;
        Player winner = null;
        for(Player player:this.players) {
            if (player.handTotal() < 22) {
                if (player.handTotal() > highest) {
                    highest = player.handTotal();
                    winner = player;
                }
            }
        }
        return winner;
    }
}
