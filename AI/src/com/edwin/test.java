package com.edwin;

public class test {
    public static void main(String[] args){
        Distribute set = new Distribute(2, 0.6);
        Player p = new Player(1,100);
        Dealer d = new Dealer(1);
        p.addCard(10);
        p.addCard(10);
        p.split();
        p.addCard(10);
        p.addCard(p.getLast(),6);
        p.split();
        p.addCard(1);
        p.addCard(p.getLast(),9);
        System.out.println(p);

        System.out.println(p.asset);
    }
}
