package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        //Create the ArrayList
        cards = new ArrayList<>();

        //Arrays for suits and values
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        String[] values = {
                "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
        };
        //Create every card combination
        for (String suit : suits) {

            for (String value : values) {

                //Create a new card
                Card card = new Card(suit, value);

                //add card to deck
                cards.add(card);
            }
        }
    }

    public void shuffle() {

        //Shuffle the deck
        Collections.shuffle(cards);
    }

    public Card deal() {
        //Remove and return first card
        return cards.remove(0);
    }

    public int getSize() {
        return cards.size();

    }

    @Override
    public String toString() {
        String output = "";

        for (Card card : cards) {
            output += card + "\n";
        }
        return output;
    }
}