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
            if(s1.charAt(i)!=s1.charAt(j)){
                if(k!=0){
                    k--;
                    max++;
                    if(f==1){
                        itemp=j;
                        f--;
                    }
                }
                else{
                    i=itemp;
                    j=i;
                    k=kcopy;
                    f=1;
                    if(max>mainmax){
                        mainmax=max;
                    }
                    max=0;
                    continue;
                }
            }
            else{
                max++;
            }
            j++;
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
