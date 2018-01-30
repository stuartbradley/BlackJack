package blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 * Created by stuartbradley on 29/05/2017.
 */
public class Game {
    public Game(Dealer dealer, Player player, ArrayList deck) throws InterruptedException {
        Prompter.showStartingGameMessage();
        player.getStartingCards(deck);
        dealer.getStartingCards(deck);
        player.displayHandsTotal(player);
        Prompter.showDealersFirstCard(dealer);
        hitOrStick(player, deck);
        dealerPlay(dealer, deck);
        runEndGame(dealer, player);
    }

    public static void runEndGame(Dealer dealer, Player player){
        checkIfDealerBust(dealer);
        checkIfDealerBeatPlayer(dealer,player);
        checkIfPlayerWon(dealer,player);
    }

    public static void checkIfDealerBust(Dealer dealer) {
        if (dealer.getDealersHandTotal() > 21) {
            Prompter.showDealerBustMessage(dealer);
            System.exit(0);
        }
    }
    public static void checkIfDealerBeatPlayer(Dealer dealer, Player player) {
        if (dealer.getDealersHandTotal() > player.getPlayersHandTotal()) {
            Prompter.showDealerBeatPlayerMessage(dealer);
            System.exit(0);
        }
    }
    public static void checkIfPlayerWon(Dealer dealer, Player player){
        if(player.getPlayersHandTotal() > dealer.getDealersHandTotal()){
            Prompter.showPlayerBeatPlayerMessage(player);
            System.exit(0);
            }
    }

    public static void hit(ArrayList cards, Player player, ArrayList deck){
        cards.add(deck.get(0));
        Prompter.showPlayerDealtCard(deck.get(0).toString());
        deck.remove(0);
        Prompter.showPlayerHandTotal(player);
    }

    public static void hit(ArrayList cards, Dealer dealer, ArrayList deck){
        cards.add(deck.get(0));
        Prompter.showDealerDealtCard(deck.get(0).toString());
        deck.remove(0);
        Prompter.showDealerHandTotal(dealer);
    }

    public static void hitOrStick(Player player,ArrayList deck) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        boolean hitting;
        do {
            hitting = false;
            if(Prompter.askPlayerHitOrStick()){
                hit(player.getCards(),player,deck);
                hitting = true;
            }
            //make player.getplayershandtotal > 21 its own method for testing
            if(player.getPlayersHandTotal() > 21) {
                Prompter.showPlayersBustMessage(player);
                System.exit(0);
            }
        }while(hitting && (player.getPlayersHandTotal() < 22));
    }

        //make dealer.getdealershandtotal < 17 its own method for testing
    public static void dealerPlay(Dealer dealer, ArrayList deck) throws InterruptedException{
        Prompter.showDealersStartingCards(dealer);
        if(dealer.getDealersHandTotal()<17) {
            do {
                hit(dealer.getCards(), dealer,deck);
                TimeUnit.SECONDS.sleep(1);
            } while (dealer.getDealersHandTotal() < 17);
        }
    }


//    public static boolean doubleUp(Player player){
//        Scanner scanner = new Scanner(System.in);
//        if(player.getStartingHandTotal() < 12){
//            System.out.println("Would you like to double up?");
//            boolean ans = scanner.nextLine().toLowerCase().startsWith("y");
//            if(ans){
//                hit(player.getCards(), player);
//                return true;
//            }
//        }
//        return false;
//    }
}
