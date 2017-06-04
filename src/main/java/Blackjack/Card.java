package Blackjack;

/**
 * Created by stuartbradley on 30/05/2017.
 */


//get information from the card
public class Card {
    public static int getNumberFromCard(String card){
       String spiltCard[] =  card.split(" ");
       return Integer.parseInt(spiltCard[0]);
    }
    public static String getSuitFromCard(String card){
        String spiltCard[] =  card.split(" ");
        return spiltCard[1];
    }
    public static boolean isCardOver10OrAnAce(String card){
      return Card.getNumberFromCard(card.toString()) == 1 || Card.getNumberFromCard(card.toString()) > 10;
    }



}
