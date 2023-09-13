package dsa;
import java.util.*;
class Imp{
    Integer max=1;
    Integer mainmax=0;
    void charrep(String s1,Integer k){
        Integer i=0;
        Integer j=1;
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
                    System.out.println(i+""+s1.charAt(j)+""+j+""+itemp);
                    i=itemp;
                    j=i+1;
                    k=kcopy;
                    f=1;
                    if(max>mainmax){
                        mainmax=max;
                    }
                    max=1;
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
