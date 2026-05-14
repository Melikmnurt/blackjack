package com.pluralsight;

public class Card {
    private String suit;                      //Stores the suit of the card
    private String value;                    //Stores the value of the card
    private boolean isFaceUp;               //Determines whether the card is face up

    //Constructor
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = true;                //Cards will start face up
    }

    public String getSuit() {                //Returns the suit of the card
        return suit;
    }

    public String getValue() {             //Returns the value of the card
        return value;
    }

    public boolean isFaceUp() {           //Returns whether the card is face up
        return isFaceUp();
    }

    //Determines the blackjack point value of the card
    public int getPointValue() {

        //Ace is worth 11 points
        if (value.equals("A")) {
            return 11;
        }
        //Face cards are worth 10 points
        if (value.equals("K") || value.equals("Q") || value.equals("J")) {
            return 10;
        }
        //Numeric cards are worth their number value
        return Integer.parseInt(value);
    }

    //Flips the card over
    public void flip() {
        isFaceUp = !isFaceUp;
    }

    //Returns a string version of the card
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}