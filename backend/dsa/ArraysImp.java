package dsa;
import java.util.*;

class Arr{
    Scanner sc = new Scanner(System.in);
    Integer a1[];
    Integer a2[][];
    Arr(Integer a1[],Integer a2[][]){
        this.a1=a1;
        this.a2=a2;
    }
    void add1(){
        System.out.println("Add 1-D elements");
        for(Integer i=0;i<a1.length;i++){
            a1[i]=sc.nextInt();
        }
    }
    void add2(){
        System.out.println("Add 2-D elements");
        for(Integer i=0;i<a2.length;i++){
            for(Integer j=0;j<a2[i].length;j++){
                a2[i][j]=sc.nextInt();
        }
        }
    }
    void remove1(Integer r){
        Integer a1copy[] = new Integer[a1.length];
        System.out.println("Remove 1-D elements");
        for(Integer i=0;i<a1.length;i++){
            if (a1[i]==r){
                a1copy[i]=-1;
                System.out.println("removed element");
            }
            else{
                a1copy[i]=a1[i];
            }
        }
        this.a1=a1copy;
    }
    void remove2(Integer r){
        Integer a2copy[][] = new Integer[a2.length][a2[0].length];
        System.out.println("Remove 2-D elements");
        for(Integer i=0;i<a2.length;i++){
            for (Integer j=0;j<a2[i].length;j++){
                if (a2[i][j]==r){
                    a2copy[i][j]=-1;
                }
                else{
                    a2copy[i][j]=a2[i][j];
                }
            }
        }
        this.a2=a2copy;
    }
    void show1(){
        System.out.println("Print 1-D elements");
        for(Integer i=0;i<a1.length;i++){
            System.out.print(a1[i]);
        }
        System.out.println();
    }
    void show2(){
        System.out.println("Add 2-D elements");
        for(Integer i=0;i<a2.length;i++){
            for(Integer j=0;j<a2[i].length;j++){
                System.out.print(a2[i][j]);
        }
        }
        System.out.println();
    }

}
public class ArraysImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer i = sc.nextInt();
        Integer j = sc.nextInt();
        Integer k = sc.nextInt();
        Integer b[] = new Integer[i];
        Integer c[][] = new Integer[j][k];
        Arr a = new Arr(b,c);
        System.out.println("Add elements");
        a.add1();
        a.add2();
        System.out.println("Remove element");
        Integer ele1 = sc.nextInt();
        Integer ele2 = sc.nextInt();
        a.remove1(ele1);
        a.remove2(ele2);
        System.out.println("Show elements");
        a.show1();
        a.show2();
    }
}
