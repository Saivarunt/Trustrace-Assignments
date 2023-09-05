//nesting interface within interface
// interface A1{
//     void display();
//     interface A2{
//         void txt();
//     }
// }

// public class Nestedinterface implements A1, A1.A2{
//     public void display(){
//         System.out.println("Parent Interface");
//     }
//     public void txt(){
//         System.out.println("Child interface");
//     }
//     public static void main(String args[]){
//         A1 o = new Nestedinterface();
//         o.display();
//         A1.A2 c = new Nestedinterface();
//         c.txt();
//     }
// }

//nesting class within interface
// interface X{
//     public class Y{
//         void sample(){
//             System.out.println("Sample");
//         }
//     }
// }
// public class Nestedinterface implements X{
//     public static void main(String args[]){
//         X o = new Nestedinterface();
//         X.Y nobj = new X.Y();
//         nobj.sample();
//     }
// }

//interface inside class
class New1{
    interface B{
        void intefacemethod();
    }
    void show(){
        System.out.println("Access Class");
    }
}

public class Nestedinterface extends New1 implements New1.B{
    public void intefacemethod(){
            System.out.println("Implementation");
        }
    public static void main(String args[]){
        New1.B o = new Nestedinterface();
        o.intefacemethod();
        New1 b = new Nestedinterface();
        b.show();
    }
}