package com.edwin;

public class Card {
    private int id;
    Card(int id){
        assert (id >0 && id< 15): "Card(): invalid id";
        this.id=id;
    }
    Card(Card copy){
        this.id = copy.id;
    }
    public String toString(){
        switch (this.id)
        {
            case 1: return "A";
            //break;
            case 2: return "2";
            //break;
            case 3: return "3";
            // break;
            case 4: return "4";
            // break;
            case 5: return "5";
            // break;
            case 6: return "6";
            //break;
            case 7: return "7";
            // break;
            case 8: return "8";
            // break;
            case 9: return "9";
            // break;
            case 10: return "10";
            // break;
            case 11: return"A";
            // break;
            case 12: return "J";
            // break;
            case 13: return "Q";
            //  break;
            case 14: return "K";
            //    break;


            default:
                System.err.printf("error6 got input of case%d", this.id);
                System. exit(0);
                return "error";
            // break;


        }
    }
}
