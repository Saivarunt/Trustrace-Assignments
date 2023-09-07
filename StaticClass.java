// interface M{
//     static class A{
//     static void print(){
//         System.out.println("It work");
//     }
//     }
// }



// public class StaticClass extends M.A{
//     public static void main(String[] args) {
//         M.A.print();
//     }    
// }



// class M{
//     Integer x=10;
//     static class A{
//     Integer y=20;
//     static Integer z=30;
//     static void print(){
//         System.out.println("It works");
//     }
//     }
// }



// public class StaticClass extends M.A{
//     public static void main(String[] args) {
//         // M.A.print();
//         M obj1 = new M();
//         M.A obj2 = new M.A();
//         System.out.println("Outer class variable: "+ obj1.x);

//         System.out.println("Static :"+z);
        
//         // System.out.println(y);// cannot access

//         // System.out.println(M.A.y);
//         System.out.println("Non static :"+obj2.y);
//     }    
// }



class M{

    static class A{
    Integer y=20;
    static Integer z=30;
    static void print(){
        System.out.println("It works");
    }
    }
}



public class StaticClass extends M.A{
    public static void main(String[] args) {
        // M.A.print();
        M.A obj1 = new M.A();
        M.A obj2 = new M.A();

        obj1.z=obj1.z+1;
        obj1.y=obj1.y+1;

        System.out.println("Static :"+obj2.z);
        
        // System.out.println(y);// cannot access

        // System.out.println(M.A.y);
        System.out.println("Non static :"+obj2.y);
    }    
}

