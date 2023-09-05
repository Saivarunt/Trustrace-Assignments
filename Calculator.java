import java.util.*;
interface Calci{
    void add(Integer a, Integer b);
    void add(Float a, Float b);
    void add(Double a, Double b);

    void add(Integer a, Float b);
    void add(Float a, Integer b);

    void add(Integer a, Double b);
    void add(Double a, Integer b);
    
    void add(Float a, Double b);
    void add(Double a, Float b);

    void sub(Integer a, Integer b);
    void sub(Float a, Float b);
    void sub(Double a, Double b);
    void sub(Integer a, Float b);
    void sub(Float a, Integer b);

    void sub(Integer a, Double b);
    void sub(Double a, Integer b);
    
    void sub(Float a, Double b);
    void sub(Double a, Float b);

    void div(Integer a, Integer b);
    void div(Float a, Float b);
    void div(Double a, Double b);

    void div(Integer a, Float b);
    void div(Float a, Integer b);

    void div(Integer a, Double b);
    void div(Double a, Integer b);
    
    void div(Float a, Double b);
    void div(Double a, Float b);

    void mul(Integer a, Integer b);
    void mul(Float a, Float b);
    void mul(Double a, Double b);

    void mul(Integer a, Float b);
    void mul(Float a, Integer b);

    void mul(Integer a, Double b);
    void mul(Double a, Integer b);
    
    void mul(Float a, Double b);
    void mul(Double a, Float b);
} 
class Calc implements Calci{
    public void add(Integer a, Integer b){
        System.out.println(a+b);
    }
    public void add(Float a, Float b){
        System.out.println(a+b);
    }
    public void add(Double a, Double b){
        System.out.println(a+b);
    }

    public void add(Integer a, Float b){
        System.out.println(a+b);
    }
    public void add(Float a, Integer b){
        System.out.println(a+b);
    }

    public void add(Integer a, Double b){
        System.out.println(a+b);
    }
    public void add(Double a, Integer b){
        System.out.println(a+b);
    }
    
    public void add(Float a, Double b){
        System.out.println(a+b);
    }
    public void add(Double a, Float b){
        System.out.println(a+b);
    }

    public void sub(Integer a, Integer b){
        System.out.println(a-b);
    }
    public void sub(Float a, Float b){
        System.out.println(a-b);
    }
    public void sub(Double a, Double b){
        System.out.println(a-b);
    }
    public void sub(Integer a, Float b){
        System.out.println(a-b);
    }
    public void sub(Float a, Integer b){
        System.out.println(a-b);
    }

    public void sub(Integer a, Double b){
        System.out.println(a-b);
    }
    public void sub(Double a, Integer b){
        System.out.println(a-b);
    }
    
    public void sub(Float a, Double b){
        System.out.println(a-b);
    }
    public void sub(Double a, Float b){
        System.out.println(a-b);
    }

    public void div(Integer a, Integer b){
        System.out.println(a/b);
    }
    public void div(Float a, Float b){
        System.out.println(a/b);
    }
    public void div(Double a, Double b){
        System.out.println(a/b);
    }
    public void div(Integer a, Float b){
        System.out.println(a/b);
    }
    public void div(Float a, Integer b){
        System.out.println(a/b);
    }

    public void div(Integer a, Double b){
        System.out.println(a/b);
    }
    public void div(Double a, Integer b){
        System.out.println(a/b);
    }
    
    public void div(Float a, Double b){
        System.out.println(a/b);
    }
    public void div(Double a, Float b){
        System.out.println(a/b);
    }

    public void mul(Integer a, Integer b){
        System.out.println(a*b);
    }
    public void mul(Float a, Float b){
        System.out.println(a*b);
    }
    public void mul(Double a, Double b){
        System.out.println(a*b);
    }
    public void mul(Integer a, Float b){
        System.out.println(a*b);
    }
    public void mul(Float a, Integer b){
        System.out.println(a*b);
    }

    public void mul(Integer a, Double b){
        System.out.println(a*b);
    }
    public void mul(Double a, Integer b){
        System.out.println(a*b);
    }
    
    public void mul(Float a, Double b){
        System.out.println(a*b);
    }
    public void mul(Double a, Float b){
        System.out.println(a*b);
    }
}

public class Calculator {
    public static void main(String args[]){
        Calci obj = new Calc();
        obj.add(7f, 8);
        obj.sub(9f, 5f);
        obj.div(7.5, 2);
        obj.mul(5, 2.9);
    }
}
