
package dsa;

import java.util.Scanner;

class CLL{
    Integer val;
    CLL next;
    static CLL head;
    static CLL tail;
    CLL(Integer v){
        this.val = v;
        this.next = null;
    }
    void add(Integer num){
        CLL node = new CLL(num);
        node.next=head;
        tail.next = node;
        tail = node;
    }
    void remove(Integer r){
        if(head.val == r){
            head = head.next;
            tail.next=head;
            System.out.println("Removed " + r);
            return;
        }
        CLL temp = head.next;
        CLL prev = head;
        while (temp.next!=head){
            if (temp.val == r){
                prev.next = temp.next;
                System.out.println("Removed "+ r);
                break;
            }
            prev = temp;
            temp=temp.next;
        }
        if(temp.val==r){
            prev.next = temp.next;
            tail=prev;
            System.out.println("Removed "+ r);
        }
    }
    void show(){
        CLL temp = head;
        while(temp.next!=head){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
    void reverse(){
        CLL prev = tail;
        CLL temp = head;
        CLL c = head;
        CLL nt=c.next;
        while(nt!=head){
            c.next=prev;
            prev = c;
            c=nt;
            nt = nt.next;
        }
        c.next=prev;
        head = c;
        tail=temp;
    }
    void find(Integer f){
        if (head.val==f){
            System.out.println("Found "+f);
            return;
        }
        CLL temp = head.next; 
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
        CLL node = new CLL(v);
        CLL temp = head;
        if(ind==0){
            node.next=temp;
            head=node;
            tail.next=node;
            return;
        }
        for(Integer i=0;i<ind;i++){
            if(i==ind-1){
                CLL ntemp=temp.next;
                temp.next=node;
                node.next=ntemp;
            }
            temp=temp.next;
        }
        
    }
}

public class CircularLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter val");
        Integer v = sc.nextInt();
        sc.nextLine();
        CLL n = new CLL(v);
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
        // n.find(2);
        // n.find(10);
        // n.insert(0,1);
        // n.insert(4,5);
        // n.show();
    }
}