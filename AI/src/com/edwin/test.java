package com.edwin;

public class test {
    public static void main(String[] args){
        Distribute set = new Distribute(2, 0.6);
        Player p = new Player(1,100);
        p.setBet(2);
        p.addCard(8);
        p.addCard(8);
        p.split();

        p.setDouble(0);
        p.addCard(3);
        p.lose(0);
        p.lose(1);
        System.out.println(p);
        p.clear();

        System.out.println(p.asset);
    }
}
