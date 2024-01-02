package dsa;

import java.util.Scanner;

class Q{
    Integer ar[];
    static Integer size=0;
    Q(Integer ar[]){
        this.ar=ar;    
    }
    void enqueue(Integer v){
        if(ar.length == size){
            System.out.println("queue is full");
            return;
        }
        System.out.println("enqueue");
        ar[size]=v;
        size++;
    }
    void dequeue(){
        if(ar.length==0){
            System.out.println("enter elements first");
            return;
        }
        for(Integer i=0;i<size-1;i++){
            ar[i]=ar[i+1];
        }
        ar[size-1]=null;
        System.out.println("dequeue");
        if (size<ar.length){
            ar[size]=0;
        }
        size--;
    }
    void addBack(Integer v){
        if(ar.length == size){
            System.out.println("queue is full");
            return;
        }
        System.out.println("add back");
        for(Integer i=size-1;i>=0;i--){
            ar[i+1]=ar[i];
        }
        ar[0]=v;
        size++;
    }
    void removeFront(){
        System.out.println("removeFront");
        for(Integer i=0;i<ar.length-1;i++){
            ar[i]=ar[i+1];
        }
        ar[ar.length-1]=null;
        size--;
    }
    void find(Integer v){
        for(Integer i=0;i<ar.length;i++){
            if(ar[i]==v){
                System.out.println("Found in index "+i);
                return;
            }
        }
        System.out.println("Not found");
    }
    void show(){
        for(Integer i=0;i<ar.length;i++){
            if(ar[i]!=null && ar[i]!=0){
                System.out.println(ar[i]);
            }
        }
    }

}

public class QueueImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter queue size");
        Integer v = sc.nextInt();
        Integer a[] = new Integer[v];
        sc.nextLine();
        Q n = new Q(a);

        while(true){
            System.out.println("Choose to enqueue, dequeue, addBack, removeFront, find or show elements: ");
            String op = sc.nextLine();

            if (op.equals("enqueue")){
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.enqueue(v);
                continue;
            }
            if (op.equals("addBack")){
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.addBack(v);
                continue;
            }
            if (op.equals("dequeue")){
                n.dequeue();
                continue;
            }
            if (op.equals("removeFront")){
                n.removeFront();
                continue;
            }
            if (op.equals("find")){
                System.out.println("Enter val: ");
                v = sc.nextInt();
                sc.nextLine();
                n.find(v);
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
    }
}
