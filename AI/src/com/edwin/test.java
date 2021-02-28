//package com.edwin;
//
//public class test {
//    static Player p = new Player("Player",1,100);
//    static Player d = new Player("Dealer",1,100);
//    static Simulator set = new Simulator();
//    public static void main(String[] args){
//        p.addCard(13);
//        p.addCard(7);
//        p.addCard(7);
//        System.out.println(p);
////        dealer turn
//        for (int i = 0; i < p.size(); i++) {
//            if (!p.bust(i)) {
//                System.out.println("\"-----------------Dealer Turn----------------\"");
//                dealeraction();//dealeraction
//                break;
//            }
//        }
//        p.result(d.handSum());
//        System.out.println(p.asset);
//    }
//    public static void dealeraction() {
//        if (d.handSum() >= 17){//dealer sum >17
//            System.out.printf("Dealer stand \t\t\tdealer sum: %d\n", d.handSum());
//        }else if ((d.hasAce() && d.withoutAce() == 6) || d.handSum() < 17) { //soft 17, ace and 6
////            System.out.println("Dealer soft 17!!!!!!!!!!!!!!!!!!!!!");
//            System.out.print("Enter Dealer: ");
//            d.addCard(set.intdis());
//            System.out.println(d);
//            dealeraction();
//        }
//    }
//}
