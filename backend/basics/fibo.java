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

//import java.math.*;
//class Fb{
//	int fb(BigInteger a1, BigInteger b1,int number){
//		if(number==0){
//			System.out.println(a1.add(b1));
//		}
//		else{
//		BigInteger temp = new BigInteger("0"); 
//		temp=b1;
//		b1=b1.add(a1);
//		a1=temp;
//		System.out.println(b1);
//		fb(a1,b1,number-1);
//		}
//	return 0;
//	}}
//public class fibo{
//	public static void main(String args[]){
//		int num = Integer.parseInt(args[0]);
//		BigInteger a = new BigInteger("0");
//		BigInteger b = new BigInteger("1"); 
//		System.out.println(a);
//		System.out.println(b);
//		Fb obj=new Fb();
//		obj.fb(a,b,num);
//
//	}
//}

//Printing it in reverse
//import java.math.*;
//class Fb{
//	int fb(BigInteger a1, BigInteger b1,int number){
//		if(number==0){
//			System.out.println(a1.add(b1));
//		}
//		else{
//		BigInteger temp = new BigInteger("0"); 
//		temp=b1;
//		b1=b1.add(a1);
//		a1=temp;
//		fb(a1,b1,number-1);
//		System.out.println(b1);
//		}
//	return 0;
//	}}
//public class fibo{
//	public static void main(String args[]){
//		int num = Integer.parseInt(args[0]);
//		BigInteger a = new BigInteger("0");
//		BigInteger b = new BigInteger("1"); 
//		Fb obj=new Fb();
//		obj.fb(a,b,num);
//		System.out.println(b);
//		System.out.println(a);
//	}
//}

import java.util.*;
import java.math.*;
class Fb{
	ArrayList <BigInteger> fb(BigInteger a1, BigInteger b1,int number,int count){
		if(count==0){
			if (number==2){
			ArrayList <BigInteger> l1 = new ArrayList<BigInteger>();
			l1.add(a1);
			l1.add(b1);
			return l1;
		}}
		if(number==0){
			ArrayList <BigInteger> l1 = new ArrayList<BigInteger>();
			l1.add(a1);
			l1.add(b1);
			return l1;
		}
		else{
		BigInteger temp = new BigInteger("0"); 
		temp=b1;
		b1=b1.add(a1);
		a1=temp;
		System.out.println(b1);
		return fb(a1,b1,number-1,count);
		}
	}}
public class fibo{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1"); 
		Fb obj=new Fb();
		System.out.println(a);
		System.out.println(b);
		int count=0;
		while (true){
		try{
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		ArrayList<BigInteger> l = obj.fb(a,b,num,count);
		a=l.get(0);
		b=l.get(1);
		count++;
		}
		catch(Exception e){
		break;
		}
		}
	}
}