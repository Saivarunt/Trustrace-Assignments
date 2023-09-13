
package dsa;
import java.util.*;
class CDLL{
    Integer val;
    CDLL next;
    CDLL prev;
    static CDLL head;
    static CDLL tail;
    static Integer size=1;
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
        size++;
    }
    void remove(Integer r){
        if(head.val == r){
            head = head.next;
            head.prev=tail;
            tail.next=head;
            System.out.println("Removed " + r);
            // System.out.println("head: "+head.val+"tail: "+tail.val);
            size--;
            return;
        }
        CDLL temp = head.next;
        while (temp!=head && temp.next!=head){
            if (temp.val == r){
                temp.prev.next = temp.next;
                temp.next.prev=temp.prev;
                System.out.println("Removed "+ r);
                // System.out.println("head: "+head.val+"tail: "+tail.val+ "head prev"+head.prev.val);
                size--;
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
            size--;
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
        // System.out.println("head: "+head.val+"tail: "+tail.val);
        head = ttail;
        tail=temp1;
        tail.next=head;
        head.prev=tail;
        // System.out.println("head: "+head.val+"next"+head.next.val+"tnext"+tail.next.val+"tail: "+tail.val);

    }
    void find(Integer f){
        Integer c=0;
        if (head.val==f){
            System.out.println("Found "+f+" at index "+c);
            return;
        }
        CDLL temp = head.next; 
        while(temp!=head){
            if(temp.val==f){
            c+=1;
            System.out.println("Found "+f+" at index "+c);
            return;            
            }
            temp=temp.next;
            c+=1;
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
            size++;
            return;
        }
        if (ind>size){
            System.out.println("Enter val less than "+size);
            return;
        }
        else{
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
    }
        size++;
        // tail=tail.next;
        // head.prev=tail;
        
    }
    void swap(Integer val1, Integer val2) {
        if(head.val==val1 && tail.val==val2){
            CDLL temp=head;
            CDLL ttail=tail;
            temp.next.prev=ttail;
            ttail.prev.next=temp;
            ttail.next=temp.next;
            temp.prev=ttail.prev;
            
            head = ttail;
            tail=temp;
            tail.next=head;
            head.prev=tail;
            return;
        }
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
            if(n1.next==n2){
            n2.next.prev=n1;
            n1.prev.next=n2;
            n1.next=n2.next;
            n2.prev=n1.prev;
            n2.next=n1;
            n1.prev=n2;
            }
            else{
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
        }
        else{
            System.out.println("given value is not in list");
        }

    }
}

public class CircularDoublyLL {
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
