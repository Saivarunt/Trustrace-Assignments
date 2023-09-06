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

import java.util.*;
interface X{
    interface Y{
        void printex() throws Exception;
    }
}
class A implements X.Y{
    public void printex() throws Exception{
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter a number:");
            Integer n = sc.nextInt();
            System.out.println(n);
        } catch (Exception e) {
            System.out.println("Exception block");
            throw new Exception("Enter the right value");
        }
        finally{
            System.out.println("Finally block");
            sc.close();
        }
    }
    // X.Y obj = new A();
}

public class Exceptions {
    public static void main(String args[]){
        A ob = new A();
        try{
        ob.printex();
        }
        catch(Exception e){
            System.out.println(e);
            // e.printStackTrace();
        }
    }
}
