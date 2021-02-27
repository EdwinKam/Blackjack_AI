package com.edwin;

import javax.net.ssl.SNIHostName;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public double baseBet;
    public double asset; //how much this player has
    private List<Hand> hands;

    //constructor
    Player(int base, int baseMoney){
        hands = new ArrayList<Hand>(); //can have more hand
        hands.add(new Hand()); //add one hand to this player, no card in this hand
        baseBet=base;
        asset=baseMoney;
    }

    //add card to this player
    public void addCard(int id){
        hands.get(0).append(id); //add new card to the first hand
    }

    //in case this player has more than one hand
    public void addCard(int index, int id){
        hands.get(index).append(id); //add new card to the index th hand
    }

    //split player first hand
    public void split(){
        assert hands.get(0).canSplit(): "Cant split this hand";
        Card temp = hands.get(0).remove();
        hands.add(new Hand()); //add another hand
        hands.get(hands.size()-1).append(temp);
    }

    //split player index th hand
    public void split(int index){
        assert hands.get(index).canSplit(): "Cant split this hand";
        Card temp = hands.get(index).remove();
        hands.add(new Hand()); //add another hand
        hands.get(hands.size()-1).append(temp);
    }

    public void clearHands(){
        hands = new ArrayList<Hand>(); //create new hand()
        hands.add(new Hand()); //add one hand to this player, no card in this hand
    }

    //sout player hands
    public String toString(){
        String str="Player";
        for(int i =0;i<hands.size();i++){
            if(i!=0){
                str+="\nPlayer";
            }
            str+=String.format("%d: %s",i+1,hands.get(i).toString());
        }
        return str;
    }

}
