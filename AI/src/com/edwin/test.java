package com.edwin;

public class test {
    public static void main(String[] args){
            Player p = new Player(1,10);
            Dealer d = new Dealer();
            Distribute s = new Distribute(2,0.1);
            s.shuffle();
            for(int i=0;i<104;i++){
                System.out.println(s.intdis());
            }
    }
}
