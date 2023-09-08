import java.util.*;


public class Clct {
    public static void main(String[] args) {
        // List
        // ArrayList <Integer> list1= new ArrayList<>();  
        // LinkedList <Integer> list2 = new LinkedList<>();  
        // Vector <Integer> list3 = new Vector<>();  
        // Stack <Integer> list4 = new Stack<>();
        
        // list1.add(1);
        // list1.add(2);
        // list1.add(3);
        // list1.add(4);
        // list1.add(5);

        // list1.add(5, 6);
        // list1.remove(0);
        // Iterator<Integer> it=list1.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // list2.add(1);
        // list2.add(2);
        // list2.add(3);
        // list2.add(4);
        // list2.add(5);
        // list2.remove(0);
        // it=list2.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // list3.add(1);
        // list3.add(2);
        // list3.add(3);
        // list3.add(4);
        // list3.add(5);
        // list3.remove(4);
        // it=list3.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // list4.push(1);
        // list4.push(2);
        // list4.push(3);
        // list4.pop();
        // it=list4.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        
        // Queue
        // Queue<Integer> q1 = new PriorityQueue<>();  
        // Queue<Integer> q2 = new ArrayDeque<>(); 
        // q1.add(1);
        // q1.add(2);
        // q1.add(3);
        // q1.add(4);
        // System.out.println(q1.peek());
        // System.out.println(q1.element());
        // System.out.println();

        // q1.remove();
        // q1.poll();
        // Iterator<Integer> it=q1.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();

        // q2.add(1);
        // q2.add(2);
        // q2.add(3);
        // q2.add(4);
        // System.out.println(q2.peek());
        // System.out.println(q2.element());
        // q2.remove();
        // q2.poll();
        // System.out.println();

        // for (Integer i:q2) {
        //     System.out.println(i);
        // }
        // System.out.println();

        // Set
        // Set<Integer> s1 = new HashSet<Integer>();  
        // Set<Integer> s2 = new LinkedHashSet<Integer>();  
        // Set<Integer> s3 = new TreeSet<Integer>();
        // s1.add(1);
        // s1.add(2);
        // s1.add(3);
        // s1.remove(1);
        // Iterator<Integer> it=s1.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // s1.clear();

        // s2.add(1);
        // s2.add(2);
        // s2.add(3);
        // s2.remove(1);
        // it=s2.iterator();
        // System.out.println(s2.isEmpty());
        // System.out.println(s2.size());
        // System.out.println();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // s2.clear();

        // s3.add(1);
        // s3.add(2);
        // s3.add(3);
        // s3.remove(1);
        // it=s2.iterator();
        // System.out.println(s3.isEmpty());
        // System.out.println(s3.size());
        // System.out.println();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // s3.clear();
        
        // HashMap
        LinkedHashMap<Integer,Integer> h = new LinkedHashMap<>();
        h.put(1,10);
        h.put(2,20);
        h.put(3,30);
        h.put(4,40);

        h.remove(1);
        System.out.println(h.isEmpty());
        System.out.println(h.keySet());
        System.out.println(h.values());
        for(Map.Entry<Integer,Integer> i:h.entrySet()){
            System.out.println(i);
        }
        System.out.println();

        Hashtable<Integer,Integer> h1 = new Hashtable<>();
        h1.put(1,10);
        h1.put(2,20);
        h1.put(3,30);
        h1.put(4,40);

        h1.remove(1);
        System.out.println(h1.isEmpty());
        System.out.println(h1.keySet());
        System.out.println(h1.values());
        System.out.println(h1.getOrDefault(10, 0));
        for(Map.Entry<Integer,Integer> i:h1.entrySet()){
            System.out.println(i);
        }
        System.out.println();

        TreeMap<Integer,Integer> h2 = new TreeMap<Integer,Integer>();
        h2.put(1,10);
        h2.put(2,20);
        h2.put(3,30);
        h2.put(4,40);
        h2.remove(2);
        System.out.println(h2.headMap(1,true));
        System.out.println(h2.tailMap(1,true));
        for(Map.Entry<Integer,Integer> i:h1.entrySet()){
            System.out.println(i);
        }
        System.out.println();
    }
}
