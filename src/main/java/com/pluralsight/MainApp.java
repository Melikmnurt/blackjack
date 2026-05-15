package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        //Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Ask for number of players
        System.out.print("How many players? ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        //Create ArrayList of players
        ArrayList<Player> players = new ArrayList<>();

        //Create Players
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter Player " + i + " Name: ");
            String name = scanner.nextLine();

            players.add(new Player(name));
        }
        //Create deck
        Deck deck = new Deck();

        //Shuffle Deck
        deck.shuffle();

        //Deal 2 cards to each other player
        for (int i = 0; i < 2; i++) {

            //Deal 2 cards to every player
            for (Player player : players) {
                player.getHand().deal(deck.deal());
            }
        }
        //Each player takes a turn
        for (Player player : players){

            boolean playing = true;

            //Keep taking turns until player stays or busts
            while (playing){
                System.out.println();
                System.out.println(player);

                //If player busts automatically end turn
                if (player.getScore() > 21){

                    System.out.println(player.getName() + " Busted !");
                    break;
                }
                //Ask player to hit or stay
                System.out.print(player.getName() + " - Hit or Stay?");
                String choice = scanner.nextLine();

                //Player chooses hit
                if (choice.equalsIgnoreCase("hit")){
                    player.getHand().deal(deck.deal());
                }
                //Player chooses stay
                else {
                    playing = false;
                }
            }
        }
        //Display all player hands
        for (Player player : players) {

            System.out.println();
            System.out.println(player);
        }
        //Determine Winner
        Player winner = null;
        int highestScore = 0;

        //Loop through all players
        for (Player player : players) {
            int score = player.getScore();

            //Player must be 21 or less
            if (score <= 21 && score > highestScore) {

                highestScore = score;
                winner = player;
            }
        }
        System.out.println();

        //Dsiplay winner
        if (winner == null) {

            System.out.println("Everyone Busted!");
        } else {

            {
                System.out.println(winner.getName() + " Wins!");
            }
//Close Scanner
            scanner.close();
        }
    }
}