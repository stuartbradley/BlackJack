package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by stuartbradley on 29/05/2017.
 */

public class Player {

    private String name;
    private int age;
    private int card1;
    private int card2;
    private int handTotal=0;
    private int playerHandTotal;
    ArrayList cards = new ArrayList();
    Scanner scanner = new Scanner(System.in);

    public Player(){
        this.name = setPlayersName();
        this.age = setAge();
        checkAge();
        Instructions.checkIfPlayerCanPlay(name);
    }

    public String setPlayersName(){
        Prompter.showAskNameMessage();
        return scanner.nextLine();
    }
    public int setAge(){
        Prompter.showAskAgeMessage();
        return scanner.nextInt();
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public ArrayList<Integer> getCards() {
        return cards;
    }

    public void getStartingCards(ArrayList deck){
        cards.add(deck.get(0));
        card1 = Card.getNumberFromCard(deck.get(0).toString());
        deck.remove(0);
        cards.add(deck.get(0));
        card2 = Card.getNumberFromCard(deck.get(0).toString());
        deck.remove(0);
    }
    public void checkAge(){
        if(age<18){
            Prompter.showUnderAgeMessage();
            System.exit(0);
        }
    }
    public void displayHandsTotal(Player player){
        Prompter.showHand(cards, player.getName());
        Prompter.showPlayerHandTotal(player);
    }

    public int getPlayersHandTotal() {
        playerHandTotal = 0;
        int cardNumber;
        for (Object card : cards) {
            if (Card.getNumberFromCard(card.toString()) >10){
                cardNumber = 10;
            }else{
                cardNumber = Card.getNumberFromCard(card.toString());
            }
            playerHandTotal += cardNumber;
        }
        return playerHandTotal;
    }

}
