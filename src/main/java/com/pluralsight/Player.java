package com.pluralsight;

public class Player {
    //Stores the player's name
    private String name;

    //Each player has a hand
    private Hand hand;

    //Constructor
    public Player (String name){
        this.name = name;

        //Create a new hand for the player
        hand = new Hand();
    }
    //Returns the player's name
    public String getName(){
        return name;
    }
    //Returns players hand
    public Hand getHand(){
        return hand;
    }
    //Returns player's score
    public int getScore(){
        return hand.getValue();
    }
    //Returns a string version of the player
    @Override
    public String toString(){
        return name + "'s Hand:\n" + hand + "Total Value: " + getScore();
    }
}
