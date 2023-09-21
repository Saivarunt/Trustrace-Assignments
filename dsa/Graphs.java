package dsa;

import java.util.*;

class Graph{
    Integer val;
    static ArrayList<Graph> mainList = new ArrayList<>();
    ArrayList<Graph> nextNodes = new ArrayList<>();
    Boolean visited =false;
    Graph(){

    }
    Graph(Integer value){
        this.val=value;
    }
    void addNode(Integer value, ArrayList<Integer> parent){
        Graph node = new Graph(value);
        if(parent.size()!=0){
            for(Graph n:mainList){
                // System.out.println("Inside add loop 1");
                for(Integer par :parent){
                    // System.out.println("Inside add loop 2");
                    if(n.val==par){
                        n.nextNodes.add(node);
                        break;
                    }
                }

            }
        }
        mainList.add(node);
    }

    void bfs(Graph node){
        if(node.visited==false){
            System.out.print(node.val+" ");
            node.visited=true;
        }

        ArrayList<Graph> g= new ArrayList<>();
        g.addAll(node.nextNodes);

        while(g.size()>0){
            Graph popped = g.remove(0);
            if(popped.visited==false){
                System.out.print(popped.val+" ");
                popped.visited=true;
                if(popped.nextNodes.size()>0){
                    g.addAll(popped.nextNodes);
                }
            }
        }

        for(Graph visnode:Graph.mainList){
            visnode.visited=false;
        }
    }
    void dfs(Graph node){
        if(node.visited==false){
            System.out.print(node.val+" ");
            node.visited=true;
        }

        Stack<Graph> g= new Stack<>();
        g.addAll(node.nextNodes);

        while(g.size()>0){
            Graph popped = g.pop();
            if(popped.visited==false){
                System.out.print(popped.val+" ");
                popped.visited=true;
                Integer ind=0;
                while(popped.nextNodes.size()>0 && ind<popped.nextNodes.size()){
                    g.push(popped.nextNodes.get(ind));
                    ind+=1;
                }
            }
        }

        for(Graph visnode:Graph.mainList){
            visnode.visited=false;
        }
    }
}
public class Graphs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph obj = new Graph();

        System.out.println("Enter node val");
        Integer v = sc.nextInt();
        sc.nextLine();

        obj.addNode(v, new ArrayList<Integer>());
        while(true){
            System.out.println("Add or break?");
            String choice = sc.nextLine();
            if(choice.equals("add")){
                System.out.println("Enter node val");
                v = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter number of parents");
                Integer non =sc.nextInt();
                sc.nextLine();
                
                System.out.println("Enter parent ");
                ArrayList<Integer> parents=new ArrayList<>();
                for(Integer i=0;i<non;i++){
                    Integer p = sc.nextInt();
                    sc.nextLine();
                    Integer f=0;
                    for(Graph mnodes:Graph.mainList){
                        if(mnodes.val==p){
                            f=1;
                        }
                    }
                    if(f==1){
                        parents.add(p);
                    }
                    else{
                        System.out.println("Parent not in Graph enter valid parent");
                        break;
                    }
                }
                obj.addNode(v, parents);
                continue;
            }
            else{
                break;
            }
        }
        // System.out.println("Nodes:");
        // for(Graph mainnodes: Graph.mainList){
        //     System.out.print(mainnodes.val+" ");
        // }
        System.out.println();
        obj.bfs(Graph.mainList.get(0));
        System.out.println();
        obj.dfs(Graph.mainList.get(0));
    }
}
