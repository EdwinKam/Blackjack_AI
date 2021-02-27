package com.edwin;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;
    public boolean hasAce;
    private double bet; //bet ont this hand
    private boolean doubled;
    //constructor
    Hand(double base){
        hand = new ArrayList<>();
        hasAce = false;
        doubled = false;
        bet=base;
    }

    //add cards
    public void append(int num){
        if(doubled&&hand.size()>=2){
            throw new IllegalArgumentException("No append again because doubled");
        }
        if(num==1||num==11){
            hasAce=true;
        }
        hand.add(new Card(num));
    }

    //add card, take Card obj
    public void append(Card card){
        if(doubled&&hand.size()>=2){
            throw new IllegalArgumentException("No append again because doubled");
        }
        if(card.value()==1||card.value()==11){
            hasAce=true;
        }
        hand.add(card);
    }

    //remove the lsat card, and return card
    public Card remove(){
        Card temp = hand.get(hand.size()-1); //get last element
        hand.remove(hand.size()-1);
        return temp;

    }


    public boolean blackjack(){
        if(hand.size()==2&&this.handSum()==21){
            return true;
        }
        return false;
    }


    public boolean bust(){
        if (this.handSum()>21){
            hand = new ArrayList<>(); //clear()
            return true;
        }else{
            return false;
        }
    }

    //sum of this hand
    public int handSum(){
        int sum=0;
        for(int i =0;i<hand.size();i++){
            sum+=hand.get(i).value();
        }
        if(hasAce&&this.size()==1){
            return 1;
        }

        if(hasAce&&sum<=11){
            return sum+10;
        }
        return sum;
    }

    public int size(){
        return hand.size();
    }

    public boolean canSplit(){ //two cards are the same
        if(hand.size()==2&&hand.get(0).toString().equals(hand.get(1).toString())){

            return true;
        }else{
            return false;
        }
    }

    public int getFirst(){
        return hand.get(0).value();
    }
    public String toString(){
        return hand.toString();
    }

    public void setBet(double  curBet){
        bet=curBet;
    }

    public double getBet() {
        return bet;
    }

    public void doubleHand(){
        doubled = true;
        setBet(bet*2); //double the bet
    }

}
