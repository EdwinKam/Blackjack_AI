package com.edwin;

import java.util.*;

public class Simulator {
    private boolean isSim; //true then using sumulator
    static Scanner s = new Scanner(System.in);
    private int numset;
    private int[]deck;
    private int index; //keep track on what card we are on, total card distributed
    public int positive;
    private double percent;
    private int totalCard;
    Random rand = new Random();

    Simulator(){
        this.isSim=false;
        this.positive =0;
        this.index=1;
    }
    Simulator(int numset, double percent){ //maybe wanna take more para, such as when reshuffle
        this.isSim = true;
        this.numset=numset;
        this.totalCard=52*numset;
        deck = new int[totalCard+1];
        create();
        shuffle();
        this.index =1;

        this.percent=percent;
    }

    public int intdis(String message){
        int ans;
        if(!isSim) { //get from user
            index++; //inc the index, which is the total card distributed
            while (true) {
                System.out.print(message);
                String input = s.next();
                try {
                    ans = Integer.parseInt(input);
                    if (ans > 1 && ans < 11) {
                        break;
                    }
                } catch (Exception e) {
                    input = input.toLowerCase();
                    if (input.equals("a")) {
                        ans= 1;
                        break;
                    } else if (input.equals("j")) {
                        ans= 12; //11 is A 12 is J
                        break;
                    } else if (input.equals("q")) {
                        ans= 13;
                        break;
                    } else if (input.equals("k")) {
                        ans= 14;
                        break;
                    } else if (input.equals("done")) {
                        ans= -1;
                        break;
                    }
                }
                System.out.println("Please enter a valid card 2-10, AJQK");
            }
        }else{
            //if not getting from input
            ans= deck[index++];
        }

        if (ans <= 7 && ans>= 2)//2-7 positive
        {
            positive++;
        }
        else if (ans > 9 || ans == 1)//10 and A negetive
        {
            positive--;
        }
        return ans;//distribute the next card
    }


    public void shuffle()
    {
        if(!isSim){
            return;
        }
        for (int i = 1; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length-1)+1;
            int temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
        this.index=1; //since we gonna redistribute
        this.positive=0;
        System.out.println("\n***Shuffling***");
    }

    public void checkDeck(){
        if(!isSim){
            return;
        }
        if(index>(int)(percent*(double)totalCard)){
            shuffle();
        }
    }

    public int gameCount(){
        return index;
    }
    private void create(){
        if(!isSim){
            return;
        }
        deck[0] = 0;
        for (int i = 0; i < this.numset*4; i++)//new set of card
        {
//            System.out.println(13+i*13);
            deck[1 + i * 13] = 1;
            deck[2 + i * 13] = 2;
            deck[3 + i * 13] = 3;
            deck[4 + i * 13] = 4;
            deck[5 + i * 13] = 5;
            deck[6 + i * 13] = 6;
            deck[7 + i * 13] = 7;
            deck[8 + i * 13] = 8;
            deck[9 + i * 13] = 9;
            deck[10 + i * 13] = 10;
            deck[11 + i * 13] = 12;
            deck[12 + i * 13] = 13;
            deck[13 + i * 13] = 14;

        }//for
    }

    public boolean getIsSim(){
        return isSim;
    }
}
