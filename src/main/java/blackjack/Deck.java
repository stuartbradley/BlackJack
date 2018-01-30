package blackjack;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by stuartbradley on 30/05/2017.
 */


public class Deck {
    ArrayList suits = new ArrayList();
    ArrayList cardNumber = new ArrayList();
    ArrayList cardDeck = new ArrayList();

    public ArrayList getCardDeck() {
        return cardDeck;
    }

    public Deck(){
        makeSuits();
        makeCardNumber();
        shuffleDeck(makeDeck());
    }

    public void makeSuits(){
        suits.add("hearts");
        suits.add("diamonds");
        suits.add("clubs");
        suits.add("spades");
    }

    public void makeCardNumber(){
        for(int i = 1; i < 14; i++) {
            cardNumber.add(i);
        }
    }

    public ArrayList makeDeck(){
        for (Object suit : suits) {
            for (Object number : cardNumber) {
                cardDeck.add(number.toString() + " " +suit);
            }
        }
        return cardDeck;
    }
    public ArrayList shuffleDeck(ArrayList deck){
        Collections.shuffle(deck);
        return deck;
    }

}






