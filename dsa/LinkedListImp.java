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
        if (head.val==f){
            System.out.println("Found "+f);
            return;
        }
        LL temp = head.next; 
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
        for(Integer i=0;i<ind;i++){
            if(i==ind-1){
                LL ntemp=temp.next;
                temp.next=node;
                node.next=ntemp;
            }
            temp=temp.next;
        }


        
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