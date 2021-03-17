package com.edwin;
//ooo
import java.util.*;

public class AI {
    static int numset = 2;
    static int gameNum = 10;
    static int curGame = 0;
    static double percent = 0.3;
//    static Simulator set = new Simulator(numset, percent);
    static Simulator set = new Simulator();
    static Player p = new Player("Player", 1, 100);
    static Player d = new Player("Dealer", 1, 100);
    static int handscount = 0;

    public static void main(String[] args) {
        //CreateFile file = new CreateFile("number2.txt");
//        System.out.println("Enter 1 = 124, 2 = 1246, 3 = 138");
//        System.out.println("--------below 80------------------------");
//        System.out.println("Enter 4 = 124, 5 = 1246, 6 = 138");
//        System.out.println("--------below 80------------------------");
//        System.out.println("Enter 7 = six deck");
//        Scanner s = new Scanner(System.in);
//        int userInput = s.nextInt();
//        while (userInput < 1 || userInput > 7) {
//            System.out.print("Your choice (1-7): ");
//            userInput = s.nextInt();
//        }
////        double percent; //the percentage we are using before reshuffle the cord
//        if (userInput == 7) {
//            numset = 6;       //change to play 6 pack
//            percent = 0.75;        //when 1.5 pack left
//        } else {
//            percent = 0.65;
//        }

        //starting looping games
        while (curGame++ < gameNum) {
            set.checkDeck(); //check if we need to reset the set
            p.clear(); //clear player and dealer hands
            d.clear();
            handscount=0; //start from 0
            System.out.printf("%d=======new game==========\n", curGame);
            if (set.positive <= 3)//if current poaitive less than this number, then set bet to ...
            {
                p.setBet(1);
                System.out.printf("Current positivity: %d.\tLast game bet was: %.2f\n", set.positive, p.lastGame);
                System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
            } else //if greater than that positive
            {
                if (p.lastGame == 1) {
                    p.setBet(2);
                    System.out.printf("Current positivity: %d.\tLast game bet was: %.2f\n", set.positive, p.lastGame);
                    System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
                } else if (p.lastGame == 4) {
                    p.setBet(4);
                    System.out.printf("Current positivity: %d.\tLast game bet was: %.2f\n", set.positive, p.lastGame);
                    System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
                } else if (p.lastGame == 2) {
                    p.setBet(4);
                    System.out.printf("Current positivity: %d.\tLast game bet was: %.2f\n", set.positive, p.lastGame);
                    System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
                } else {
                    System.err.println("error1");
                    System.exit(0);
                }
            }
            p.lastGame = (int) p.curBet;

            //open game------
            
            p.addCard(set.intdis("Player first card: "));
            p.addCard(set.intdis("Player second card:"));
            d.addCard(set.intdis("Dealer first: "));
            int others=0;
            List<Card> list = new LinkedList<>();
            while(others!=-1){ //if "done" input, it will return -1
                others=set.intdis("Enter all other players' cards one by one, type \"done\" to finish: ");
                if(others!=-1){
                    list.add(new Card(others));
                }
            }
            System.out.print("The following cards were input: ");
            System.out.println(list.toString());
            System.out.println(d);
            System.out.println(p);
            //-------------------------
            
            boolean secondDis = false;
            if (d.handSum() == 1 || d.handSum() == 10) { //ask if dealer has blackjack if dealer has A or 10
                //ask if dealer has bj

                if (set.getIsSim()) { //if its simulator, just int second second
                    d.addCard(set.intdis("Simlualtor"));
                    secondDis = true;
                } else {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Dealer has blackjack?");
                    if (s.nextBoolean()) {
                        d.addCard(set.intdis("Enter dealer hidden card: should be 10 or A: "));
                    }
                }
            }
            if (d.blackjack() && p.blackjack()) { //if dealer and player have bj
                System.out.println("everyone has blackjack PUSH!!!!");
                p.result(d.handSum());
            } else if (d.blackjack() && !p.blackjack()) {//dealer has bj but player dont
                System.out.println("SORRY!!");
                p.result(d.handSum());
            } else if (p.blackjack() && !d.blackjack()) {//player has blackjack
                System.out.println("Dealer no blackjack");
                p.setBet(1.5);
                p.result(d.handSum());
            } else if (!d.blackjack() && !d.blackjack()) {//if dealer no blackjack and player no blackjack
                System.out.println("-----------------Call section-----------------");
                if (p.canSplit(handscount) && p.handSum(handscount) != 20)//pairs except 10
                {
                    play(splitaction(p.getFirst(handscount)));//go to split with that card
                } else if (p.hasAce(handscount)&&p.withoutAce(handscount)<11) //if player has an ace
                {
                    play(aceaction(p.withoutAce(handscount))); //temp is sum here
                } else {
                    play(paction(p.handSum(handscount)));//just keep playing
                }
                //ask dealer hidden card after player is done
                
                if(!secondDis){ //if second card not yet distribute
                    d.addCard(set.intdis("Please enter dealer hidden hand: "));
                }
                System.out.println(d);
                //dealer turn
                for (int i = 0; i < p.size(); i++) {
                    if (!p.bust(i)) {
                        System.out.println("\"-----------------Dealer Turn----------------\"");
                        dealeraction();//dealeraction
                        break;
                    }
                }
                System.out.println(p);
                System.out.println(d);
                p.result(d.handSum());
                
            } else {
                throw new IllegalArgumentException("error main(): bj error");
            }
            others=0; //reset other, because others should be -1 now
            list = new LinkedList<>();
            while(others!=-1){ //if "done" input, it will return -1
                others=set.intdis("Enter all other players' cards one by one, type \"done\" to finish: ");
                if(others!=-1){
                    list.add(new Card(others));
                }
            }
            System.out.println("Player asset: "+p.asset);
        }
        
    }


//            System.out.printf("Player won: $ %.1f\tDealer won: $ %.1f\n", lastp, lastd);
//            System.out.printf("Player win: $ %.1f\tDealer win: $ %.1f\n", playercount, dealercount);
//            lastp = playercount;
//            lastd = dealercount;
//            System.out.printf("Player net winning: $%.1f\n", playercount - dealercount);
//            System.out.printf("Positive: %d\n", positive);
//
//            if (playercount - dealercount > maxmoney) //if current net win > peak
//            {
//                maxmoney = (int) playercount - (int) dealercount; //set new peak
//            } else {
//                if (maxmoney - (playercount - dealercount) > gap) {
//                    gap = (int) maxmoney - ((int) playercount - (int) dealercount);
//                }
//            }
//        }
//        System.out.printf("Gamecount: %d\tThis set used card count: %d", curGame, set.gameCount());
//
//        System.out.println();
//        System.out.println("===============================================================================");
//        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Player win game", playerwin, "Playerwin rate", playerwin / gamecount);
//        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Dealer win game", dealerwin, "Dealerwin rate", dealerwin / gamecount);
//        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "TIE game", tiegame, "Tie rate", tiegame / gamecount);
//        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Double win game", doublerate, "Double win rate", doublerate / gamecount);
//        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Split win game", split, "Split win rate", split / gamecount);
//        System.out.format("%-16s: $%.1f    %s: $%.1f\n", "Player wins", playercount, "Dealer wins", dealercount);
//        System.out.format("%-16s: $%.0f\n", "Player net winning", playercount - dealercount);
//        System.out.format("%-16s: $%d    %-10s:$%d\n", "Player max win", maxmoney, "Player max lose", gap);



    //functions
    
    public static void play(int action)//1hit 2double 3stand 4split 5split ace, can only hit once
    {
        if(p.splited(handscount)&&action==2){ //after split,cant double again
            action=1;
        }
        switch (action) {
            case 1: //hit
                //cout  << handscount + 1 << "player called hit" << endl;
                System.out.printf("%dplayer called hit\n", handscount + 1);
                p.addCard(handscount,set.intdis("Enter next player card: "));//distribute from play[2]
                System.out.println(p);

                if (p.handSum(handscount) < 12 && p.hasAce(handscount))//check whether stand with ace
                {
                    if (aceaction(p.handSum(handscount) - 1) == 1)//if supposed hit or double//both changed to 1 hit
                    {
                        play(1);//play(hit)
                    } else {
                        play(3);//play(stand)

                    }
                } else if (p.handSum(handscount) < 22)//without ace but <22
                {
                    if (paction(p.handSum(handscount)) == 1 || paction(p.handSum(handscount)) == 2)//if supposed hit or double
                    {
                        play(1);//play(hit)
                    } else {
                        play(3);//play(stand)

                    }
                } else
                    p.bust(handscount);//player busts
                break;
            case 2: //double
//                doublerate++;
//                checkdouble = 1;//double flag
                p.setDouble(handscount);
                p.addCard(handscount, set.intdis("Enter player double card: "));
                System.out.println(p);
                break;
            case 3://stand
                System.out.printf("%dplayer called stand\n", handscount + 1);

                break;
            case 4: //split
//                split++;
                p.split(handscount); //will assign to next avaiable hand
                p.addCard(handscount, set.intdis(String.format("Enter 2nd card for player%d", handscount + 1)));
                p.addCard(p.getLast(), set.intdis(String.format("Enter 2nd card for player%d", p.getLast() + 1)));
                System.out.println(p);
                while(handscount<=p.getLast()){
                    System.out.printf("----------------%dPlayer turn-----------------\n", handscount + 1);
                    start();//finish first hand
                    handscount++;//next hand
                }
                break;

            case 5://ace split
//                split++;
//                gg=gamecount;
                p.split(handscount);
                System.out.println("Player call split\n");
                System.out.println(p);
                p.addCard(handscount,set.intdis("second card to first Ace: "));
                p.addCard(p.getLast(),set.intdis("second card to the other Ace: "));
                System.out.println(p);
//                while(handscount<=p.getLast()){
//                    System.out.printf("----------------%dPlayer turn-----------------\n", handscount + 1);
//                    start();//finish first hand
//                    handscount++;//next hand
//                }
                break;

            default:
                // cout << "error5 got input of case "<<action;
                System.err.printf("error5 got input of case %d", action);
                System.exit(0);
                break;
        }
    }
    
    
    public static int paction(int sum)//without Ace
    {
        //1 = hit;
        //2 = double
        //3 = stand
        //4 = split
        switch (sum) {
//            case4: //error
            case 5:
            case 6:
            case 7:
            case 8: {
                //cout << "***player called hit" << endl;
                return 1;
            }
            //break;
            case 9:
                if (d.face() <= 6 && d.face() > 2) {
                    //cout << "***player called double" << endl;
                    return 2;

                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }

                //  break;
            case 10:
                if (d.face() <= 9 && d.face() > 1) {
                    //cout << "***player called double" << endl;
                    return 2;

                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }


                //break;
            case 11:
                if (p.blackjack())
                    return 3;
                else {
                    //cout << "***player called double" << endl;
                    return 2;
                }

                // break;
            case 12:
                if (d.face() >= 4 && d.face() <= 6) {
                    //cout << "***player called stand" << endl;
                    return 3;

                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }

                // break;
            case 13:
            case 14:
                if (d.face() <= 6 && d.face() > 1) {
                    //cout << "***player called stand" << endl;
                    return 3;

                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }
            case 15:
            case 16:
                if (d.face() <= 6 && d.face() > 1) {
                    //cout << "***player called stand" << endl;
                    return 3;

                } else if (set.positive >= 4) {
                    System.out.printf("Positive >= 4, player should call stand!!!!!!!!!!!");
//                if(!fifteen[handscount]){
//                    fifteen[handscount]=true;
//                    p15++;
//                }
                    // save[pan++] = gamecount + 1;//save split game
                    return 3;
                } else {
                    //save[pan++] = gamecount + 1;//save split game
//                if(!fifteen[handscount]){
//                    fifteen[handscount]=true;
//                    p15++;
//                }
                    System.out.println("Inced!!!!!!!!!!!!!");
                    //cout << "***player called hit" << endl;
                    return 1;
                }
            case 17:
            case 18:
            case 19:
            case 20:
            case 21: {
                //cout << "***player called stand" << endl;
                return 3;
            }


            //  break;
            default:

                System.err.printf("main(): error2 got input of case %d", sum);
                System.exit(0);
                return 0;
            //  break;
        }
    }

    public static int aceaction(int withoutAce) {
        switch (withoutAce) {
            case 2:
            case 3:
                if (d.face() <= 4 || d.face() >= 7)//1-4, 7-10
                {
                    //cout << "***player called hit" << endl;
                    return 1;
                } else {
                    //cout << "***player called double" << endl;
                    return 2;
                }
                //   break;
            case 4:
            case 5:
                if (d.face() <= 3 || d.face() >= 7)//1-3,7-10
                {
                    //cout << "***player called hit" << endl;
                    return 1;
                } else {
                    //cout << "***player called double" << endl;
                    return 2;
                }
                // break;
            case 6:
                if (d.face() >= 3 && d.face() <= 6)//3-6
                {
                    //cout << "***player called double" << endl;
                    return 2;
                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }
                // break;
            case 7:
                if (d.face() == 9 || d.face() == 10 || d.face() == 1)//9, 10 , 1
                {
                    //cout << "***player called hit" << endl;
                    return 1;
                } else if (d.face() == 2 || d.face() == 7 || d.face() == 8)//2, 7 , 8
                {
                    //cout << "***player called stand" << endl;
                    return 3;
                } else {
                    //cout << "***player called double" << endl;
                    return 2;
                }
                // break;
            case 8:
            case 9:
            case 10: //cout << "***player called stand" << endl;
                return 3;
            //break;
            default:
                //cout << "error3 got input of case "<< hand;
                System.err.printf("error3 got input of case %d", withoutAce);
                System.exit(0);
                return 0;
            // break;
        }
    }

    public static int splitaction(int hand) {
        switch (hand) {
            case 1:
                //cout << "***player called split" << endl;
                //split ace can only hit once
                return 5;
            // break;
            case 2:
            case 3:
                if (d.face() >= 4 && d.face() <= 7) {
                    //cout << "***player called split" << endl;
                    return 4;
                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }
                // break;
            case 4:
                if (d.face() >= 5 && d.face() <= 6) {
                    //cout << "***player called split" << endl;
                    return 4;
                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }
            case 5:
                if (d.face() == 1 || d.face() == 10) {
                    //cout << "***player called hit" << endl;
                    return 1;
                } else {
                    //cout << "***player called double" << endl;
                    return 2;
                }
                // break;
            case 6:
                if (d.face() >= 2 && d.face() <= 6) {
                    //cout << "***player called split" << endl;
                    return 4;
                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }
                // break;
            case 7:
                if (d.face() >= 2 && d.face() <= 7) {
                    //cout << "***player called split" << endl;
                    return 4;
                } else {
                    //cout << "***player called hit" << endl;
                    return 1;
                }
                // break;
            case 8:
                //cout << "***player called split" << endl;
                return 4;
            //break;

            case 9:
                if (d.face() == 7 || d.face() == 10 || d.face() == 1) {
                    //    cout << "***player called stand" << endl;
                    return 3;
                } else {
                    //cout << "***player called split" << endl;
                    return 4;
                }
                //  break;
            default:
                //cout << "error4 got input of case "<< hand;
                System.err.printf("main(): error4 got input of case %d", hand);
                System.exit(0);
                return 0;
            // break;
        }
    }


    

    public static void dealeraction() {
        if (d.handSum() >= 17){//dealer sum >17
            System.out.printf("Dealer stand \t\t\tdealer sum: %d\n", d.handSum());
        }else if ((d.hasAce() && d.withoutAce() == 6) || d.handSum() < 17) { //soft 17, ace and 6
//            System.out.println("Dealer soft 17!!!!!!!!!!!!!!!!!!!!!");
            d.addCard(set.intdis("Enter Dealer next: "));
            System.out.println(d);
            dealeraction();
        }
    }

    public static void start()
    {
        //for splited card
        if (p.canSplit(handscount) && p.handSum(handscount)==20)//pairs except 10
        {
            play(splitaction(p.handSum(handscount)/2));//go to split with that card
        }
        else if (p.hasAce(handscount)&&p.withoutAce(handscount)<11) //if player has an ace
        {
            play(aceaction(p.withoutAce(handscount)));
        }
        else
        {
            play(paction(p.handSum(handscount)));//just keep playing
        }

    }

    //end main class
}






