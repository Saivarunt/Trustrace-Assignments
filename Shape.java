import java.util.*;
class Shape{
	Float length,breadth;
	ArrayList <String> a;
	static Integer x;
Shape(Float l, Float b){
	this();
	this.length=l;
	this.breadth=b;
}
Shape(Shape ob){
	this.length=ob.length;
	this.breadth=ob.breadth;
	this.a=ob.a;
}
Shape(){
	System.out.println("Non parametric constructor");
}
static void getX(int val){
	Shape.x=val;
}

public static void eg(){
	x=10;
	// this.length //throws error- since it cannot contain this in static method
	System.out.println("Static method");
}
void printall(){
	System.out.println(this.length+" "+this.breadth+" "+a);
	System.out.println(x);
	}
}