package Blackjack;

import java.util.Scanner;

/**
 * Created by stuartbradley on 28/05/2017.
 */
public class Instructions {



    public static void checkIfPlayerCanPlay(String name){
        Scanner reader = new Scanner(System.in);
        System.out.println(name + "do you know how to play blackjack (Yes/No)?");
        if (!reader.nextLine().toLowerCase().startsWith("y")){
            System.out.println("To beat the dealer's hand without exceeding a count of 21 in order to win as much money from the dealer (the casino) as you can.");
        }
    }
}
