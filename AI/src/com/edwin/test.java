package com.edwin;

public class test {
    public static void main(String[] args){
            Player p = new Player(1,10);
            Dealer d = new Dealer();
            Distribute s = new Distribute(false);
//        d.addCard(11);
//        d.addCard();
//        d.addCard(0);
//        p.clearHands();
            p.addCard(s.intdis());
            p.addCard(s.intdis());
            System.out.println(p);
            System.out.println(p.blackjack());
    }
}
