package dsa;
import java.util.*;
class LL{
    Integer val;
    LL next;
    static LL head;
    static LL tail;
    static Integer size=1;
    LL(Integer v){
        this.val = v;
        this.next = null;
    }
    void add(Integer num){
        LL node = new LL(num);
        node.next=null;
        tail.next = node;
        tail = node;
        size++;
    }
    void remove(Integer r){
        if(head.val == r){
            head = head.next;
            System.out.println("Removed " + r);
            size--;
            return;
        }
        LL temp = head.next;
        LL prev = head;
        while (temp!=null){
            if (temp.val == r){
                prev.next = temp.next;
                System.out.println("Removed "+ r);
                break;
            }
            prev = temp;
            temp=temp.next;
        }
        size--;
    }
    void show(){
        LL temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    void reverse(){
        LL prev = null;
        LL temp = head;
        LL c = head;
        LL nt=c.next;
        while(nt!=null){
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
        Integer c=0;
        if (head.val==f){
            System.out.println("Found "+f+" at index "+c);
            return;
        }
        LL temp = head.next; 
        while(temp!=null){
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
        LL node = new LL(v);
        LL temp = head;
        if(ind==0){
            node.next=temp;
            head=node;
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
                LL ntemp=temp.next;
                temp.next=node;
                node.next=ntemp;
            }
            temp=temp.next;
        }
        size++;
    }
    }
    void swap(Integer v1,Integer v2){
        LL n1 = null;
        LL n1prev = null;
        LL n2prev = null;
        LL n2 = null;
        LL temp = head;
        LL tempprev = null;

        if(head.val==v1){
            n1=temp;
            while(temp!=null){

                if(temp.val==v2){
                    n2prev=tempprev;
                    n2=temp;
                }
                tempprev=temp;
                temp=temp.next;
            }
            LL tempval=null;
            tempval=n1.next;
            n1.next=n2.next;
            n2.next=tempval;
            n2prev.next=n1;
            head = n2;
            if(tail.val == v2){
                tail=n1;
            }
            return;
        }
        while(temp!=null){
            if(temp.val==v1){
                n1prev=tempprev;
                n1=temp;
            }
            if(temp.val==v2){
                n2prev=tempprev;
                n2=temp;
            }
            tempprev=temp;
            temp=temp.next;
        }
        LL tempval=null;
        tempval=n1.next;
        n1.next=n2.next;
        n2.next=tempval;
        n1prev.next=n2;
        n2prev.next=n1;
    }
}
// 1 2 3 4 5
public class LinkedListImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter val");
        Integer v = sc.nextInt();
        sc.nextLine();
        LL n = new LL(v);
        n.head = n;
        n.tail = n;
        while(true){
            System.out.println("Choose to add, remove, reverse, find, insert, swap or show elements: ");
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
        // LL n = new LL(1);
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
        // n.find(2);
        // n.find(10);
        // n.insert(0,1);
        // n.insert(4,5);
        // n.show();
    }
}