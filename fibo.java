// Fibonacci Series
//import java.util.*;
//public class fibo{
//	public static void main(String args[]){
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a number: ");
//		int num = sc.nextInt();
//		int i=0;
//		int a=0;
//		int b=1;
//		int temp;
//		System.out.println("Fibonacci Series: ");
//		while(i+2<num){
//			if (i==0){
//			System.out.println(a);
//			System.out.println(b);
//			}
//			temp=b;
//			b= a+b;
//			a=temp;
//			System.out.println(b);
//			i++;
//		}
//	}
//}

//import java.util.*;
//class Fb{
//	int fb(int a1, int b1,int number){
//		if(number==0){
//			System.out.println(a1+b1);
//			return 0;
//		}
//		else{
//		int temp=b1;
//		b1=b1+a1;
//		a1=temp;
//		System.out.println(b1);
//		fb(a1,b1,number-1);
//		}
//	return 0;
//	}}
//public class fibo{
//	public static void main(String args[]){
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a number: ");
//		int num = sc.nextInt();
//		int a=0;
//		int b=1;
//		System.out.println(a);
//		System.out.println(b);
//		Fb obj=new Fb();
//		obj.fb(a,b,num);
//
//	}
//}

class Fb{
	int fb(int a1, int b1,int number){
		if(number==0){
			System.out.println(a1+b1);
			return 0;
		}
		else{
		int temp=b1;
		b1=b1+a1;
		a1=temp;
		System.out.println(b1);
		fb(a1,b1,number-1);
		}
	return 0;
	}}
public class fibo{
	public static void main(String args[]){
		int num = Integer.parseInt(args[0]);
		int a=0;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		Fb obj=new Fb();
		obj.fb(a,b,num);

	}
}