package com.edwin;

import javax.net.ssl.SNIHostName;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private double baseBet;
    public double curBet;
    public double lastGame;
    public double asset; //how much this player has
    private List<Hand> hands;
    private String name;

    //constructor
    Player(String name, double base, int baseMoney){
        this.name=name; //player or dealer
        hands = new ArrayList<Hand>(); //can have more hand
        hands.add(new Hand(base)); //add one hand to this player, no card in this hand
        baseBet=base;
        asset=baseMoney;
        curBet=base;
        lastGame=base;
    }

    //add card to this player
    public void addCard(int id){
        hands.get(0).append(id); //add new card to the first hand
    }

    //in case this player has more than one hand
    public void addCard(int index, int id){
        hands.get(index).append(id); //add new card to the index th hand
    }

    public boolean bust(){
        return hands.get(0).bust();
    }

    public boolean bust(int index){
        return hands.get(index).bust();
    }

    public boolean blackjack(){
        return hands.get(0).blackjack();
    }

    public boolean blackjack(int index){
        return hands.get(index).blackjack();
    }

    //split player first hand
    public void split(){
        if(!hands.get(0).canSplit()){
            throw new IllegalArgumentException("Card cannot be split");
        }
        Card temp = hands.get(0).remove();
        hands.add(new Hand(curBet)); //add another hand
        hands.get(hands.size()-1).append(temp);
    }

    //split player index th hand
    public void split(int index){
        if(!hands.get(index).canSplit()){
            throw new IllegalArgumentException("Card cannot be split");
        }
        Card temp = hands.get(index).remove();
        hands.add(new Hand(curBet)); //add another hand
        hands.get(hands.size()-1).append(temp);
    }

    public boolean canSplit(int index){
        return hands.get(index).canSplit();
    }

    public int handSum(int index){
        return hands.get(index).handSum();
    }

    public int handSum(){
        return hands.get(0).handSum();
    }

    public boolean hasAce(){
        return hands.get(0).hasAce;
    }

    public boolean hasAce(int index){
        return hands.get(index).hasAce;
    }

    public void clear(){
        hands = new ArrayList<Hand>(); //create new hand()
        hands.add(new Hand(baseBet)); //add one hand to this player, no card in this hand
        curBet=baseBet;
    }

    public int size(){
        return hands.size();
    }
    //sout player hands
    public String toString(){
        String str=name;
        for(int i =0;i<hands.size();i++){
            if(i!=0){
                str+="\nPlayer";
            }
            str+=String.format("%d: %s \t\tSum: %d Bet: %.2f",i+1,hands.get(i).toString(), hands.get(i).handSum(), hands.get(i).getBet());
        }
        return str;
    }

    public void setBet(double mult){
        curBet*=mult;
        hands.get(0).setBet(curBet);
    }

    public double getBet(int index){
        return hands.get(index).getBet();
    }
    public void win(int index){
        System.out.printf("%s%d won %.2f\n",name,index+1,hands.get(index).getBet());
        asset+=hands.get(index).getBet();
    }

    public void lose(int index){
        System.out.printf("%s%d lose %.2f\n",name,index+1,hands.get(index).getBet());
        asset-=hands.get(index).getBet();
    }

    public int getFirst(int index){
        return hands.get(index).getFirst();
    }

    public int face(){
        return hands.get(0).getFirst();
    }

    public void setDouble(int index){
        System.out.printf("Player%d called double\n",index+1);
        hands.get(index).doubleHand(); //will set bet
        //need to dist card in main
    }

    public void result(int dsum){
        for(int i=0;i<hands.size();i++){
            if(dsum<=21||(hands.get(i).bust()||dsum>hands.get(i).handSum())){
                lose(i);
            }else if(dsum>21||dsum<hands.get(i).handSum()){
                win(i);
            }else{
                System.out.println("PUSH");
            }
        }
    }
    public int getLast(){
        return hands.size()-1;
    }

    public int withoutAce(int index){
        return hands.get(index).withoutAce();
    }

    public int withoutAce(){
        return hands.get(0).withoutAce();
    }

    public boolean doubled(int index){
        return hands.get(index).doubled;
    }

}
