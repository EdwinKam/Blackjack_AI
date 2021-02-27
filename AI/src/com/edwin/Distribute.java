package com.edwin;

import java.util.*;

public class Distribute {
    private boolean isSim; //true then using sumulator
    static Scanner s = new Scanner(System.in);
    Distribute(boolean isSim){
        this.isSim=isSim;

    }

    public int intdis(){
        if(!isSim){ //get from user
            int ans;

            while(true) {

                System.out.print("Please enter the card that you got: ");
                String input = s.next();
                try {
                    ans = Integer.parseInt(input);
                    if(ans>1&&ans<11){
                        return ans;
                    }
                }catch (Exception e){
                    input = input.toLowerCase();
                    if (input.equals("a")){
                        return 1;
                    }else if(input.equals("j")){
                        return 12; //11 is A 12 is J
                    }else if(input.equals("q")){
                        return 13;
                    }else if(input.equals("k")){
                        return 14;
                    }
                }
                System.out.println("Please enter a valid card 2-10, AJQK");
            }
        }
        return 1;
    }

}
