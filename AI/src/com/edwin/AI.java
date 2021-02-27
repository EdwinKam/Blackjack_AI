//package com.edwin;
////ooo
//import java.util.Scanner;
//
//public class AI {
//    static int numset = 2;
//    static int gameNum = 100;
//    static int curGame = 0;
//    static double percent = 0.3;
//    static Distribute set = new Distribute(numset, percent);
//    static Player p = new Player(1, 100);
//    static Dealer d = new Dealer();
//    static int handscount=0;
//
//    public static void main(String[] args) {
//        //CreateFile file = new CreateFile("number2.txt");
////        System.out.println("Enter 1 = 124, 2 = 1246, 3 = 138");
////        System.out.println("--------below 80------------------------");
////        System.out.println("Enter 4 = 124, 5 = 1246, 6 = 138");
////        System.out.println("--------below 80------------------------");
////        System.out.println("Enter 7 = six deck");
////        Scanner s = new Scanner(System.in);
////        int userInput = s.nextInt();
////        while (userInput < 1 || userInput > 7) {
////            System.out.print("Your choice (1-7): ");
////            userInput = s.nextInt();
////        }
//////        double percent; //the percentage we are using before reshuffle the cord
////        if (userInput == 7) {
////            numset = 6;       //change to play 6 pack
////            percent = 0.75;        //when 1.5 pack left
////        } else {
////            percent = 0.65;
////        }
//
//
//        while (curGame++ < gameNum) {
//            set.checkDeck(); //check if we need to reset the set
//            p.clear();
//            d.clear();
//            System.out.printf("%d=======new game==========\n", curGame);
//            if (set.positive <= 3)//if current poaitive less than this number, then set bet to ...
//            {
//                p.setBet(1);
//                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", set.positive, p.lastGame);
//                System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
//            } else //if greater than that positive
//            {
//                if (p.lastGame == 1) {
//                    p.setBet(2);
//                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", set.positive, p.lastGame);
//                    System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
//                } else if (p.lastGame == 4) {
//                    p.setBet(4);
//                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", set.positive, p.lastGame);
//                    System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
//                } else if (p.lastGame == 2) {
//                    p.setBet(4);
//                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", set.positive, p.lastGame);
//                    System.out.printf("$$$$$$set bet to $ %.1f.\n", p.curBet);
//                } else {
//                    System.err.println("error1");
//                    System.exit(0);
//                }
//            }
//            p.lastGame = (int) p.curBet;
//
//            //open game------
//            //System.out.print("Dealer card ");
//            d.addCard(set.intdis());
//            d.addCard(set.intdis());
//            //System.out.print("Player first card ");
//            p.addCard(set.intdis());
//            //System.out.print("Player second card ");
//            p.addCard(set.intdis());
//            System.out.println(d);
//            System.out.println(p);
//            //-------------------------
//
//            if (d.blackjack() && p.blackjack()) {
//                System.out.println("PUSH!!!");
//            } else if (d.blackjack() && !p.blackjack())//dealer has bj but player dont
//            {
//                System.out.println("SORRY!!");
//            } else if (p.blackjack() && !d.blackjack())//player has blackjack
//            {
//                System.out.println("Dealer no blackjack");
//                p.win(1.5);
//                System.out.printf("Player gets $ %.1f \n", p.curBet);
//            } else if (!d.blackjack() && !d.blackjack())//if dealer no blackjack and player no blackjack
//            {
//                System.out.println("-----------------Call section-----------------");
//                if (p.canSplit(0) && p.handSum(0) != 20)//pairs except 10
//                {
//                    play(splitaction(p.getFirst(handscount)));//go to split with that card
//                } else if (p.hasAce(0)) //if player has an ace
//                {
//                    play(aceaction(p.handSum(handscount) - 1)); //temp is sum here
//                } else {
//                    play(paction(p.handSum(handscount)));//just keep playing
//                }
//                dealerflag = 1;//make sure only display dealer's turns once
////                System.out.print("Please enter dealer hidden hand: ");
////                dealer[1] = intdis();
//                dealeraction();//dealeraction
//            }
//
//            result();
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
//    }
//
//
//    //functions
//    public static int paction(int choice)//without Ace
//    {
//        //1 = hit;
//        //2 = double
//        //3 = stand
//        //4 = split
//        switch (choice) {
//            case 5:
//            case 6:
//            case 7:
//            case 8: {
//                //cout << "***player called hit" << endl;
//                return 1;
//            }
//            //break;
//            case 9:
//                if (d.face() <= 6 && d.face() > 2) {
//                    //cout << "***player called double" << endl;
//                    return 2;
//
//                } else {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//
//                //  break;
//            case 10:
//                if (d.face() <= 9 && d.face() > 1) {
//                    //cout << "***player called double" << endl;
//                    return 2;
//
//                } else {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//
//
//                //break;
//            case 11:
//                if (p.blackjack())
//                    return 3;
//                else {
//                    //cout << "***player called double" << endl;
//                    return 2;
//                }
//
//                // break;
//            case 12:
//                if (d.face() >= 4 && d.face() <= 6) {
//                    //cout << "***player called stand" << endl;
//                    return 3;
//
//                } else {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//
//                // break;
//            case 13:
//            case 14:
//                if (d.face() <= 6 && d.face() > 1) {
//                    //cout << "***player called stand" << endl;
//                    return 3;
//
//                } else {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//            case 15:
//            case 16:
//                if (d.face() <= 6 && d.face() > 1) {
//                    //cout << "***player called stand" << endl;
//                    return 3;
//
//                } else if (set.positive >= 4) {
//                    System.out.printf("Positive >= 4, player should call stand!!!!!!!!!!!");
////                if(!fifteen[handscount]){
////                    fifteen[handscount]=true;
////                    p15++;
////                }
//                    // save[pan++] = gamecount + 1;//save split game
//                    return 3;
//                } else {
//                    //save[pan++] = gamecount + 1;//save split game
////                if(!fifteen[handscount]){
////                    fifteen[handscount]=true;
////                    p15++;
////                }
//                    System.out.println("Inced!!!!!!!!!!!!!");
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//            case 17:
//            case 18:
//            case 19:
//            case 20:
//            case 21: {
//                //cout << "***player called stand" << endl;
//                return 3;
//            }
//
//
//            //  break;
//            default:
//
//                System.err.printf("main(): error2 got input of case %d", choice);
//                System.exit(0);
//                return 0;
//            //  break;
//        }
//    }
//
//    public static int aceaction(int hand)
//    {
//        switch (hand)
//        {
//            case 2:
//            case 3:
//                if (d.face() <= 4 || d.face() >= 7)//1-4, 7-10
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                else
//                {
//                    //cout << "***player called double" << endl;
//                    return 2;
//                }
//                //   break;
//            case 4:
//            case 5:
//                if (d.face() <= 3 || d.face() >= 7)//1-3,7-10
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                else
//                {
//                    //cout << "***player called double" << endl;
//                    return 2;
//                }
//                // break;
//            case 6:
//                if (d.face() >= 3 && d.face() <= 6)//3-6
//                {
//                    //cout << "***player called double" << endl;
//                    return 2;
//                }
//                else
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                // break;
//            case 7:
//                if (d.face() == 9 || d.face() == 10 || d.face()== 1)//9, 10 , 1
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                else if (d.face()== 2 || d.face() == 7 || d.face() == 8)//2, 7 , 8
//                {
//                    //cout << "***player called stand" << endl;
//                    return 3;
//                }
//                else
//                {
//                    //cout << "***player called double" << endl;
//                    return 2;
//                }
//                // break;
//            case 8:
//            case 9:
//            case 10: //cout << "***player called stand" << endl;
//                return 3;
//            //break;
//            default:
//                //cout << "error3 got input of case "<< hand;
//                System.err.printf("error3 got input of case %d", hand);
//                System. exit(0);
//                return 0;
//            // break;
//        }
//    }
//
//    public static int splitaction(int hand)
//    {
//        switch (hand)
//        {
//            case 1:
//                //cout << "***player called split" << endl;
//                return 5;
//            // break;
//            case 2:
//            case 3:
//                if (d.face() >= 4 && d.face() <= 7)
//                {
//                    //cout << "***player called split" << endl;
//                    return 4;
//                }
//                else
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                // break;
//            case 4:
//                if (d.face() >= 5 && d.face() <= 6)
//                {
//                    //cout << "***player called split" << endl;
//                    return 4;
//                }
//                else
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//            case 5:
//                if (d.face() == 1 || d.face() == 10)
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                else
//                {
//                    //cout << "***player called double" << endl;
//                    return 2;
//                }
//                // break;
//            case 6:
//                if (d.face() >= 2 && d.face() <= 6)
//                {
//                    //cout << "***player called split" << endl;
//                    return 4;
//                }
//                else
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                // break;
//            case 7:
//                if (d.face() >= 2 && d.face() <= 7)
//                {
//                    //cout << "***player called split" << endl;
//                    return 4;
//                }
//                else
//                {
//                    //cout << "***player called hit" << endl;
//                    return 1;
//                }
//                // break;
//            case 8:
//                //cout << "***player called split" << endl;
//                return 4;
//            //break;
//
//            case 9:
//                if (d.face() == 7 || d.face() == 10 || d.face() == 1)
//                {
//                    //    cout << "***player called stand" << endl;
//                    return 3;
//                }
//                else
//                {
//                    //cout << "***player called split" << endl;
//                    return 4;
//                }
//                //  break;
//            default:
//                //cout << "error4 got input of case "<< hand;
//                System.err.printf("main(): error4 got input of case %d", hand);
//                System. exit(0);
//                return 0;
//            // break;
//        }
//    }
//
//
//    public static void play(int action)//1hit 2double 3stand 4split 5splithit
//    {
//
//        switch (action)
//        {
//            case 1: //hit
//                //cout  << handscount + 1 << "player called hit" << endl;
//                System.out.printf("%dplayer called hit\n", handscount+1);
//                System.out.print("Enter player hit card: ");
//                p.addCard(set.intdis());//distribute from play[2]
////                psum = sum(player, handscount);//player sum
////                coutcard(player, "Player", handscount);//display card;
//
//                if (p.handSum(handscount) < 12 && p.hasAce(handscount))//check whether stand with ace
//                {
//                    if (aceaction(p.handSum(handscount) - 1) == 1)//if supposed hit or double//both changed to 1 hit
//                    {
//                        play(1);//play(hit)
//                    }
//                    else
//                    {
//                        play(3);//play(stand)
//
//                    }
//                }
//                else if (p.handSum(handscount) < 22)//without ace but <22
//                {
//                    if (paction(p.handSum(handscount)) == 1 || paction(p.handSum(handscount)) == 2)//if supposed hit or double
//                    {
//                        play(1);//play(hit)
//                    }
//                    else
//                    {
//                        play(3);//play(stand)
//
//                    }
//                }
//                else
//                    p.bust(handscount);//player busts
//                break;
//            case 2: //double
//                doublerate++;
//                checkdouble = 1;//double flag
//                p.setDouble(handscount);
//                System.out.printf("%dplayer called double\n", handscount+1);
//                System.out.printf("$$bet of $ %.1f \n", p.getBet(handscount));
//                System.out.print("Enter player double card: ");
//                p.addCard(handscount,set.intdis());
//                acevalue(player, handscount);//determine ace value
//                coutcard(player, "Player", handscount);
//                pbust(player, handscount);//check player busts
//                break;
//            case 3://stand
//                acevalue(player, handscount);
//                //cout << handscount + 1 << "player called stand\t\t\tFinal: " <<handscount +1<< "Player sum: " << sum(player, handscount) << endl;
//                System.out.printf("%dplayer called stand\n", handscount+1);
//                //coutcard(player, "Player",handscount);
//
//                break;
//            case 4: //split
//                split++;
//                p.split(handscount); //will assign to next avaiable hand
//                if (player[0]==11){///split the card the second hand
//                    player[i * 10] = 1;//however, if play[0] has ace but value of 11 could lead error
//                }
//                //so just assign it to one
//                else
//                {
//                    player[i * 10] =player[0];//otherwise assign second player the first player[o]
//                }
//                System.out.print("assign second card to second hand: ");
//                player[i * 10 + 1] = intdis();//assign second card to second hand
//                coutcard(player, "Player", i);//display second hand
//                //handscount--;//next hand
//                System.out.printf("----------------%dPlayer turn-----------------", handscount+1);
//                start();//finish first hand
//                handscount = i;//next hand
//                System.out.printf("----------------%dPlayer turn-----------------", handscount+1);
//                coutcard(player, "Player", handscount);//display second hand
//                //cout << "count" << handscount << endl;
//                playerhandcount = 1 + i * 10;//make sure disturebute to next stack
//                //cout << "playerhandcount" << playerhandcount<<endl;
//
//                start();//finish second hand
//                //handscount++;
//                break;
//
//            case 5://ace split
//                //save[pan++]=gamecount;//save split gamecount
//                split++;
//                gg=gamecount;
//                player[1]=intdis();//distribute first hand second card
//                player[10]=player[0];//distribute second hand first card
//                //coutcard(player, "player",handscount);//display first hand
//                acevalue(player, handscount);//determine ace value
//                coutcard(player, "Player", handscount);
//                pbust(player, handscount);//check player busts
//                handscount++;
//
//                player[11]=intdis();
//                //coutcard(player, "player",handscount);
//                acevalue(player, handscount);//determine ace value
//                coutcard(player, "Player", handscount);
//                pbust(player, handscount);//check player busts
//                break;
//
//            default:
//                // cout << "error5 got input of case "<<action;
//                System.err.printf("error5 got input of case %d",action);
//                System. exit(0);
//                break;
//        }
//    }
//    public static void dealeraction()
//    {
//        boolean pbust=true;//to see if dealer needs action
//        for(int i=0;i<p.size();i++){
//            if (!p.bust(i)){
//                pbust=false;
//            }
//        }
//
//        if (!pbust)//dealer needs action
//        {
//            if (dealerflag == 1) {
//                System.out.println("----------------Dealer turn-------------------");
//                coutcard(dealer, "Dealer", 0);
//                dealerflag = 0;//set dealer flag to 0 so it wouldnt display again
//            }
//            playerhandcount = 1;//initial playerhand
//            if (sum(dealer, 0) > 21)
//            {
//                dbust(dealer);//cehck dealer busts
//            }
//            else if (!checkace(dealer, 0) && sum(dealer, 0) > 16)//dealer sum >17
//            {
//                System.out.printf("Dealer stand \t\t\tdealer sum: %d\n", sum(dealer,0));
//
//
//            }
//            else if (checkace(dealer, 0) && sum(dealer, 0) > 7 && sum(dealer, 0) < 12)//dealer has ace and dealer sum-1 is 7-10
//            {
//                acevalue(dealer, 0);
//                System.out.printf("Dealer stand \t\t\tdealer sum: %d\n", sum(dealer,0));
//
//
//            }
//            else if (checkace(dealer, 0) && (sum(dealer, 0) - 1) == 6) //soft 17, ace and 6
//            {
//                System.out.println("Dealer soft 17!!!!!!!!!!!!!!!!!!!!!");
//                System.out.print("Enter Dealer: ");
//                dealer[dealerhandcount++] = intdis();
//                acevalue(dealer, 0);
//                coutcard(dealer, "Dealer", 0);
//                dbust(dealer);//check dealer busts
//                if (sum(dealer, 0) < 17)//if still <17
//                {
//                    System.out.print("Enter Dealer: ");
//                    dealer[dealerhandcount] = intdis();//distribute third card
//                    dealerhandcount++;
//                    coutcard(dealer, "Dealer", 0);
//                    dealeraction();//do dealer action again
//                }
//            }
//            else if (sum(dealer, 0) < 17)//if still <17
//            {
//                System.out.print("Enter Dealer: ");
//                dealer[dealerhandcount] = intdis();//distribute third card
//                dealerhandcount++;
//                coutcard(dealer, "Dealer", 0);
//                dealeraction();//do dealer action again
//            }
//        }
//    }
//    //end main class
//}
//
//
//
//
////
////        while (gamecount < gamenum){//loop until desired game amount played
////            cardcount = 1;
////            positive = 0;//initial posivity
////            do {
////                System.out.println("====================New Game===================");
////                System.out.printf("Game %d\n",gamecount + 1);
////                intialhands(player,psize);
////                intialhands(dealer,dsize);
////                switch (userInput) {
////                    case 1: //124    --------------------------------------------------------------------------------
////                        //124    --------------------------------------------------------------------------------
////                        //124    --------------------------------------------------------------------------------
////                        //124    --------------------------------------------------------------------------------
////                        if (positive <= 3)//if current poaitive less than this number, then set bet to ...
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }
////                        else //if greater than that positive
////                        {
////                            if (lastgame == 1) {
////                                setbet(2);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame == 4) {
////                                setbet(4);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame == 2) {
////                                setbet(4);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else {
////                                System.err.println("error1");
////                                System.exit(0);
////                            }
////                        }
////                        break;
////                    //------------------------------------------------------------------------------------------
////                    case 2:
////                        //1246 old version-------------------------------------------------------------
////                        //1246 old version-----------------------------------------------------------------------
////                        if (positive <= 3)//if current poaitive less than this number, then set bet to ...
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }
////                        else //if greater than that positive
////                        {
////                            if (lastgame == 1) {
////                                setbet(2);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame == 4||lastgame==6) {
////                                setbet(6);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame == 2) {
////                                //cout<<"6666666";
////                                setbet(4);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else {
////                                System.err.println("error1");
////                                System.exit(0);
////                            }
////                        }
////                        // dont change anything below
////                        break;
////                    case 3:
////                        /////138
////                        if (positive <= 3)//if current poaitive less than this number, then set bet to ...
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }
////                        else //if greater than that positive
////                        {
////                            if (lastgame == 1) {
////                                setbet(3);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame == 8) {
////                                setbet(8);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame == 3) {
////                                //cout<<"6666666";
////                                setbet(8);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else {
////                                System.err.println("error1 in case 3");
////                                System.exit(0);
////                            }
////                        }break;
////                    case 4: //124    --------------------------------------------------------------------------------
////                        //124    --------------------------------------------------------------------------------
////                        //124    --------------------------------------------------------------------------------
////                        //124    --------------------------------------------------------------------------------
////                        if(positive>=3) //if greater than that positive
////                        {
////                            if (positive==3&&cardcount<=22)
////                            {
////                                setbet(1);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            }
////                            else {
////                                if (lastgame == 1) {
////                                    setbet(2);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 4) {
////                                    setbet(4);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 2) {
////                                    setbet(4);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else {
////                                    System.err.println("error1");
////                                    System.exit(0);
////                                }
////                            }
////                        }else//positive <3
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }
////                        break;
////                    //------------------------------------------------------------------------------------------
////                    case 5:
////                        if(positive>=3) //if greater than that positive
////                        {
////                            if (positive==3&&cardcount<=22)
////                            {
////                                setbet(1);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            }
////                            else {
////                                if (lastgame == 1) {
////                                    setbet(2);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 4||lastgame == 6) {
////                                    setbet(6);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 2) {
////                                    setbet(4);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else {
////                                    System.err.println("error1");
////                                    System.exit(0);
////                                }
////                            }
////                        }else//positive <3
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }
////                        break;
////                    case 6:
////                        /////138
////                        if(positive>=3) //if greater than that positive
////                        {
////                            if (positive==3&&cardcount<=22)
////                            {
////                                setbet(1);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            }
////                            else {
////                                if (lastgame == 1) {
////                                    setbet(3);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 8) {
////                                    setbet(8);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 3) {
////                                    setbet(8);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else {
////                                    System.err.println("error1 in case 6");
////                                    System.exit(0);
////                                }
////                            }
////                        }else//positive <3
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////
////                        }break;
////                    case 7:
////                        /////6 pack
////                        Double p = Double.valueOf(positive);
////                        Double cardleft= Double.valueOf(totalcard-cardcount+1);
////                        double packleft = cardleft/52;
////                        System.out.printf("Positive: %d, Deck: %.2f, Positive/Deck= %.2f\n", positive,packleft,p/packleft);
////                        if(positive/packleft>1.5){
////                            setbet(20);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }else{
////                            setbet(1);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        }
////                        /*
////                        if(positive>=3) //if greater than that positive
////                        {
////                            if (positive==3&&cardcount<=22)
////                            {
////                                setbet(1);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            }
////                            else {
////                                if (lastgame == 1) {
////                                    setbet(3);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 8) {
////                                    setbet(8);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else if (lastgame == 3) {
////                                    setbet(8);
////                                    System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                    System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                } else {
////                                    System.err.println("error1 in case 6");
////                                    System.exit(0);
////                                }
////                            }
////                        }else//positive <3
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////*/
////                        break;
////                    case 8: //1246
////                        if (back) {//bet(6) back= last game over bet
////                            if (positive > 3) {
////                                back = true;
////                                setbet(6);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                System.out.println("Last game auto bet6. Next game will also be bet of $6");
////                            } else {//less than 4 positive
////                                back = false;
////                                setbet(6);System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);System.out.println("Since last game bet was $6");
////                            }
////                        } else if (positive <= 3)//if current poaitive less than this number, then set bet to ...
////                        {
////                            setbet(1);
////                            System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                            System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                        } else //if greater than that positive
////                        {
////                            if (lastgame == 1) {
////                                setbet(2);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else if (lastgame >= 4) {
////                                back = true;
////                                setbet(6);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                                System.out.println("Next game will also be bet of $6");
////                            } else if (lastgame >= 2) {
////                                //cout<<"6666666";
////                                setbet(4);
////                                System.out.printf("Current positivity: %d.\tLast game bet was: %d\n", positive, lastgame);
////                                System.out.printf("$$$$$$set bet to $ %.1f.\n", bet[0]);
////                            } else {
////                                System.out.println("error1");
////                                System.exit(0);
////                            }
////                        }
////                        break;
////                    default:
////                        System.err.println("User input error");
////                        System.exit(0);
////                }
////
////
////                System.out.println("Card left: "+(totalcard-cardcount+1));//+1 because cardcount was int = 1
////                lastgame = (int)bet[0];
////                System.out.print("Please enter player first hand: ");
////                player[handscount*10 + 0] = intdis();//disturbiting cards
////                System.out.print("Please enter player second hand: ");
////                player[handscount*10 + 1] = intdis();
////                coutcard(player, "Player",handscount);//cout player hand
////                System.out.print("Please enter dealer hand: ");
////                dealer[0] = intdis();//disturbiting cards
////                //dealer[1] = intdis();
////                System.out.printf("Dealer has %s\n", display(dealer[0]));
////                coutcard(dealer, "Dealer",0);
////                checkdouble = 0;//initialize double flag//blackjack(player, "Player", handscount);//check if player has blackjack
////                int temp = value(player[handscount * 10 + 0]) + value(player[handscount * 10 + 1]);//sum of player hands
////                //coutcard(player, "Player",handscount);//cout player hand
////
////                boolean dealerBack = blackjack(dealer, "Dealer", 0);
////                if (dealerBack && blackjack(player, "Player", handscount))
////                {
////
////                    //cout << "PUSH!!!!!!\n";
////                    System.out.println("PUSH!!!");
////                }
////                else if (dealerBack && !blackjack(player, "Player", handscount))//dealer has bj but player dont
////                {
////
////                    //cout << "SORRY!!\n";
////                    System.out.println("SORRY!!");
////                }
////                else if (blackjack(player, "Player", handscount) && !dealerBack)//player has blackjack
////                {
////                    //gg = gamecount + 1;
////                    //cout << "Dealer no blackjack\n";
////                    System.out.println("Dealer no blackjack");
////                    bet[handscount] = bet[handscount] * 1.5;
////                    System.out.printf("Player gets $ %.1f \n", bet[handscount]);
////                }
////                else if (!dealerBack&&!blackjack(player, "Player", handscount))//if dealer no blackjack and player no blackjack
////                {
////                    //cout << "-----------------Call section-----------------\n";
////                    System.out.println("-----------------Call section-----------------");
////                    if (player[handscount * 10 + 0] == player[handscount * 10 + 1] && player[handscount * 10 + 0] < 10)//pairs except 10
////                    {
////                        //cout << "!!!!!!!!!!!!!!!!!!";
////                        play(splitaction(player[handscount * 10 + 0]));//go to splite with that card
////                    }
////                    else if (checkace(player, handscount)) //if player has an ace
////                    {
////                        play(aceaction(temp - 1));
////                    }
////                    else
////                    {
////                        play(paction(temp));//just keep playing
////                    }
////                    dealerflag = 1;//make sure only display dealer's turns once
////                    System.out.print("Please enter dealer hidden hand: ");
////                    dealer[1] = intdis();
////                    dealeraction();//dealeraction
////                }
////
////                result();
////                System.out.printf("Player won: $ %.1f\tDealer won: $ %.1f\n",lastp,lastd );
////                System.out.printf("Player win: $ %.1f\tDealer win: $ %.1f\n",playercount,dealercount );
////                lastp=playercount;
////                lastd=dealercount;
////                System.out.printf("Player net winning: $%.1f\n", playercount - dealercount);
////                System.out.printf("Positive: %d\n", positive);
////
////                if (playercount - dealercount>maxmoney) //if current net win > peak
////                {
////                    maxmoney = (int)playercount - (int)dealercount; //set new peak
////                }
////                else
////                {
////                    if (maxmoney-(playercount - dealercount)>gap)
////                    {
////                        gap=(int)maxmoney-((int)playercount - (int)dealercount);
////                    }
////                }
////                gamecount++;
////                // file.record((int)playercount - (int)dealercount);
////                // file.recordString("\n");
////            } while (cardcount < totalcard * percent);//how much of the card
////            //cout << "gamecount: " << gamecount << "    This set Used card count: " << cardcount << endl;
////            System.out.printf("Gamecount: %d\tThis set used card count: %d",gamecount,cardcount);
////
////        }
////        System.out.println();
////        System.out.println("===============================================================================");
////        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Player win game", playerwin,"Playerwin rate",playerwin / gamecount);
////        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Dealer win game", dealerwin,"Dealerwin rate",dealerwin / gamecount);
////        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "TIE game", tiegame,"Tie rate",tiegame / gamecount);
////        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Double win game", doublerate,"Double win rate",doublerate / gamecount);
////        System.out.format("%-16s:%7.0f    %-10s:%5.2f\n", "Split win game", split,"Split win rate",split / gamecount);
////        System.out.format("%-16s: $%.1f    %s: $%.1f\n", "Player wins", playercount,"Dealer wins",dealercount);
////        System.out.format("%-16s: $%.0f\n","Player net winning", playercount-dealercount);
////        System.out.format("%-16s: $%d    %-10s:$%d\n", "Player max win", maxmoney,"Player max lose",gap);
////        System.out.printf("play15: %d  win15: %d    loss15: %d      tie15:%d    check15:%d\n",p15,w15,l15,t15,check15);
////        int i=pan-1;
////        while(i>=0)
////        {
////            System.out.printf("%d ", save[i]);
////            i--;
////        }
////        System.out.printf("\nAA split game: %d\n", gg+1);
////        //file.close();
////
////    }
////}
////    public static void start()
////    {
////        checkdouble = 0;//initialize double flag
////        //blackjack(player, "Player", handscount);//check if player has blackjack
////        int temp = value(player[handscount*10 + 0]) + value(player[handscount*10 + 1]);//sum of player hands
////        //coutcard(player, "Player",handscount);//cout player hand
////        if (blackjack(player, "Player", handscount) && !blackjack(dealer, "Dealer",0))
////        {
////            System.out.println("Dealer no blackjack");
////            //bet[handscount] = bet[handscount] * 1.5;
////            System.out.printf("Player gets: $ %.1f\n", bet[handscount]);
////        }
////        else if (blackjack(dealer, "Dealer",0) && !blackjack(player, "Player", handscount))
////        {
////            System.out.println("SORRY!!");
////        }
////        else if (blackjack(dealer, "Dealer", 0) && blackjack(player, "Player", handscount))
////        {
////            System.out.println("PUSH!!!");
////        }
////        else if (!blackjack(dealer, "Dealer",0))//if dealer no blackjack
////        {
////            if (player[handscount*10 + 0] == player[handscount * 10 + 1] && player[handscount * 10 + 0] < 10)//pairs except 10
////            {
////                System.out.println("!!!!!!!!!!!!!!");
////                play(splitaction(player[handscount * 10 + 0]));//go to splite with that card
////            }
////            else if (checkace(player, handscount)) //if player has an ace
////            {
////                play(aceaction(temp - 1));
////            }
////            else
////            {
////                play(paction(temp));//just keep playing
////            }
////
////        }
////    }
//
////
////    public static int paction(int choice)//without Ace
////    {
////        //1 = hit;
////        //2 = double
////        //3 = stand
////        //4 = split
////        switch (choice)
////        {
////            case 5:
////            case 6:
////            case 7:
////            case 8:
////            {
////                //cout << "***player called hit" << endl;
////                return 1;
////            }
////            //break;
////            case 9:
////                if (value(dealer[0]) <= 6 && value(dealer[0]) > 2)
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////
////                //  break;
////            case 10:
////                if (value(dealer[0]) <= 9 && value(dealer[0]) > 1)
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////
////
////                //break;
////            case 11:
////                if (blackjack(player, "Player", handscount))
////                    return 3;
////                else
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////                }
////
////                // break;
////            case 12:
////                if (value(dealer[0]) >= 4 && value(dealer[0]) <= 6)
////                {
////                    //cout << "***player called stand" << endl;
////                    return 3;
////
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////
////                // break;
////            case 13:
////            case 14:
////                if (value(dealer[0]) <= 6 && value(dealer[0]) > 1)
////                {
////                    //cout << "***player called stand" << endl;
////                    return 3;
////
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////            case 15:
////            case 16:
////                if (value(dealer[0]) <= 6 && value(dealer[0]) > 1)
////                {
////                    //cout << "***player called stand" << endl;
////                    return 3;
////
////                }
////                else if(positive>=4&&set15==1){
////                    System.out.printf("Positive >= 4, player should call stand!!!!!!!!!!!");
////                    if(!fifteen[handscount]){
////                        fifteen[handscount]=true;
////                        p15++;
////                    }
////                    // save[pan++] = gamecount + 1;//save split game
////                    return 3;
////                }
////                else
////                {
////                    //save[pan++] = gamecount + 1;//save split game
////                    if(!fifteen[handscount]){
////                        fifteen[handscount]=true;
////                        p15++;
////                    }
////                    System.out.println("Inced!!!!!!!!!!!!!");
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////            case 17:
////            case 18:
////            case 19:
////            case 20:
////            case 21:
////            {
////                //cout << "***player called stand" << endl;
////                return 3;
////            }
////
////
////            //  break;
////            default:
////
////                System.err.printf("error2 got input of case %d", choice);
////                System. exit(0);
////                return 0;
////            //  break;
////        }
////    }
////
////    public static int aceaction(int hand)
////    {
////        switch (hand)
////        {
////            case 2:
////            case 3:
////                if (value(dealer[0]) <= 4 || value(dealer[0]) >= 7)//1-4, 7-10
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                else
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////                }
////                //   break;
////            case 4:
////            case 5:
////                if (value(dealer[0]) <= 3 || value(dealer[0]) >= 7)//1-3,7-10
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                else
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////                }
////                // break;
////            case 6:
////                if (value(dealer[0]) >= 3 && value(dealer[0]) <= 6)//3-6
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                // break;
////            case 7:
////                if (value(dealer[0]) == 9 || value(dealer[0]) == 10 || value(dealer[0]) == 1)//9, 10 , 1
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                else if (value(dealer[0]) == 2 || value(dealer[0]) == 7 || value(dealer[0]) == 8)//2, 7 , 8
////                {
////                    //cout << "***player called stand" << endl;
////                    return 3;
////                }
////                else
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////                }
////                // break;
////            case 8:
////            case 9:
////            case 10: //cout << "***player called stand" << endl;
////                return 3;
////            //break;
////            default:
////                //cout << "error3 got input of case "<< hand;
////                System.err.printf("error3 got input of case %d", hand);
////                System. exit(0);
////                return 0;
////            // break;
////        }
////    }
////
////    public static int splitaction(int hand)
////    {
////        switch (hand)
////        {
////            case 1:
////                //cout << "***player called split" << endl;
////                return 5;
////            // break;
////            case 2:
////            case 3:
////                if (value(dealer[0]) >= 4 && value(dealer[0]) <= 7)
////                {
////                    //cout << "***player called split" << endl;
////                    return 4;
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                // break;
////            case 4:
////                if (value(dealer[0]) >= 5 && value(dealer[0]) <= 6)
////                {
////                    //cout << "***player called split" << endl;
////                    return 4;
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////            case 5:
////                if (value(dealer[0]) == 1 || value(dealer[0]) == 10)
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                else
////                {
////                    //cout << "***player called double" << endl;
////                    return 2;
////                }
////                // break;
////            case 6:
////                if (value(dealer[0]) >= 2 && value(dealer[0]) <= 6)
////                {
////                    //cout << "***player called split" << endl;
////                    return 4;
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                // break;
////            case 7:
////                if (value(dealer[0]) >= 2 && value(dealer[0]) <= 7)
////                {
////                    //cout << "***player called split" << endl;
////                    return 4;
////                }
////                else
////                {
////                    //cout << "***player called hit" << endl;
////                    return 1;
////                }
////                // break;
////            case 8:
////                //cout << "***player called split" << endl;
////                return 4;
////            //break;
////
////            case 9:
////                if (value(dealer[0]) == 7 || value(dealer[0]) == 10 || value(dealer[0]) == 1)
////                {
////                    //    cout << "***player called stand" << endl;
////                    return 3;
////                }
////                else
////                {
////                    //cout << "***player called split" << endl;
////                    return 4;
////                }
////                //  break;
////            default:
////                //cout << "error4 got input of case "<< hand;
////                System.err.printf("error4 got input of case %d", hand);
////                System. exit(0);
////                return 0;
////            // break;
////        }
////    }
////
////    public static void play(int action)//1hit 2double 3stand 4split 5splithit
////    {
////
////        switch (action)
////        {
////            case 1: //hit
////                //cout  << handscount + 1 << "player called hit" << endl;
////                System.out.printf("%dplayer called hit\n", handscount+1);
////                System.out.print("Enter player hit card: ");
////                player[++playerhandcount] = intdis();//distribute from play[2]
////                psum = sum(player, handscount);//player sum
////                coutcard(player, "Player", handscount);//display card;
////
////                if (sum(player, handscount) < 12 && checkace(player, handscount))//check whether stand with ace
////                {
////                    if (aceaction(sum(player, handscount) - 1) == 1 || aceaction(sum(player, handscount) - 1) == 1)//if supposed hit or double//both changed to 1 hit
////                    {
////                        play(1);//play(hit)
////                    }
////                    else
////                    {
////                        play(3);//play(stand)
////
////                    }
////                }
////                else if (sum(player, handscount) < 22)//without ace but <22
////                {
////                    if (paction(sum(player, handscount)) == 1 || paction(sum(player, handscount)) == 2)//if supposed hit or double
////                    {
////                        play(1);//play(hit)
////                    }
////                    else
////                    {
////                        play(3);//play(stand)
////
////                    }
////                }
////                else
////                    pbust(player, handscount);//player busts
////                break;
////            case 2: //double
////                doublerate++;
////                checkdouble = 1;//double flag
////                bet[handscount] = bet[handscount] * 2;//double the bet
////                // cout << handscount + 1 << "player called double" << endl;
////                System.out.printf("%dplayer called double\n", handscount+1);
////                System.out.printf("$$bet of $ %.1f \n", bet[handscount]);
////                System.out.print("Enter player double card: ");
////                player[handscount * 10 + 2] = intdis();
////                acevalue(player, handscount);//determine ace value
////                coutcard(player, "Player", handscount);
////                pbust(player, handscount);//check player busts
////                break;
////            case 3://stand
////                acevalue(player, handscount);
////                //cout << handscount + 1 << "player called stand\t\t\tFinal: " <<handscount +1<< "Player sum: " << sum(player, handscount) << endl;
////                System.out.printf("%dplayer called stand\n", handscount+1);
////                //coutcard(player, "Player",handscount);
////
////                break;
////            case 4: //split
////
//////                System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
////                System.out.printf("%dplayer called split\n", handscount+1);
////                int i = 0;
////                if(pan>80){
////                    pan=0;
////                }
////
////
////                split++;
////                while (player[i * 10] != 0)
////                {
////                    i++;
////                    //find the next empty stack
////                }
////                if(i==2){
////                    // gg=gamecount;
////                }
////                System.out.print("assign second card to first hand: ");
////                player[handscount * 10 + 1] = intdis();//assign second card to first hand
////                coutcard(player, "Player", handscount);//display 1player
////                //handscount++;//next hand
////                if (player[0]==11){///split the card the second hand
////                    player[i * 10] = 1;//however, if play[0] has ace but value of 11 could lead error
////                }
////                //so just assign it to one
////                else
////                {
////                    player[i * 10] =player[0];//otherwise assign second player the first player[o]
////                }
////                System.out.print("assign second card to second hand: ");
////                player[i * 10 + 1] = intdis();//assign second card to second hand
////                coutcard(player, "Player", i);//display second hand
////                //handscount--;//next hand
////                System.out.printf("----------------%dPlayer turn-----------------", handscount+1);
////                start();//finish first hand
////                handscount = i;//next hand
////                System.out.printf("----------------%dPlayer turn-----------------", handscount+1);
////                coutcard(player, "Player", handscount);//display second hand
////                //cout << "count" << handscount << endl;
////                playerhandcount = 1 + i * 10;//make sure disturebute to next stack
////                //cout << "playerhandcount" << playerhandcount<<endl;
////
////                start();//finish second hand
////                //handscount++;
////                break;
////
////            case 5://ace split
////                //save[pan++]=gamecount;//save split gamecount
////                split++;
////                gg=gamecount;
////                player[1]=intdis();//distribute first hand second card
////                player[10]=player[0];//distribute second hand first card
////                //coutcard(player, "player",handscount);//display first hand
////                acevalue(player, handscount);//determine ace value
////                coutcard(player, "Player", handscount);
////                pbust(player, handscount);//check player busts
////                handscount++;
////
////                player[11]=intdis();
////                //coutcard(player, "player",handscount);
////                acevalue(player, handscount);//determine ace value
////                coutcard(player, "Player", handscount);
////                pbust(player, handscount);//check player busts
////                break;
////
////            default:
////                // cout << "error5 got input of case "<<action;
////                System.err.printf("error5 got input of case %d",action);
////                System. exit(0);
////                break;
////        }
////    }
////    public static void dealeraction()
////    {
////        int checkbust = 0;//to see if dealer needs action
////        int trystack = 0;//try from array[0]
////        while (player[trystack*10] != 0) {
////            if (sum(player, trystack) < 22) {//if player sum < 21 then dealer needs action
////                checkbust = 1;
////            }trystack ++;//inc
////        }
////
////        if (checkbust == 1)//dealer needs action
////        {
////            if (dealerflag == 1) {
////                System.out.println("----------------Dealer turn-------------------");
////                coutcard(dealer, "Dealer", 0);
////                dealerflag = 0;//set dealer flag to 0 so it wouldnt display again
////            }
////            playerhandcount = 1;//initial playerhand
////            if (sum(dealer, 0) > 21)
////            {
////                dbust(dealer);//cehck dealer busts
////            }
////            else if (!checkace(dealer, 0) && sum(dealer, 0) > 16)//dealer sum >17
////            {
////                System.out.printf("Dealer stand \t\t\tdealer sum: %d\n", sum(dealer,0));
////
////
////            }
////            else if (checkace(dealer, 0) && sum(dealer, 0) > 7 && sum(dealer, 0) < 12)//dealer has ace and dealer sum-1 is 7-10
////            {
////                acevalue(dealer, 0);
////                System.out.printf("Dealer stand \t\t\tdealer sum: %d\n", sum(dealer,0));
////
////
////            }
////            else if (checkace(dealer, 0) && (sum(dealer, 0) - 1) == 6) //soft 17, ace and 6
////            {
////                System.out.println("Dealer soft 17!!!!!!!!!!!!!!!!!!!!!");
////                System.out.print("Enter Dealer: ");
////                dealer[dealerhandcount++] = intdis();
////                acevalue(dealer, 0);
////                coutcard(dealer, "Dealer", 0);
////                dbust(dealer);//check dealer busts
////                if (sum(dealer, 0) < 17)//if still <17
////                {
////                    System.out.print("Enter Dealer: ");
////                    dealer[dealerhandcount] = intdis();//distribute third card
////                    dealerhandcount++;
////                    coutcard(dealer, "Dealer", 0);
////                    dealeraction();//do dealer action again
////                }
////            }
////            else if (sum(dealer, 0) < 17)//if still <17
////            {
////                System.out.print("Enter Dealer: ");
////                dealer[dealerhandcount] = intdis();//distribute third card
////                dealerhandcount++;
////                coutcard(dealer, "Dealer", 0);
////                dealeraction();//do dealer action again
////            }
////        }
////
////
////
////
////
////
////    }
//
//
//
//
////    public static void count20(int i){
////        if(bet[i]>=20){
////            b20++;
////        }
////    }
////    public static void win20(int i){
////        if(bet[i]>=20){
////            w20++;
////        }
////    }
////    public static void result()
////    {
////        int itrystack = 0;//try from array[0]
////        while (player[itrystack*10] != 0) {
////            System.out.print("[FINAL]");
////            coutcard(player, "Player", itrystack);
////            itrystack++;
////            count20(itrystack);
////
////        }
////        System.out.print("[FINAL]");
////        coutcard(dealer, "Dealer", 0);
////        int trystack = 0;//try from array[0]
////        System.out.println();
////        while (player[trystack*10] != 0) {
////            if(fifteen[trystack]){
////                check15++;
////            }
////            if (sum(player, trystack) < 22 && sum(dealer, 0) < 22) {
////                if (blackjack(player, "Player", trystack))
////                {
////                    incFifteen(trystack,1);
////                    System.out.printf("======%dPlayer win!!!!!\n",trystack  + 1 );
////                    playerwin++;
////                    win20(trystack);
////                    System.out.printf("%dPlayer win: $ %.1f\n",trystack  + 1,bet[trystack]);
////                    playercount += bet[trystack];//player get the bet
////                }
////                else if (sum(player, trystack) > sum(dealer, 0))
////                {
////                    incFifteen(trystack,1);
////                    System.out.printf("======%dPlayer win!!!!!\n",trystack  + 1 );
////                    playerwin++;
////                    System.out.printf("%dPlayer win: $ %.1f\n",trystack  + 1,bet[trystack]);
////                    playercount += bet[trystack];//player get the bet
////                    win20(trystack);
////                }
////                else if (sum(player, trystack) < sum(dealer, 0))
////                {
////                    incFifteen(trystack,2);
////                    System.out.printf("======%dDealer win!!!!!\n",trystack  + 1 );
////                    dealerwin++;
////                    System.out.printf("%dPlayer lose: $ %.1f\n",trystack  + 1,bet[trystack]);
////                    dealercount += bet[trystack];//dealer gets the bet
////                }
////                else
////                {
////                    incFifteen(trystack,3);
////                    System.out.printf("======%dTIE game\n",trystack  + 1 );
////                    tiegame++;
////                    b20--;
////                }
////
////            }
////            else //one of them busted
////            //no dealer or player++ because counted at pbust()
////            //display only money counted at pbust or dbust()
////            {
////                if (sum(player, trystack) >21)//if player bust
////                {
////                    incFifteen(trystack,2);
////                    System.out.printf("======%dPlayer busted!!!!!\n",trystack  + 1 );
////                    System.out.printf("%dPlayer lose: $ %.1f\n",trystack  + 1,bet[trystack]);
////                    dealercount += bet[trystack];//dealer gets the bet
////                }
////                else if (sum(dealer, 0)>21)//dealer busted
////                {
////                    incFifteen(trystack,1);
////                    System.out.printf("======%dDealer busted!!!!!\n",trystack  + 1 );
////                    System.out.printf("%dPlayer get: $ %.1f\n",trystack  + 1,bet[trystack]);
////                    playercount += bet[trystack];//player get the bet
////                    win20(trystack);
////                }
////                else{//catch error
////                    System.err.println("error7");
////                    System. exit(0);
////                }
////            }
////            trystack ++;//inc
////        }
////        System.out.println("----------------------------------------------");
////    }
////
////
//
////
////    }
////
//
////
//
////
//
////
////    public static void setbet(int mult)
////    {
////        for (int i = 0; i < 10; i++)
////        {
////            bet[i] = basebet * mult;
////        }
////    }
////
