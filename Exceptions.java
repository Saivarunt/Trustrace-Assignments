// import java.util.*;
// interface X{
//     interface Y{
//         void printex() throws RuntimeException;
//     }
// }

// class A implements X.Y{
//     public void printex() throws RuntimeException{
//         Scanner sc = new Scanner(System.in);
//         try {
//             System.out.println("Enter a number:");
//             Integer n = sc.nextInt();
//             System.out.println(n);
//         } catch (Exception e) {
//             System.out.println("Exception block");
//             throw new RuntimeException("Enter the right value");
//         }
//         finally{
//             System.out.println("Finally block");
//             sc.close();
//         }
//     }
//     // X.Y obj = new A();
// }

// public class Exceptions {
//     public static void main(String args[]){
//         A ob = new A();
//         ob.printex();
//     }
// }

// import java.util.*;
// interface X{
//     interface Y{
//         void printex() throws Exception;
//     }
// }
// class A implements X.Y{
//     public void printex() throws Exception{
//         Scanner sc = new Scanner(System.in);
//         try {
//             System.out.println("Enter a number:");
//             Integer n = sc.nextInt();
//             System.out.println(n);
//         } catch (Exception e) {
//             System.out.println("Exception block");
//             throw new Exception("Enter the right value");
//         }
//         finally{
//             System.out.println("Finally block");
//             sc.close();
//         }
//     }
//     // X.Y obj = new A();
// }

// public class Exceptions {
//     public static void main(String args[]){
//         A ob = new A();
//         try{
//         ob.printex();
//         }
//         catch(Exception e){
//             System.out.println(e);
//             // e.printStackTrace();
//         }
//     }
// }

// import java.util.Scanner;

// class Exp extends Exception{
//     public Exp(String message){
//         super(message);
//         System.out.println("Custome exception");

//     }
// }

// public class Exceptions{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         try{
//             System.out.println("Enter Number 1: ");
//             Integer n1=sc.nextInt();
//             System.out.println("Enter Number 2: ");
//             Integer n2=sc.nextInt();
//             if(n2==0){
//                 throw new Exp("Div by Zero exception");
//             }
//             System.out.println(n1/n2);
//         }
//         catch (Exp e){
//             System.out.println(e);
//         }
//     }
// }

import java.util.Scanner;

class Exp extends Exception{
    public Exp(String message){
        super(message);
        System.out.println("Custome exception");

    }
}

public class Exceptions{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number 1: ");
        Integer n1=sc.nextInt();
        System.out.println("Enter Number 2: ");
        Integer n2=sc.nextInt();
        try{
            // assert n2>0:"Number is < 0 ";
            assert n2>0;
        }
        catch(AssertionError e){
            System.out.println(e);
        }
    }
}