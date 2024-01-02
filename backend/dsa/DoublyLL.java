
package dsa;
import java.util.*;
class DLL{
    Integer val;
    DLL next;
    DLL prev;
    static DLL head;
    static DLL tail;
    static Integer size=1;
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
        size++;
    }
    void remove(Integer r){
        if(head.val == r){
            head = head.next;
            head.prev=null;
            System.out.println("Removed " + r);
            size--;
            return;
        }
        DLL temp = head.next;
        while (temp!=null && temp.next!=null){
            if (temp.val == r){
                temp.prev.next = temp.next;
                temp.next.prev=temp.prev;
                System.out.println("Removed "+ r);
                size--;
                return;
            }
            temp=temp.next;
        }
        if (temp.val == r){
            temp.prev.next = temp.next;
            tail=temp.prev;
            System.out.println("Removed "+ r);
            size--;
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
        Integer c=0;
        if (head.val==f){
            System.out.println("Found "+f +" at index "+c);
            return;
        }
        DLL temp = head.next; 
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
        DLL node = new DLL(v);
        DLL temp = head;
        if(ind==0){
            node.next=temp;
            temp.prev=node;
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
        size++;   
    }
    void swap(Integer v1,Integer v2){
        if(head.val==v1 && tail.val==v2){
            DLL temp=head;
            DLL ttail=tail;
            // System.out.println("hv: "+head.val+" hn:"+head.next.next.val +"tv:"+tail.val+" tp:"+tail.prev.val);

            ttail.next=temp.next;
            temp.next.prev=ttail;
            
            temp.prev=ttail.prev;
            ttail.prev.next=temp;

            ttail.prev=null;
            temp.next=null;
            
            head = ttail;
            tail=temp;
            // System.out.println("hv: "+head.val+" hn:"+head.next.next.val +"tv:"+tail.val+" tp:"+tail.prev.val);
            return;
        }
        if(tail.val==v1 && head.val==v2){
            DLL temp=tail;
            DLL ttail=head;
            // System.out.println("hv: "+head.val+" hn:"+head.next.next.val +"tv:"+tail.val+" tp:"+tail.prev.val);

            ttail.next=temp.next;
            temp.next.prev=ttail;
            
            temp.prev=ttail.prev;
            ttail.prev.next=temp;

            ttail.prev=null;
            temp.next=null;
            
            tail = ttail;
            head=temp;
            // System.out.println("hv: "+head.val+" hn:"+head.next.next.val +"tv:"+tail.val+" tp:"+tail.prev.val);
            return;
        }
        DLL node=head;
        DLL n1=null,n2=null;
        while(node.next!=null){
            if(node.val==v1){
                n1=node;
            }
            else if(node.val==v2){
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
            else if(n2.next==n1){
            n1.next.prev=n2;
            n2.prev.next=n1;
            n2.next=n1.next;
            n1.prev=n2.prev;
            n1.next=n2;
            n2.prev=n1;
            }
            else{
            n1.prev.next=n2;
            n2.prev.next=n1;
            n1.next.prev=n2;
            n2.next.prev=n1;
            DLL temp=n1.next;
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

