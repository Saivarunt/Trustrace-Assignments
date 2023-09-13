// package dsa;
// import java.util.*;
// class LL{
//     Integer val;
//     LL next;
//     static LL head;
//     static LL tail;
//     LL(Integer v){
//         this.val = v;
//         this.next = null;
//     }
//     void add(Integer num){
//         LL node = new LL(num);
//         node.next=null;
//         tail.next = node;
//         tail = node;
//     }
//     void remove(Integer r){
//         if(head.val == r){
//             head = head.next;
//             System.out.println("Removed " + r);
//             return;
//         }
//         LL temp = head.next;
//         LL prev = head;
//         while (temp!=null){
//             if (temp.val == r){
//                 prev.next = temp.next;
//                 System.out.println("Removed "+ r);
//                 break;
//             }
//             prev = temp;
//             temp=temp.next;
//         }
//     }
//     void show(){
//         LL temp = head;
//         while(temp!=null){
//             System.out.println(temp.val);
//             temp = temp.next;
//         }
//     }
//     void reverse(){
//         LL prev = null;
//         LL temp = head;
//         LL c = head;
//         LL nt=c.next;
//         while(nt!=null){
//             c.next=prev;
//             prev = c;
//             c=nt;
//             nt = nt.next;
//         }
//         c.next=prev;
//         head = c;
//         tail=temp;
//     }
//     void find(Integer f){
//         if (head.val==f){
//             System.out.println("Found "+f);
//             return;
//         }
//         LL temp = head.next; 
//         while(temp!=null){
//             if(temp.val==f){
//             System.out.println("Found "+f);
//             return;            
//             }
//             temp=temp.next;
//         }
//         System.out.println("Not Found");
//     }
//     void insert(Integer ind, Integer v){
//         LL node = new LL(v);
//         LL temp = head;
//         if(ind==0){
//             node.next=temp;
//             head=node;
//             return;
//         }
//         for(Integer i=0;i<ind;i++){
//             if(i==ind-1){
//                 LL ntemp=temp.next;
//                 temp.next=node;
//                 node.next=ntemp;
//             }
//             temp=temp.next;
//         }
        
//     }
// }
// // 1 2 3 4 5
// public class LinkedListImp {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter val");
//         Integer v = sc.nextInt();
//         sc.nextLine();
//         LL n = new LL(v);
//         n.head = n;
//         n.tail = n;
//         while(true){
//             System.out.println("Choose to add, remove, reverse, find, insert or show elements: ");
//             String op = sc.nextLine();

//             if (op.equals("add")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.add(v);
//             }
//             if (op.equals("remove")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.remove(v);
//             }
//             if (op.equals("reverse")){
//                 n.reverse();
//             }
//             if (op.equals("find")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.find(v);
//             }
//             if (op.equals("insert")){
//                 System.out.println("Enter index: ");
//                 Integer indx = sc.nextInt();
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.insert(indx, v);
//             }
//             if (op.equals("show")){
//                 n.show();
//             }
//             else{
//                 break;
//             }
//         }
//         // LL n = new LL(1);
//         // n.head = n;
//         // n.tail = n;
//         // n.add(2);
//         // n.add(3);
//         // n.add(4);
//         // n.add(5);
//         // n.remove(5);
//         // n.remove(1);
//         // n.show();
//         // n.reverse();
//         // n.show();
//         // n.reverse();
//         // n.find(2);
//         // n.find(10);
//         // n.insert(0,1);
//         // n.insert(4,5);
//         // n.show();
//     }
// }


// package dsa;
// import java.util.*;
// class DLL{
//     Integer val;
//     DLL next;
//     DLL prev;
//     static DLL head;
//     static DLL tail;
//     DLL(Integer v){
//         this.val = v;
//         this.next = null;
//         this.prev = null;
//     }
//     void add(Integer num){
//         DLL node = new DLL(num);
//         node.next = null;
//         node.prev = tail;
//         tail.next = node;
//         tail = node;
//     }
//     void remove(Integer r){
//         if(head.val == r){
//             head = head.next;
//             head.prev=null;
//             System.out.println("Removed " + r);
//             return;
//         }
//         DLL temp = head.next;
//         while (temp!=null && temp.next!=null){
//             if (temp.val == r){
//                 temp.prev.next = temp.next;
//                 temp.next.prev=temp.prev;
//                 System.out.println("Removed "+ r);
//                 return;
//             }
//             temp=temp.next;
//         }
//         if (temp.val == r){
//             temp.prev.next = temp.next;
//             tail=temp.prev;
//             System.out.println("Removed "+ r);
//             return;
//         }
//         System.out.println("Not Found");
//     }
//     void show(){
//         DLL temp = head;
//         while(temp!=null){
//             System.out.println(temp.val);
//             temp = temp.next;
//         }
//     }
//     void reverse(){
//         DLL t = null;
//         DLL temp=head;
//         DLL temp1 = head;
//         DLL ttail = tail;
//         while(temp!=null){
//             t = temp.prev;
//             temp.prev = temp.next;
//             temp.next = t;
//             temp=temp.prev;
//         }
//         head = ttail;
//         tail=temp1;
//     }
//     void find(Integer f){
//         if (head.val==f){
//             System.out.println("Found "+f);
//             return;
//         }
//         DLL temp = head.next; 
//         while(temp!=null){
//             if(temp.val==f){
//             System.out.println("Found "+f);
//             return;            
//             }
//             temp=temp.next;
//         }
//         System.out.println("Not Found");
//     }
//     void insert(Integer ind, Integer v){
//         DLL node = new DLL(v);
//         DLL temp = head;
//         if(ind==0){
//             node.next=temp;
//             temp.prev=node;
//             head=node;
//             return;
//         }
//         for(Integer i=0;i<ind;i++){
//             if(i==ind-1){
//                 DLL ntemp=temp.next;
//                 temp.next=node;
//                 node.prev=temp;
//                 node.next=ntemp;
//                 if(ntemp!=null){
//                     ntemp.prev=node;
//                 }
//             }
//             temp=temp.next;
//         }
        
//     }
// }

// public class LinkedListImp {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter val");
//         Integer v = sc.nextInt();
//         sc.nextLine();
//         DLL n = new DLL(v);
//         n.head = n;
//         n.tail = n;
//         while(true){
//             System.out.println("Choose to add, remove, reverse, find, insert or show elements: ");
//             String op = sc.nextLine();

//             if (op.equals("add")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.add(v);
//             }
//             if (op.equals("remove")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.remove(v);
//             }
//             if (op.equals("reverse")){
//                 n.reverse();
//             }
//             if (op.equals("find")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.find(v);
//             }
//             if (op.equals("insert")){
//                 System.out.println("Enter index: ");
//                 Integer indx = sc.nextInt();
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.insert(indx, v);
//             }
//             if (op.equals("show")){
//                 n.show();
//             }
//             else{
//                 break;
//             }
//         }

// //         DLL n = new DLL(1);
// //         n.head = n;
// //         n.tail = n;
// //         n.add(2);
// //         n.add(3);
// //         n.add(4);
// //         n.add(5);
// //         n.remove(5);
// //         n.remove(1);
// //         n.show();
// //         n.reverse();
// //         n.show();
// //         n.reverse();
// //         n.show();
// //         n.find(2);
// //         n.find(10);
// //         n.insert(0,1);
// //         n.insert(4,5);
// //         n.show();
//     }
// }


// package dsa;

// import java.util.Scanner;

// class CLL{
//     Integer val;
//     CLL next;
//     static CLL head;
//     static CLL tail;
//     CLL(Integer v){
//         this.val = v;
//         this.next = null;
//     }
//     void add(Integer num){
//         CLL node = new CLL(num);
//         node.next=head;
//         tail.next = node;
//         tail = node;
//     }
//     void remove(Integer r){
//         if(head.val == r){
//             head = head.next;
//             tail.next=head;
//             System.out.println("Removed " + r);
//             return;
//         }
//         CLL temp = head.next;
//         CLL prev = head;
//         while (temp.next!=head){
//             if (temp.val == r){
//                 prev.next = temp.next;
//                 System.out.println("Removed "+ r);
//                 break;
//             }
//             prev = temp;
//             temp=temp.next;
//         }
//         if(temp.val==r){
//             prev.next = temp.next;
//             tail=prev;
//             System.out.println("Removed "+ r);
//         }
//     }
//     void show(){
//         CLL temp = head;
//         while(temp.next!=head){
//             System.out.println(temp.val);
//             temp = temp.next;
//         }
//         System.out.println(temp.val);
//     }
//     void reverse(){
//         CLL prev = tail;
//         CLL temp = head;
//         CLL c = head;
//         CLL nt=c.next;
//         while(nt!=head){
//             c.next=prev;
//             prev = c;
//             c=nt;
//             nt = nt.next;
//         }
//         c.next=prev;
//         head = c;
//         tail=temp;
//     }
//     void find(Integer f){
//         if (head.val==f){
//             System.out.println("Found "+f);
//             return;
//         }
//         CLL temp = head.next; 
//         while(temp!=head){
//             if(temp.val==f){
//             System.out.println("Found "+f);
//             return;            
//             }
//             temp=temp.next;
//         }
//         System.out.println("Not Found");
//     }
//     void insert(Integer ind, Integer v){
//         CLL node = new CLL(v);
//         CLL temp = head;
//         if(ind==0){
//             node.next=temp;
//             head=node;
//             tail.next=node;
//             return;
//         }
//         for(Integer i=0;i<ind;i++){
//             if(i==ind-1){
//                 CLL ntemp=temp.next;
//                 temp.next=node;
//                 node.next=ntemp;
//             }
//             temp=temp.next;
//         }
        
//     }
// }

// public class LinkedListImp {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter val");
//         Integer v = sc.nextInt();
//         sc.nextLine();
//         CLL n = new CLL(v);
//         n.head = n;
//         n.tail = n;
//         while(true){
//             System.out.println("Choose to add, remove, reverse, find, insert or show elements: ");
//             String op = sc.nextLine();

//             if (op.equals("add")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.add(v);
//             }
//             if (op.equals("remove")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.remove(v);
//             }
//             if (op.equals("reverse")){
//                 n.reverse();
//             }
//             if (op.equals("find")){
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.find(v);
//             }
//             if (op.equals("insert")){
//                 System.out.println("Enter index: ");
//                 Integer indx = sc.nextInt();
//                 System.out.println("Enter val: ");
//                 v = sc.nextInt();
//                 sc.nextLine();
//                 n.insert(indx, v);
//             }
//             if (op.equals("show")){
//                 n.show();
//             }
//             else{
//                 break;
//             }
//         }


//         // n.add(2);
//         // n.add(3);
//         // n.add(4);
//         // n.add(5);
//         // n.remove(5);
//         // n.remove(1);
//         // n.show();
//         // n.reverse();
//         // n.show();
//         // n.reverse();
//         // n.find(2);
//         // n.find(10);
//         // n.insert(0,1);
//         // n.insert(4,5);
//         // n.show();
//     }
// }



package dsa;
import java.util.*;
class CDLL{
    Integer val;
    CDLL next;
    CDLL prev;
    static CDLL head;
    static CDLL tail;
    CDLL(Integer v){
        this.val = v;
        this.next = null;
        this.prev = null;
    }
    void add(Integer num){
        CDLL node = new CDLL(num);
        node.next = head;
        node.prev = tail;
        tail.next = node;
        tail = node;
    }
    void remove(Integer r){
        if(head.val == r){
            head = head.next;
            head.prev=tail;
            tail.next=head;
            System.out.println("Removed " + r);
            // System.out.println("head: "+head.val+"tail: "+tail.val);

            return;
        }
        CDLL temp = head.next;
        while (temp!=head && temp.next!=head){
            if (temp.val == r){
                temp.prev.next = temp.next;
                temp.next.prev=temp.prev;
                System.out.println("Removed "+ r);
                // System.out.println("head: "+head.val+"tail: "+tail.val+ "head prev"+head.prev.val);
                return;
            }
            temp=temp.next;
        }
        if (temp.val == r){
            temp.prev.next = temp.next;
            tail=temp.prev;
            head.prev=tail;
            System.out.println("Removed "+ r);
            // System.out.println("head: "+head.val+"tail: "+tail.val+"head prev"+head.prev.val);
            return;
        }
        System.out.println("Not Found");
    }
    void show(){
        CDLL temp = head;
        while(temp.next!=head){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
    void reverse(){
        CDLL temp1 = head;
        CDLL ttail = tail;

        CDLL temp=head;
        CDLL nxt=temp.next;
        while(temp.next!=head){
            System.out.println("inloop");
            temp.next = temp.prev;
            temp.prev = nxt;
            temp=temp.prev;
            nxt=nxt.next;
        }
        if(temp.next==head){
            temp.next = temp.prev;
            temp.prev = nxt;
            temp=temp.prev;
        }
        System.out.println("head: "+head.val+"tail: "+tail.val);
        head = ttail;
        tail=temp1;
        tail.next=head;
        head.prev=tail;
        System.out.println("head: "+head.val+"next"+head.next.val+"tnext"+tail.next.val+"tail: "+tail.val);

    }
    void find(Integer f){
        if (head.val==f){
            System.out.println("Found "+f);
            return;
        }
        CDLL temp = head.next; 
        while(temp!=head){
            if(temp.val==f){
            System.out.println("Found "+f);
            return;            
            }
            temp=temp.next;
        }
        System.out.println("Not Found");
    }
    void insert(Integer ind, Integer v){
        CDLL node = new CDLL(v);
        CDLL temp = head;
        if(ind==0){
            node.next=temp;
            head=node;
            tail.next=node;
            temp.prev=node;
            node.prev=tail;
            return;
        }
        for(Integer i=0;i<ind;i++){
            if(i==ind-1){
                CDLL ntemp=temp.next;
                temp.next=node;
                node.prev=temp;
                node.next=ntemp;
                ntemp.prev=node;
                tail=node;
                return;
            }
            temp=temp.next;
        }
        // tail=tail.next;
        // head.prev=tail;
        
    }
    void swap(Integer val1, Integer val2) {
        CDLL node=head;
        CDLL n1=null,n2=null;
        while(node.next!=head){
            if(node.val==val1){
                n1=node;
            }
            else if(node.val==val2){
                n2=node;
            }
            node=node.next;
        }
        if(n1!=null && n2!=null){
            n1.prev.next=n2;
            n2.prev.next=n1;
            n1.next.prev=n2;
            n2.next.prev=n1;
            CDLL temp=n1.next;
            n1.next=n2.next;
            n2.next=temp;
            temp=n1.prev;
            n1.prev=n2.prev;
            n2.prev=temp;
        }
        else{
            System.out.println("given value is not in the list");
        }

    }
}

public class LinkedListImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter val");
        Integer v = sc.nextInt();
        sc.nextLine();
        CDLL n = new CDLL(v);
        n.head = n;
        n.tail = n;
        while(true){
            System.out.println("Choose to add, remove, reverse, find, swap, insert or show elements: ");
            String op = sc.nextLine();

            if (op.equals("add")){
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.add(v);
                continue;
            }
            if (op.equals("remove")){
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.remove(v);
                continue;
            }
            if (op.equals("reverse")){
                n.reverse();
                continue;
            }
            if (op.equals("find")){
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.find(v);
                continue;
            }
            if (op.equals("insert")){
                System.out.println("Enter index: ");
                Integer indx = sc.nextInt();
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.insert(indx, v);
                continue;
            }
            if (op.equals("show")){
                n.show();
                continue;
            }
            if(op.equals("swap")){
                System.out.println("Enter val1: ");
                Integer v1 = sc.nextInt();
                System.out.println("Enter val2: ");
                v = sc.nextInt();
                sc.nextLine();
                n.swap(v1, v);
                continue;
            }
            else{
                break;
            }
        }
        // CDLL n = new CDLL(1);
        // n.head = n;
        // n.tail = n;
        // n.add(2);
        // n.add(3);
        // n.add(4);
        // n.add(5);
        // n.remove(5);
        // n.remove(1);
        // n.show();
        // n.reverse();
        // n.show();
        // n.reverse();
        // n.show();
        // n.find(2);
        // n.find(10);
        // n.insert(0,1);
        // n.insert(4,5);
        // n.show();

    }
}