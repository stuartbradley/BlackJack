package blackjack;


//TODO
//add chips

//TODO
//chance to spilt or double up

//TODO
//ace = 1 or 11.



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Player player = new Player();
        Game game = new Game(dealer, player,deck.getCardDeck());
    }

}
