//Normal
import java.util.*;
public class pattern{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i=1;i<=a;i++){
			for(int i1=1;i1<=i;i1++){
				System.out.print("*");
			}
			for(int j=1;j<=2*(a-i);j++){
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=a;i>=1;i--){
			for(int i1=1;i1<=i;i1++){
				System.out.print("-");
			}
			for(int j=1;j<=2*(a-i);j++){
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print("-");
			}
			System.out.println();
		}
	}
}