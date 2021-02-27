package com.edwin;

public class test {
    public static void main(String[] args){
        Distribute set = new Distribute(2, 0.6);
        Player p = new Player(1,100);
        Dealer d = new Dealer();
        p.addCard(1);
        p.addCard(11);
        p.split();
        System.out.println(p);
    }
}
