public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue(){
        return this.rank.getValue();
    }

    public boolean checkForAce(){
        if(this.rank.getValue() == 11){
            return true;
        }else{
            return false;
        }
    }


//    public Card changeValue(Card card){
//        card.rank.changeValue();
//        return card;
//
//    }
//    public Card changeBack(Card card){
//        card.rank.changeBack();
//        return card;
//    }
    public String cardName(){
        return String.format("%s of %s", this.rank, this.suit);
    }
}
