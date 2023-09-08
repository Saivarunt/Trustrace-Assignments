// 2 Player
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
//                 // var randomValue = arr.keySet().toArray()[generator.nextInt(2,arr.size()+2)].toString();
//                 // Integer r = Integer.valueOf(randomValue);
                
//         return generator.nextInt(2,arr.size()+2);
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
//                 else if(obj.dealer>=16){
//                     System.out.println("Dealer chooses to stay");
//                     if(obj.dealer>obj.player){
//                         System.out.println("You won!");
//                     }
//                     else{
//                         System.out.println("You lost");
//                     }
//                     break;
//                 }
//                 else if (hitstay.equals("stay")){
//                     System.out.println("Dealer chooses to stay");
//                     if(obj.dealer>obj.player){
//                         System.out.println("You won!");
//                     }
//                     else{
//                         System.out.println("You lost");
//                     }
//                     break;
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


// Player vs. Bot
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
//                 //var randomValue = arr.keySet().toArray()[generator.nextInt(arr.size())].toString();
//                 //Integer r = Integer.valueOf(randomValue);
//         //return r;
//           return generator.nextInt(2,arr.size()+2);
//     }
//     Integer dealerRand(){
//         return generator.nextInt(2);
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
//                 if (obj.dealer>21){
//                     System.out.println("You won!");
//                     break;
//                 }
//                 Integer hitstay = obj.dealerRand();
//                 if (hitstay==0){
//                     System.out.println("Dealer chooses to hit");
//                     randomval = obj.getRand(c.ar);
//                     obj.dealer = obj.dealer + randomval;
//                     if (Cards.ar.get(randomval)<=0){
//                         System.out.println("Generating new random number please hold");
//                         continue;
//                     }
//                     c.ar.put(randomval,Cards.ar.get(randomval)-1);
//                     System.out.println("Dealer's new total is "+ obj.dealer);
//                 }
//                 else if(obj.dealer>=16){
//                     System.out.println("Dealer chooses to stay");
//                     if(obj.dealer>obj.player){
//                         System.out.println("You won!");
//                     }
//                     else{
//                         System.out.println("You lost");
//                     }
//                     break;
//                 }
//                 else if (hitstay==1){
//                     System.out.println("Dealer chooses to stay");
//                     if(obj.dealer>obj.player){
//                         System.out.println("You won!");
//                     }
//                     else{
//                         System.out.println("You lost");
//                     }
//                     break;
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




// Custom
import java.util.*;
// Interface containing Deck key pair (Value,No of Cards Available)
interface Cards{
    // Hashmap with single deck values inside interface
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

// Class containing Play by Play instances of game
// And random functions to facilitate random pick from deck and random choice of action for dealer
class Val{
    // Maintains Player's overall score based on cards drawn at random
    Integer player = 0;
    // Player-Dealer turn check variable
    Boolean playerTurn = true;
    // Maintains Dealer's overall score based on cards drawn at random
    Integer dealer =  0;
    // Random number generator from Random class
    Random generator = new Random();

    // Gets Hashmap as input and returns random card pick from the deck of cards
    Integer getRand(HashMap<Integer, Integer> arr){
        return generator.nextInt(2,arr.size()+2);
    }
    // Makes choice of action for dealer(0=Hit,1=Stay)
    Integer dealerRand(){
        return generator.nextInt(2);
    }
}

// Main class
public class Blackjack implements Cards{

    public static void main(String[] args) {
        // Interface instance
        Cards c = new Blackjack();

        // Class instance
        Val obj = new Val();
        // Scanner class to get inputs
        Scanner sc = new Scanner(System.in);

        // Variables to store random values picked from card during runtime
        Integer rand1 = 0,rand2 = 0,randomval = 0;

        // Lets user choose number of decks
        System.out.println("Choose number of decks");
        Integer deckCount = sc.nextInt();
        System.out.println();
        
        // Updating interface hashmap based on number of decks 
        for (Integer i=2;i<Cards.ar.size()+2;i++){
            Cards.ar.put(i, Cards.ar.get(i)*deckCount);
        }

        // Lets user choose bust value for the game
        System.out.println("Choose the bust value");
        Integer bustVal = sc.nextInt();
        sc.nextLine();
        System.out.println();

        // Game starts 
        while (true){
            // Intial turn is players 
            if (obj.playerTurn){
                //player

                // Gets first random pick from the deck
                rand1 = obj.getRand(Cards.ar);
                // Checks to see if card picked is still available in the original deck or have we run out of cards
                if (Cards.ar.get(rand1)<=0){
                    continue;
                }
                
                // Gets Second random pick from the deck
                rand2 = obj.getRand(Cards.ar);
                // Checks to see if card picked is still available in the original deck or have we run out of cards
                if (Cards.ar.get(rand2)<=0){
                    continue;
                }
                // Updates main deck by reducing particular card picked
                Cards.ar.put(rand1,Cards.ar.get(rand1)-1);
                Cards.ar.put(rand2,Cards.ar.get(rand2)-1);

                // Updates Player's Value
                System.out.println("Your cards are: "+ rand1+ " "+rand2);
                obj.player = obj.player + rand1 + rand2;
                System.out.println("Your total is: "+ obj.player);
                System.out.println();

                //dealer
                // Gets first random pick from the deck
                rand1 = obj.getRand(Cards.ar);
                // Checks to see if card picked is still available in the original deck or have we run out of cards
                if (Cards.ar.get(rand1)<=0){
                    continue;
                }

                // Gets Second random pick from the deck
                rand2 = obj.getRand(Cards.ar);
                // Checks to see if card picked is still available in the original deck or have we run out of cards
                if (Cards.ar.get(rand2)<=0){
                    continue;
                }
                // Updates main deck by reducing particular card picked
                Cards.ar.put(rand1,Cards.ar.get(rand1)-1);
                Cards.ar.put(rand2,Cards.ar.get(rand2)-1);

                // Updates Dealer's Value
                System.out.println("Dealers cards are: "+ rand1+ " and 1 hidden card");
                obj.dealer = obj.dealer + rand1 + rand2;
                System.out.println();

                // Checks if initial draw is above bust val
                if (obj.player>bustVal){
                    System.out.println("You Lost");
                    break;
                }

                // Runs until player chooses to stay
                while (obj.playerTurn){
                    // Get player choice of action
                    System.out.println("Do you want to 'hit' or 'stay'?");
                    String hitstay = sc.nextLine();
                    System.out.println();

                    if (hitstay.equals("hit")){
                        // Generate random pick from the deck
                        randomval = obj.getRand(Cards.ar);
                        // Checks to see if card picked is still available in the original deck or have we run out of cards
                        if (Cards.ar.get(randomval)<=0){
                            System.out.println("Generating new random number please hold");
                            System.out.println();
                            continue;
                        }
                        // Updates Player's value
                        obj.player = obj.player + randomval;
                        // Updates main deck by reducing particular card picked
                        Cards.ar.put(randomval,Cards.ar.get(randomval)-1);
                        System.out.println("Your new total is "+ obj.player);
                        System.out.println();
                    }
                    else if (hitstay.equals("stay")){
                        // Hands control over to dealer
                        obj.playerTurn = false;
                    }
                    else{
                        // Restarts the game if anything else was entered other than 'hit' or 'stay' during runtime
                        obj.player=0;
                        obj.dealer=0;
                        System.out.println("Enter valid value. Game is now restarting player.");
                        System.out.println();
                        break;
                    }
                    // Checks if current draw is above bust val
                    if (obj.player>bustVal){
                        System.out.println("You Lost");
                        break;
                    }
                }
            }
            // Dealer's play once control switched
            else{
                System.out.println("Dealer's hidden card was " + rand2);
                System.out.println("Dealer's Total is: " + obj.dealer);
                System.out.println();
                // Checks if initial draw is above bust val
                if (obj.dealer>bustVal){
                    System.out.println("You won!");
                    break;
                }

                // Gets random pick for Dealer from Val class
                Integer hitstay = obj.dealerRand();
                // Checks and acts based on action taken (0=>hit,1=>stay)
                
                if (hitstay==0){
                    System.out.println("Dealer chooses to hit");
                    // Generate random pick from the deck
                    randomval = obj.getRand(Cards.ar);
                    // Update Dealer's value
                    obj.dealer = obj.dealer + randomval;

                    // Checks to see if card picked is still available in the original deck or have we run out of cards
                    if (Cards.ar.get(randomval)<=0){
                        System.out.println("Generating new random number please hold");
                        System.out.println();
                        continue;
                    }
                    // Updates main deck by reducing particular card picked
                    Cards.ar.put(randomval,Cards.ar.get(randomval)-1);
                    System.out.println("Dealer's new total is "+ obj.dealer);
                    System.out.println();
                }
                // Stay condition or if Dealer's value is greater than or equal to bustVal-5 will automatically make dealer to pick stay
                else if(obj.dealer>=bustVal-5 || hitstay==1){
                    System.out.println("Dealer chooses to stay");
                    System.out.println();
                    // Determines who won 
                    if(obj.dealer>obj.player){
                        System.out.println("You won!");
                    }
                    else{
                        System.out.println("You lost");
                    }
                    break;
                }
                else{
                    break;
                }
                
                // Checks if current draw is above bust val
                if (obj.dealer>bustVal){
                    System.out.println("You Won!");
                    break;
                }
            }

        }
        sc.close();
    }
}
