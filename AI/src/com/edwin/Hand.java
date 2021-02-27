package com.edwin;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;

    //constructor
    Hand(){
        hand = new ArrayList<>();
    }

    //add cards
    public void append(int num){
        hand.add(new Card(num));
    }

    //add card, take Card obj
    public void append(Card card){
        hand.add(card);
    }

    //remove the lsat card, and return card
    public Card remove(){
        Card temp = hand.get(hand.size()-1); //get last element
        hand.remove(hand.size()-1);
        return temp;

    }

    //sum of this hand
    public int handSum(){
        int sum=0;
        for(int i =0;i<hand.size();i++){
            sum+=hand.get(i).value();
        }
        return sum;
    }

    public int size(){
        return hand.size();
    }

    public boolean canSplit(){
        if(hand.size()==2&&hand.get(0).getId()==hand.get(1).getId()){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
        return hand.toString();
    }

}
