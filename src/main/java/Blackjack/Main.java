package Blackjack;


//TODO
//add chips

//TODO
//chance to spilt or double up

//TODO
//make Dealer class

//TODO
//make start of game method.

//TODO
//make cardDeck of cards.

//TODO
//ace = 1 or 11.



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Player player = new Player();
        Game.startGame(dealer, player,deck.getCardDeck());
    }

}
