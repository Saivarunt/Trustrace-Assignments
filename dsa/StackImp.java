package dsa;
import java.util.*;
class St{
    Integer ar[];
    static Integer size=0;
    St(Integer ar[]){
        this.ar=ar;
        this.size=ar.length;
    }
    void push(Integer v){
        System.out.println("pushed");
        ar[size-1]=v;
        size--;
    }
    void pop(){
        if(size==ar.length){
            System.out.println("Nothing to pop enter items first");
            return;
        }
        System.out.println(ar[size]);
        ar[size]=null;
        size++;
    }
    void peek(){
        System.out.println(ar[size]);
    }
    void show(){
        for(Integer i=size-1;i<ar.length;i++){
            if(ar[i]!=null){
            System.out.println(ar[i]);
        }
        }
    }
}
public class StackImp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter stack size");
            Integer v = sc.nextInt();
            Integer a[] = new Integer[v];
            sc.nextLine();
            St n = new St(a);

            while(true){
                System.out.println("Choose to push, pop, peek, or show elements: ");
                String op = sc.nextLine();

                if (op.equals("push")){
                    System.out.println("Enter val: ");
                    v = sc.nextInt();
                    sc.nextLine();
                    n.push(v);
                    continue;
                }
                if (op.equals("pop")){
                    n.pop();
                    continue;

                }
                if (op.equals("peek")){
                    n.peek();
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