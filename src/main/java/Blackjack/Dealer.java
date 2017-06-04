package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by stuartbradley on 29/05/2017.
 */
public class Dealer{
    private int card1;
    private int card2;
    private int cardsuit1;
    private int cardsuit2;
    private int dealersHandTotal;
    ArrayList cards = new ArrayList();

    public Dealer(){
    }

    public String getCard1(){
        return(cards.get(0).toString());
    }
    public String getCard2(){
        return(cards.get(1).toString());
    }
    public ArrayList<Integer> getCards() {
        return cards;
    }

    public int getDealersHandTotal() {
        dealersHandTotal = 0;
        int cardNumber;
        for (Object card : cards) {
            if (Card.getNumberFromCard(card.toString()) >10){
                cardNumber = 10;
            }else{
                cardNumber = Card.getNumberFromCard(card.toString());
            }
            dealersHandTotal += cardNumber;
        }
        return dealersHandTotal;
    }

    public void getStartingCards(ArrayList deck){
        cards.add(deck.get(0));
        card1 = Card.getNumberFromCard(deck.get(0).toString());
        deck.remove(0);
        cards.add(deck.get(0));
        card2 = Card.getNumberFromCard(deck.get(0).toString());
        deck.remove(0);
    }
}
