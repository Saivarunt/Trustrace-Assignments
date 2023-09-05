class Shape{
    Float l,b;
    Shape(Float l1, Float b1){
        this.l=l1;
        this.b=b1;
    }
    void draw(){
        System.out.println("Length : "+l+" "+"Breadth : "+b);
    }
    void draw(Float pi){
        System.out.println("Radius : "+l+" "+"Diameter : "+b*2 +" "+ "Pi : "+pi);
    }
}
class Rectangle extends Shape{
    Rectangle(Float l1,Float b1){
        super(l1,b1);
        super.draw();
    }
}
class Circle extends Shape{
    Circle(Float r1,Float r2, Float pi){
        super(r1,r2);
        super.draw(pi);
    }
}

public class Inheritance {
    public static void main(String args[]){
        Circle c = new Circle(3f,3f,3.14f);
        Rectangle r = new Rectangle(7f, 4f);
    }
}
