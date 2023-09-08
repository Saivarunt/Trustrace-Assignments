import java.util.HashMap;
import java.util.Map;

class A{
    Integer i;
    A(){
        
    }
    A(Integer x){
        this.i=x;
    }
}
public class HM {
    public static void main(String[] args) {
        // permits null values and the null key
        // The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.  it does not guarantee that the order will remain constant over time.
        // If multiple threads access a hash map concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally. (A structural modification is any operation that adds or deletes one or more mappings; merely changing the value associated with a key that an instance already contains is not a structural modification.)
        HashMap<String,A> h = new HashMap<>();
        // A obj = new A();
        h.put("a", new A(2));
        h.put("b", new A(3));
        // Shallow copy working
        HashMap<String,A> h1=(HashMap<String, A>) h.clone();
        A y=h1.get("a");
        y.i=15;
        System.out.println(h.get("a").i);
//         h.put("c", 3);
//         h.put("d", 4);
//         h.put("e", 5);
//         System.out.println("h:"+h.keySet()+" "+h.values());
//         System.out.println();
//         h.putIfAbsent("f",6);
//         System.out.println("h:"+h.keySet()+" "+h.values());
//         System.out.println();

//         h.remove("f");
//         h.remove("e",10);

//         System.out.println("h:"+h.keySet()+" "+h.values());
//         System.out.println();
        
//         h.remove("e",5);
//         System.out.println("h:"+h.keySet()+" "+h.values());
//         System.out.println();
//         HashMap<String,Integer> h1=(HashMap<String, Integer>) h.clone();
//         h1.put("f",7);
//                 System.out.println("h"+h.keySet()+" "+h.values());
// System.out.println("h1 now"+h1.keySet()+" "+h1.values());
//         System.out.println();
//         h1.remove("a");
//         h1.clear();
//         System.out.println();
//         System.out.println("h1"+h1.keySet()+" "+h1.values());
//         System.out.println();

//         System.out.println("h:"+h.keySet()+" "+h.values());
//         System.out.println();

//         h.putIfAbsent("g",7);
//         h.putIfAbsent("h",8);
//         h.putIfAbsent("i",9);
//         System.out.println("h:"+h.keySet()+" "+h.values());

//         h.replace("g", 7, 1);
//         h.replace("h", 2);
//         System.out.println("h:"+h.keySet()+" "+h.values());

//         System.out.println(h.get("a"));
//         for (Map.Entry<String,Integer> i:h.entrySet()){
//             System.out.println(i);
//         }
//         System.out.println(h.size());
    }
}
