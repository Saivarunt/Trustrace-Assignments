package dsa;
import java.util.*;
class Tree{
    Integer val;
    Tree parent;
    static Tree root;
    Integer childCount;
    List<Tree> childNodes = new ArrayList<>(); 
    static List<Tree> mainQueue = new ArrayList<>();
    Tree(Integer v, Integer cc){
        this.val=v;
        parent=null;
        this.childCount=cc;
    }
    Tree traverseToAdd(Tree current, Tree element,Integer index){
        if(current.childNodes.size()<childCount){
            current.childNodes.add(element);
            return current;
        }
        else{
            return traverseToAdd(mainQueue.get(index), element,index+1);
        }
    }
    void addVal(Integer v, Integer cc){
        Tree newval = new Tree(v,cc);
        newval.parent = traverseToAdd(root, newval,0);
        mainQueue.add(newval);
    }
    void preOrder(Tree r){
        System.out.print(r.val+" ");
        for(Tree vl:r.childNodes){
            preOrder(vl);
        }
    }
    void postOrder(Tree r){
        for(Tree vl:r.childNodes){
            postOrder(vl);
        }
        System.out.print(r.val+" ");
    }
    void bfs(Tree r){
        System.out.print(r.val+" ");
        Integer ind=0;
        while(ind<mainQueue.size()){
            System.out.print(mainQueue.get(ind).val+" ");
            ind++;
        }
    }
    void dfs(Tree r){
        if(r==root){
            System.out.print(r.val+" ");
        }
        for(Tree node : r.childNodes){
            System.out.print(node.val+" ");
            dfs(node);
        }
    }
}
public class NArrTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter val :");
        Integer v = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter number of children per node");
        Integer n = sc.nextInt(); 
        sc.nextLine();
        Tree t = new Tree(v,n);
        Tree.root=t;

        while(true){
            System.out.println("Add or break?");
            String inp = sc.nextLine();
            if(inp.equals("add")){
                System.out.println("Enter val to add: ");
                Integer value = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter number of children per node");
                Integer nc = sc.nextInt();
                sc.nextLine();
                t.addVal(value,nc); 

                continue;
            }
            else{
                break;
            }
        }
        System.out.println("PreOrder");
        t.preOrder(t);
        System.out.println();
        System.out.println("PostOrder");
        t.postOrder(t);
        System.out.println();
        System.out.println("BFS");
        t.bfs(Tree.root);
        System.out.println();
        System.out.println("DFS");
        t.dfs(Tree.root);
    }
}
