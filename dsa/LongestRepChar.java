package dsa;
import java.util.*;
class Imp{
    Integer max=0;
    Integer mainmax=0;
    void charrep(String s1,Integer k){
        Integer i=0;
        Integer j=0;
        Integer itemp=0;
        Integer kcopy=k;
        Integer f=1;

        while(i<s1.length() && j<s1.length()){
            if(s1.charAt(i)==s1.charAt(j)){
                max++;
            }
            else{
                if (k==0 && itemp!=0){
                    i=itemp;
                    j=i;
                    k=kcopy;
                    if(max>mainmax){
                        mainmax=max;
                    }
                    f=1;
                    max=0;
                }
                else if(k==0){
                    i=j;
                    k=kcopy;
                    if(max>mainmax){
                        mainmax=max;
                    }
                }
                else{
                    k--;
                    max++;
                    if(f==1){
                        itemp=j;
                        f--;
                    }
                }
            }
            j++;
            if(max>mainmax){
                        mainmax=max;
            }
        }
        k=kcopy;
        j=s1.length()-1;
        i=j;
        max=0;        
        while(i>-1 && j>-1){
            if(s1.charAt(i)==s1.charAt(j)){
                max++;
            }
            else{
                if (k==0 && itemp!=0){
                    i=itemp;
                    j=i;
                    k=kcopy;
                    if(max>mainmax){
                        mainmax=max;
                    }
                    f=1;
                    max=0;
                }
                else if(k==0){
                    i=j;
                    k=kcopy;
                    if(max>mainmax){
                        mainmax=max;
                    }
                }
                else{
                    k--;
                    max++;
                    if(f==1){
                        itemp=j;
                        f--;
                    }
                }
            }
            j--;
            if(max>mainmax){
                        mainmax=max;
            }
        }
        System.out.println(mainmax);
    }
}
public class LongestRepChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter val: ");
        String s = sc.nextLine();
        System.out.println("Enter k val: ");
        Integer k = sc.nextInt();
        Imp o = new Imp();
        o.charrep(s,k);
    }
}
