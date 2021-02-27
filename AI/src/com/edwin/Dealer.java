package com.edwin;

import javax.net.ssl.SNIHostName;

public class Dealer {
    private Hand hand;
    Dealer(double base){
        hand = new Hand(base);
    }
    public void clear(double base){
        hand = new Hand(base);
    }

    public void addCard(int id){
        hand.append(id); //add new card to the first hand
    }

    public boolean bust(){
        return hand.bust();
    }

    public boolean blackjack(){
        return hand.blackjack();
    }

    public int face(){
        return hand.getFirst();
    }
    public String toString(){
        return String.format("Dealer: %s \t\tSum: %d",hand.toString(), hand.handSum());
    }
}
