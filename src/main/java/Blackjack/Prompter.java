package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by stuartbradley on 01/06/2017.
 */
public class Prompter {

    public static void showUnderAgeMessage(){
        System.out.println("Sorry you are not old enough to gamble");
    }
    public static void showHand(ArrayList cards, String name){
        if(Card.isCardOver10OrAnAce((String) cards.get(0)) && Card.isCardOver10OrAnAce((String) cards.get(1))) {
            showPictureCardName(cards.get(0).toString(), name);
            System.out.print(" and the ");
            showPictureCardName(cards.get(1).toString(), "");
        }else if(Card.isCardOver10OrAnAce((String) cards.get(0)) && !Card.isCardOver10OrAnAce((String) cards.get(1))){
            showPictureCardName(cards.get(0).toString(), name);
            System.out.print(" and the " + cards.get(1));

        }else if(!Card.isCardOver10OrAnAce((String) cards.get(0)) && Card.isCardOver10OrAnAce((String) cards.get(1))){
            System.out.println(name + " received the " + cards.get(0) +" and the ");
            showPictureCardName((String) cards.get(1), "");
        }else {
            System.out.println("You have received the " + cards.get(0) + " and the " + cards.get(1));
        }
    }

    public static void showDealersFirstCard(Dealer dealer) {
        if (Card.isCardOver10OrAnAce(dealer.getCard1())) {
            showPictureCardName(dealer.getCard1(), "Dealer");
        } else {
            System.out.println("The dealer has the " + dealer.getCard1());
        }
    }
    public static void showPlayerHandTotal(Player player) {
        System.out.println("Your hand adds up to " + player.getPlayersHandTotal());
    }
    public static void showDealerHandTotal(Dealer dealer) {
        System.out.println("Dealers hand adds up to " + dealer.getDealersHandTotal());
    }
    public static void showAskAgeMessage(){
        System.out.print("Please can you enter your age:  ");
    }
    public static void showAskNameMessage(){
        System.out.print("Please can you enter your name:  ");
    }
    public static void showStartingGameMessage(){
        System.out.println("Starting to deal");
    }
    public static void showDealerBustMessage(Dealer dealer){
        System.out.println("Dealer has bust with " + dealer.getDealersHandTotal() + " you win");
    }
    public static void showPlayersBustMessage(Player player){
        System.out.println("Sorry " + player.getName() + " you bust with " + player.getPlayersHandTotal());
    }
    public static void showDealerBeatPlayerMessage(Dealer dealer){
        System.out.println("Dealer has won with " + dealer.getDealersHandTotal());
    }
    public static void showPlayerBeatPlayerMessage(Player player){
        System.out.println(player.getName() + " has won with " + player.getPlayersHandTotal());
    }
    public static void showDealerDealtCard(String card) {
        if (Card.isCardOver10OrAnAce(card)) {
            showPictureCardName(card, "Dealer");
        } else {
            System.out.println("Dealer received a " + card);
        }
    }
    public static void showPlayerDealtCard(String card) {
        if (Card.isCardOver10OrAnAce(card)) {
            showPictureCardName(card, "you");
        } else {
            System.out.println("You received a " + card);
        }
    }
    public static boolean askPlayerHitOrStick() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to stick or hit?");
        TimeUnit.SECONDS.sleep(1);
        return scanner.nextLine().toLowerCase().startsWith("h");
    }
    public static void showDealersStartingCards(Dealer dealer){
        System.out.println("The dealer has " + dealer.getCard1() +" and " + dealer.getCard2()+
                " which makes " + dealer.getDealersHandTotal());
    }

    public static void showPictureCardName(String card, String name){
         int cardNumber = Card.getNumberFromCard(card.toString());
            switch (cardNumber){
                case 11: System.out.println(name +" received the Jack of " + Card.getSuitFromCard(card.toString()));
                break;
                case 12: System.out.println(name +" received the Queen of " + Card.getSuitFromCard(card.toString()));
                break;
                case 13: System.out.println(name +" received the King of " + Card.getSuitFromCard(card.toString()));
                break;
                case 1: System.out.println(name +" received the Ace of " + Card.getSuitFromCard(card.toString()));
            }
    }
}
