package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        //Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Ask for player names
        System.out.print("Enter Player 1 Name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter Player 2 Name: ");
        String player2Name = scanner.nextLine();

        //Create Players
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        //Create deck
        Deck deck = new Deck();

        //Shuffle Deck
        deck.shuffle();

        //Deal 2 cards to each other player
        for (int i = 0; i < 2; i++) {

            //Deal card to player1
            player1.getHand().deal(deck.deal());
        }
        //Display player hands
        System.out.println();
        System.out.println(player1);

        System.out.println();
        System.out.println(player2);

        //Get Scores
        int player1score = player1.getScore();
        int player2score = player2.getScore();

        System.out.println();

        //Determine winner

        //Both players busted
        if (player1score > 21 && player2score > 21) {
            System.out.println("Both players busted!");
        }
        //Player 1 wins
        else if (
                (player1score <= 21) && (player1score > player2score || player2score > 21)
        ) {
            System.out.println(player1.getName() + "wins!");
        }
        //Player 2 wins
        else if (
                (player2score <= 21) && (player2score > player1score || player1score > 21)
        ) {
            System.out.println(player2.getName() + "Wins!");
        }
//Tie game
        else {
            System.out.println("It's a tie!");
        }
//Close Scanner
        scanner.close();
    }
}