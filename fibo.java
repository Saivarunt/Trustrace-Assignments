// Fibonacci Series
import java.util.*;
public class fibo{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		int i=0;
		int a=0;
		int b=1;
		int temp;
		System.out.println("Fibonacci Series: ");
		while(i+2<num){
			if (i==0){
			System.out.println(a);
			System.out.println(b);
			}
			temp=b;
			b= a+b;
			a=temp;
			System.out.println(b);
			i++;
		}
	}
}