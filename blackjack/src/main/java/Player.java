import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private boolean passed;


    public Player(String name, boolean passed) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.passed = passed;
;
    }

    public boolean checkForAce(){
        boolean  outcome = false ;
        for (Card card : this.hand){
            if(card.checkForAce()){
                outcome =  true;
            }
        }
        return outcome;

    }


    public boolean checkIfPass(){
        return this.passed;
    }
    public boolean changeToTrue(){
       return this.passed = true;
    }
    public boolean changeToFalse(){
        return this.passed = false;
    }
    public String getName() {
        return name;
    }

    public int cardCount(){
        return this.hand.size();
    }

    public String showCard(int index){
        return this.hand.get(index).cardName();
    }

    public void takeCard(Card card){
        this.hand.add(card);
    }


    public int handTotal(){
        int total = 0;
        int acecount = 0;
        for(Card card : this.hand){
            total += card.getValue();
            if (card.getValue() == 11){
                acecount += 1;
            }
        }
        if(total > 21 && this.checkForAce()){
             total -= 10;
        }
        if(total > 21 && acecount >= 2){
            total -= 10;
        }

        if(total > 21 && acecount >= 3){
            total -= 10;
        }
        return total;
    }
}

