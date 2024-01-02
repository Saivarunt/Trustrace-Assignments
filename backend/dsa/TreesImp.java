package dsa;
import java.util.*;

class Tree{
    Integer val;
    Tree left;
    Tree right;
    Tree parent;
    static Tree root;
    Tree(Integer v){
        this.val=v;
        left=null;
        right=null;
        parent=null;
    }
    Tree traverseToAdd(Tree current, Tree element){
        if(current.val<=element.val){
            if(current.right==null){
                current.right=element;
                return current;
            }
            else{
                return traverseToAdd(current.right,element);
            }
        }
        else{
            if(current.left==null){
                current.left=element;
                return current;
            }
            else{
                return traverseToAdd(current.left,element);
            }
        }
    }
    void add(Integer v){
        Tree newval = new Tree(v);
        newval.parent = traverseToAdd(root, newval);
    }
    void inOrder(Tree current){
        if(current==null){
            return;
        }
        inOrder(current.left);
        System.out.print(current.val+" ");
        inOrder(current.right);
    }
    void preOrder(Tree current){
        if(current==null){
            return;
        }
        System.out.print(current.val+" ");
        preOrder(current.left);
        preOrder(current.right);
    }
    void postOrder(Tree current){
        if(current==null){
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.val+" ");
    }
    void bfs(Tree root){
        System.out.print(root.val+" ");
        Queue<Tree> q = new LinkedList<Tree>();
        q.add(root.left);
        q.add(root.right);
        while(q.size()>0){
            Tree popped = q.poll();
            System.out.print(popped.val+" ");
            if(popped.left !=null){
                q.add(popped.left);
            }
            if(popped.right != null){
                q.add(popped.right);
            }
        }
    }
    void find(Tree r,Integer val,Integer ind){
        if(r.val==val){
            System.out.print(val+" ");
            System.out.println();
            System.out.println("Found at :"+ind);
        }
        else if(val<r.val){    
            System.out.print(r.val+" ");        
            find(r.left, val, ind+1);
        }
        else{
            System.out.print(r.val+" ");        
            find(r.right, val, ind+1);
        }
    }
}
public class TreesImp {
    public static void main(String[] args) {
        Tree t= new Tree(10);
        Tree.root=t;
        t.add(5);
        t.add(15);
        t.add(2);
        t.add(7);
        t.add(11);
        t.add(16);
        t.add(6);
        t.add(8);
        System.out.println("In-order");
        t.inOrder(Tree.root);
        System.out.println();
        System.out.println("PreOrder");
        t.preOrder(Tree.root);
        System.out.println();
        System.out.println("PostOrder");
        t.postOrder(Tree.root);
        System.out.println();
        System.out.println("BFS");
        t.bfs(Tree.root);
        System.out.println();
        System.out.println("Find:");
        t.find(t, 8, 0);
    }
}
