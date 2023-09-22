package dsa;

import java.util.*;
class Collatz {
    static HashMap<Long,Long> h = new HashMap<Long,Long>();
    void check(long number){
            long count=1;
            long sum=number;
            while(sum>1){
                count++;
                if(sum%2==0){ 
                    sum=sum/2;
                }
                else{
                    sum=(3*sum)+1;
                }

                if(sum==1){
                    h.put(number,count);
                    break;
                }
            }
        return;
    }

    // Method 2
    // Integer check(Integer number){
    //     if(number==1){
    //         return 1;
    //     }
    //     Integer count=0;
    //     Integer sum=number;
    //     while(sum>1){
    //         if(sum%2==0){ 
    //             sum=sum/2;
    //             count++;
    //         }
    //         else{
    //             sum=(3*sum)+1;
    //             count++;
    //         }
    //         if(h.containsKey(sum)){
    //             count+=h.get(sum);
    //             break;
    //         }
    //     }
    //     return count;
    // }
}

public class LCS{
    public static void main(String[] args) {
        long n = 1000000;
        Collatz c = new Collatz(); 
        long i=1;
        while(i<=n){
            // Collatz.h.put(i,c.check(i));
            c.check(i);
            i++;
        }
        System.out.println(Collatz.h);
        System.out.println();
        System.out.println("Max Val: "+Collections.max(Collatz.h.values())+"");
        for(var j:Collatz.h.entrySet()){
            if(j.getValue()==525){
                System.out.println("Number: "+j.getKey());
                break;
            }
        }
    }
}