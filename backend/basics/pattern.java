//Normal
//import java.util.*;
//public class pattern{
//	public static void main(String args[]){
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		for(int i=1;i<=a;i++){
//			for(int i1=1;i1<=i;i1++){
//				System.out.print("*");
//			}
//			for(int j=1;j<=2*(a-i);j++){
//				System.out.print(" ");
//			}
//			for(int k=1;k<=i;k++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i=a;i>=1;i--){
//			for(int i1=1;i1<=i;i1++){
//				System.out.print("-");
//			}
//			for(int j=1;j<=2*(a-i);j++){
//				System.out.print(" ");
//			}
//			for(int k=1;k<=i;k++){
//				System.out.print("-");
//			}
//			System.out.println();
//		}
//	}
//}

//Recursion
import java.util.*;
public class pattern{
	public static int ptn1(int number,int i,int j,int k){
		if(i<=0){
			return 0;
		}
		else{
			for(int x=1;x<=i;x++){
				System.out.print("-");
			}
			for(int y=1;y<=j;y++){
				System.out.print(" ");
			}
			for(int z=1;z<=k;z++){
				System.out.print("-");
			}
			System.out.println();
			i=i-1;
			return ptn1(number,i,2*(number-i),i);
		}
	}

	public static int ptn(int number,int i,int j,int k){
		if(i>number){
			return 0;
		}
		else{
			for(int x=1;x<=i;x++){
				System.out.print("*");
			}
			for(int y=1;y<=j;y++){
				System.out.print(" ");
			}
			for(int z=1;z<=k;z++){
				System.out.print("*");
			}
			System.out.println();
			i=i+1;
			return ptn(number,i,2*(number-i),i);
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int i=1;
		ptn(a,i,2*(a-i),i);
		ptn1(a,a,2*(a-a),a);
	}
}