package com.edwin;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;
    Hand(){
        hand = new ArrayList<>();
    }
    public void append(int num){
        hand.add(new Card(num));
    }
    public void append(Card card){
        hand.add(card);
    }
    public Card remove(){
        Card temp = hand.get(hand.size()-1); //get last element
        hand.remove(hand.size()-1);
        return temp;

    }
    public String toString(){
        return hand.toString();
    }

}
