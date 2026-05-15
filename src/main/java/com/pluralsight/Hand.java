package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    //Stores all cards in the hand
    private ArrayList<Card> cards;

    //Constructor
    public Hand() {
        //Create the ArrayList
        cards = new ArrayList<>();
    }
    //Adds a card to the hand
    public void deal (Card card){
            cards.add(card);
    }
    //Returns the number of cards in the hand
    public int getSize(){
        return cards.size();
    }
    //Calculates the total blackjack value of the hand
    public int getValue(){
        int value = 0;
        int aceCount = 0;

        //Loop through all cards
        for (Card card : cards) {

            //Add each card value
            value += card.getPointValue();
            if (card.getValue().equals("A")) {
                aceCount++;
            }
        }
            while (value > 21 && aceCount > 0){
                value -= 10;
                aceCount--;
            }

        return value;
    }
    //Returns a string version of the hand
    @Override
    public String toString(){
        String output = "";

        //Display every card
        for (Card card : cards){
            output += card + "\n";
        }
        return output;
    }
}
