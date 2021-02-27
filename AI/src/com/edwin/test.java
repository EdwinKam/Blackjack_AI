package com.edwin;

public class test {
    public static void main(String[] args){
        Distribute set = new Distribute(2, 0.6);
        Player p = new Player(1,100);
        Dealer d = new Dealer();
        int curGame=0;
        int gameNum=10;
        while(curGame++<gameNum){
            set.checkDeck(); //check if we need to reset the set
            p.clear();
            d.clear();
            System.out.printf("%d=======new game==========\n",curGame);
            while(!p.bust()){
                p.addCard(set.intdis());
            }
            System.out.println(p);
            while(!d.bust()){
                d.addCard(set.intdis());
            }
            System.out.println(d);

        }
    }
}
