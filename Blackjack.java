// import java.util.*;
// import java.math.*;
// interface Cards{
//     HashMap <Integer,Integer> ar = new HashMap<Integer,Integer>()
//     { {put(2,4);
//     put(3,4);
//     put(4,4);
//     put(5,4);
//     put(6,4);
//     put(7,4);
//     put(8,4);
//     put(9,4);
//     put(10,4);
//     put(11,16);
//     }};

// }
// class Val{
//     Integer player = 0;
//     Boolean playerTurn = true;
//     Integer dealer =  0;
//     Random generator = new Random();

//     Integer getRand(HashMap<Integer, Integer> arr){
//                 var randomValue = arr.keySet().toArray()[generator.nextInt(arr.size())].toString();
//                 Integer r = Integer.valueOf(randomValue);
//         return r;
//     }
// }

// public class Blackjack implements Cards{

//     public static void main(String[] args) {
//         Cards c = new Blackjack();
//         Val obj = new Val();
//         Scanner sc = new Scanner(System.in);
//         Integer rand1 = 0,rand2 = 0,randomval = 0;

//         while (true){
            
//             if (obj.playerTurn){
//                 //player
//                 rand1 = obj.getRand(c.ar);
//                 if (Cards.ar.get(rand1)<=0){
//                     continue;
//                 }
                
//                 rand2 = obj.getRand(c.ar);
//                 if (Cards.ar.get(rand2)<=0){
//                     continue;
//                 }
//                 c.ar.put(rand1,Cards.ar.get(rand1)-1);
//                 c.ar.put(rand2,Cards.ar.get(rand2)-1);

//                 System.out.println("Your cards are: "+ rand1+ " "+rand2);
//                 obj.player = obj.player + rand1 + rand2;
//                 System.out.println("Your total is: "+ obj.player);

//                 //dealer
//                 rand1 = obj.getRand(c.ar);
//                 if (Cards.ar.get(rand1)<=0){
//                     continue;
//                 }
//                 rand2 = obj.getRand(c.ar);
//                 if (Cards.ar.get(rand2)<=0){
//                     continue;
//                 }
//                 c.ar.put(rand1,Cards.ar.get(rand1)-1);
//                 c.ar.put(rand2,Cards.ar.get(rand2)-1);
                
//                 System.out.println("Dealers cards are: "+ rand1+ " and 1 hidden card");
//                 obj.dealer = obj.dealer + rand1 + rand2;

//                 if (obj.player>21){
//                     System.out.println("You Lost");
//                     break;
//                 }

//                 while (obj.playerTurn){
//                     System.out.println("Do you want to 'hit' or 'stay'?");
//                     String hitstay = sc.nextLine();
//                     if (hitstay.equals("hit")){
//                         randomval = obj.getRand(c.ar);
//                         if (Cards.ar.get(randomval)<=0){
//                             System.out.println("Generating new random number please hold");
//                             continue;
//                         }
//                         obj.player = obj.player + randomval;
//                         c.ar.put(randomval,Cards.ar.get(randomval)-1);
//                         System.out.println("Your new total is "+ obj.player);
//                     }
//                     else if (hitstay.equals("stay")){
//                         obj.playerTurn = false;
//                     }
//                     else{
//                         System.out.println("Enter valid value. Game is now restarting player.");
//                         break;
//                     }
//                     if (obj.player>21){
//                         System.out.println("You Lost");
//                         break;
//                     }
//                 }
//             }
//             else{
//                 System.out.println("Dealer's hidden card was " + rand2);
//                 System.out.println("Dealer's Total is: " + obj.dealer);
//                 if (obj.dealer>16){
//                     System.out.println("You won!");
//                     break;
//                 }
//                 System.out.println("Do you want to 'hit' or 'stay'?");
//                 String hitstay = sc.nextLine();
//                 if (hitstay.equals("hit")){
//                     randomval = obj.getRand(c.ar);
//                     obj.dealer = obj.dealer + randomval;
//                     if (Cards.ar.get(randomval)<=0){
//                         System.out.println("Generating new random number please hold");
//                         continue;
//                     }
//                     c.ar.put(randomval,Cards.ar.get(randomval)-1);
//                     System.out.println("Dealer's new total is "+ obj.dealer);
//                 }
//                 else if (hitstay.equals("stay")){
//                     obj.playerTurn = true;
//                 }
//                 else{
//                     System.out.println("Enter valid value. Game is now restarting dealer.");
//                     break;
//                 }
//                 if (obj.dealer>16){
//                     System.out.println("You Won!");
//                     break;
//                 }
//             }

//         }
//     }
// }



import java.util.*;
import java.math.*;
interface Cards{
    HashMap <Integer,Integer> ar = new HashMap<Integer,Integer>()
    { {put(2,4);
    put(3,4);
    put(4,4);
    put(5,4);
    put(6,4);
    put(7,4);
    put(8,4);
    put(9,4);
    put(10,4);
    put(11,16);
    }};

}
class Val{
    Integer player = 0;
    Boolean playerTurn = true;
    Integer dealer =  0;
    Random generator = new Random();

    Integer getRand(HashMap<Integer, Integer> arr){
                var randomValue = arr.keySet().toArray()[generator.nextInt(arr.size())].toString();
                Integer r = Integer.valueOf(randomValue);
        return r;
    }
    Integer dealerRand(){
        return generator.nextInt(2);
    }
}

public class Blackjack implements Cards{

    public static void main(String[] args) {
        Cards c = new Blackjack();
        Val obj = new Val();
        Scanner sc = new Scanner(System.in);
        Integer rand1 = 0,rand2 = 0,randomval = 0;

        while (true){
            
            if (obj.playerTurn){
                //player
                rand1 = obj.getRand(c.ar);
                if (Cards.ar.get(rand1)<=0){
                    continue;
                }
                
                rand2 = obj.getRand(c.ar);
                if (Cards.ar.get(rand2)<=0){
                    continue;
                }
                c.ar.put(rand1,Cards.ar.get(rand1)-1);
                c.ar.put(rand2,Cards.ar.get(rand2)-1);

                System.out.println("Your cards are: "+ rand1+ " "+rand2);
                obj.player = obj.player + rand1 + rand2;
                System.out.println("Your total is: "+ obj.player);

                //dealer
                rand1 = obj.getRand(c.ar);
                if (Cards.ar.get(rand1)<=0){
                    continue;
                }
                rand2 = obj.getRand(c.ar);
                if (Cards.ar.get(rand2)<=0){
                    continue;
                }
                c.ar.put(rand1,Cards.ar.get(rand1)-1);
                c.ar.put(rand2,Cards.ar.get(rand2)-1);
                
                System.out.println("Dealers cards are: "+ rand1+ " and 1 hidden card");
                obj.dealer = obj.dealer + rand1 + rand2;

                if (obj.player>21){
                    System.out.println("You Lost");
                    break;
                }

                while (obj.playerTurn){
                    System.out.println("Do you want to 'hit' or 'stay'?");
                    String hitstay = sc.nextLine();
                    if (hitstay.equals("hit")){
                        randomval = obj.getRand(c.ar);
                        if (Cards.ar.get(randomval)<=0){
                            System.out.println("Generating new random number please hold");
                            continue;
                        }
                        obj.player = obj.player + randomval;
                        c.ar.put(randomval,Cards.ar.get(randomval)-1);
                        System.out.println("Your new total is "+ obj.player);
                    }
                    else if (hitstay.equals("stay")){
                        obj.playerTurn = false;
                    }
                    else{
                        System.out.println("Enter valid value. Game is now restarting player.");
                        break;
                    }
                    if (obj.player>21){
                        System.out.println("You Lost");
                        break;
                    }
                }
            }
            else{
                System.out.println("Dealer's hidden card was " + rand2);
                System.out.println("Dealer's Total is: " + obj.dealer);
                if (obj.dealer>16){
                    System.out.println("You won!");
                    break;
                }
                System.out.println("Do you want to 'hit' or 'stay'?");
                Integer hitstay = obj.dealerRand();
                if (hitstay==0){
                    System.out.println("Dealer chooses to hit");
                    randomval = obj.getRand(c.ar);
                    obj.dealer = obj.dealer + randomval;
                    if (Cards.ar.get(randomval)<=0){
                        System.out.println("Generating new random number please hold");
                        continue;
                    }
                    c.ar.put(randomval,Cards.ar.get(randomval)-1);
                    System.out.println("Dealer's new total is "+ obj.dealer);
                }
                else if (hitstay==1){
                    System.out.println("Dealer chooses to stay");
                    obj.playerTurn = true;
                }
                else{
                    System.out.println("Enter valid value. Game is now restarting dealer.");
                    break;
                }
                if (obj.dealer>16){
                    System.out.println("You Won!");
                    break;
                }
            }

        }
    }
}
