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
    Tree traverseToAdd(Tree current, Tree element,Integer index) throws Exception{
        if(current.childNodes.size()<childCount && current.childCount!=0){
            current.childNodes.add(element);
            return current;
        }
        else{
            try{
                return traverseToAdd(mainQueue.get(index), element,index+1);
            }
            catch(Exception e){
                throw new Exception("No more space left in tree to add");
            }
        }
    }
    String addVal(Integer v, Integer cc){
        Tree newval = new Tree(v,cc);
        try{
            newval.parent = traverseToAdd(root, newval,0);
            mainQueue.add(newval);
            return "success";
        }
        catch(Exception e){
            System.out.println(e);
            return "failure";
        }
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
    Integer height(Tree r){
        Integer maxh=0;
        for(Tree node : r.childNodes){
            maxh=Math.max(maxh,height(node));
        }
        return maxh+1;
    }
    void deleteNodeAsChild(Tree r,Integer val){
        for(Tree node : r.childNodes){
            if(node.val==val){
                // node.val=null;
                // System.out.println("found child node");
                r.childNodes.remove(node);
                // System.out.println(r.childNodes);
                return;
            }
            deleteNodeAsChild(node, val);
        }
    }
    void delete(Tree r,Integer value){
        if (root.val==value){
            root.val=-1;
            return;
        }
        for(Tree node:root.mainQueue){
            if(node.val==value){
                // node.val=null;
                // System.out.println("found node");
                root.mainQueue.remove(node);
                // System.out.println(root.mainQueue);
                deleteNodeAsChild(root,value);
                return;
            }
        }
        System.out.println("Not Found");

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
                if(t.addVal(value,nc).equals("success")){ 
                    continue;
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        System.out.println("Deleting node");
        t.delete(Tree.root,5);

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
        System.out.println();
        System.out.println("Height: "+t.height(Tree.root));
    }
}
