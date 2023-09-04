import java.util.ArrayList;

public class Convar{
	public static void main(String args[]){
		Shape s1 = new Shape();
		s1.length=5f;
		s1.breadth=6f;

		Shape.getX(10);
		s1.printall();
		Shape s2 = new Shape(7f,7f);
		System.out.println("s2");
		s2.printall();
		
		s1.a = new ArrayList<String>();
		s1.a.add("1");
		System.out.println("s1");
		s1.printall();
		
		Shape s3 = new Shape(s1);
		s3.a.add("2");
		
		System.out.println("s2");
		s2.printall();
		System.out.println("s3");
		s3.breadth=5f;
		s3.printall();
		System.out.println("s1");
		s1.printall();
	}
}