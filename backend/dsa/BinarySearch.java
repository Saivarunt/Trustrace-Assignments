package dsa;
import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
            ArrayList<Integer> l= new ArrayList<Integer>();
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Add or break?");
                String choice=sc.nextLine();
                if(choice.equals("add")){
                    System.out.println("Enter val: ");
                    Integer val = sc.nextInt();
                    l.add(val);
                    sc.nextLine();
                    continue;
                }
                else{
                    break;
                }
            }
            System.out.println("Enter element to search");
            Integer search = sc.nextInt();
            sc.nextLine();

            Collections.sort(l);

            Integer lo=0,hi=l.size()-1;
            Integer mid=lo+(hi-lo)/2;
            Integer found=0;
            while(lo<=hi){
                if(l.get(mid)==search){
                    System.out.println("Found element at "+ mid);
                    found=1;
                    break;
                }
                else if(search>l.get(mid)){
                    lo=mid+1;
                    mid=(lo+hi)/2;
                }
                else{
                    hi=mid-1;
                    mid=(lo+hi)/2;
                }
            }
            if(found==0){
                System.out.println("Not Found");
            }
    }
}
