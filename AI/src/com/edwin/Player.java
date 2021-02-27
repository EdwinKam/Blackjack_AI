package com.edwin;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public double baseBet;
    public double asset; //how much this player has
    private List<Hand> hand;

    Player(int base, int baseMoney){
        hand = new ArrayList<Hand>();
        baseBet=base;
        asset=baseMoney;
    }
    public String toString(){
        String str="";
        for(int i =0;i<hand.size();i++){
            if(i!=0){
                str+="\n";
            }
            str+=String.format("%d: %s",i+1,hand.get(i).toString());
        }
        return str;
    }

}
