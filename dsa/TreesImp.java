package dsa;
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
        t.add(15);
        t.inOrder(Tree.root);
        System.out.println();
        t.preOrder(Tree.root);
        System.out.println();
        t.postOrder(Tree.root);
        System.out.println();
    }
}
