
package dsa;
import java.util.*;
class DLL{
    Integer val;
    DLL next;
    DLL prev;
    static DLL head;
    static DLL tail;
    DLL(Integer v){
        this.val = v;
        this.next = null;
        this.prev = null;
    }
    void add(Integer num){
        DLL node = new DLL(num);
        node.next = null;
        node.prev = tail;
        tail.next = node;
        tail = node;
    }
    void remove(Integer r){
        if(head.val == r){
            head = head.next;
            head.prev=null;
            System.out.println("Removed " + r);
            return;
        }
        DLL temp = head.next;
        while (temp!=null && temp.next!=null){
            if (temp.val == r){
                temp.prev.next = temp.next;
                temp.next.prev=temp.prev;
                System.out.println("Removed "+ r);
                return;
            }
            temp=temp.next;
        }
        if (temp.val == r){
            temp.prev.next = temp.next;
            tail=temp.prev;
            System.out.println("Removed "+ r);
            return;
        }
        System.out.println("Not Found");
    }
    void show(){
        DLL temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    void reverse(){
        DLL t = null;
        DLL temp=head;
        DLL temp1 = head;
        DLL ttail = tail;
        while(temp!=null){
            t = temp.prev;
            temp.prev = temp.next;
            temp.next = t;
            temp=temp.prev;
        }
        head = ttail;
        tail=temp1;
    }
    void find(Integer f){
        if (head.val==f){
            System.out.println("Found "+f);
            return;
        }
        DLL temp = head.next; 
        while(temp!=null){
            if(temp.val==f){
            System.out.println("Found "+f);
            return;            
            }
            temp=temp.next;
        }
        System.out.println("Not Found");
    }
    void insert(Integer ind, Integer v){
        DLL node = new DLL(v);
        DLL temp = head;
        if(ind==0){
            node.next=temp;
            temp.prev=node;
            head=node;
            return;
        }
        for(Integer i=0;i<ind;i++){
            if(i==ind-1){
                DLL ntemp=temp.next;
                temp.next=node;
                node.prev=temp;
                node.next=ntemp;
                if(ntemp!=null){
                    ntemp.prev=node;
                }
            }
            temp=temp.next;
        }
        
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter val");
        Integer v = sc.nextInt();
        sc.nextLine();
        DLL n = new DLL(v);
        n.head = n;
        n.tail = n;
        while(true){
            System.out.println("Choose to add, remove, reverse, find, insert or show elements: ");
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
            else{
                break;
            }
        }

//         DLL n = new DLL(1);
//         n.head = n;
//         n.tail = n;
//         n.add(2);
//         n.add(3);
//         n.add(4);
//         n.add(5);
//         n.remove(5);
//         n.remove(1);
//         n.show();
//         n.reverse();
//         n.show();
//         n.reverse();
//         n.show();
//         n.find(2);
//         n.find(10);
//         n.insert(0,1);
//         n.insert(4,5);
//         n.show();
    }
}

