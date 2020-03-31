package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//A tree is a Graph with no cycles and only one connected component.
public class Graph4_GraphIs_ValidTree_BFS {
    public static void main(String[] args) {
        Graph_BFS_CheckingCycle  graph1 = new Graph_BFS_CheckingCycle(5);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(0,3);
        graph1.addEdge(1,4);
        System.out.println("Is valid Tree : "+graph1.isValidTree());

    }
}

class Graph_BFS_CheckingCycle{
    int V;
    List<Integer> adjList[];
    int[] visited;
    int[] parent;
    Graph_BFS_CheckingCycle(){
    }

    public Graph_BFS_CheckingCycle(int V){
        this.V=V;
        visited= new int[V];
        parent = new int[V];
        Arrays.fill(visited,-1);
        Arrays.fill(parent,-1);
        adjList=new ArrayList[V];
        for(int i=0;i<V;i++)
            adjList[i]=new ArrayList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public boolean isValidTree(){
        int component = 0;
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                component++;
                if(component >=2)
                    return false;
                else{
                    if(isCyclePresent(i)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isCyclePresent(int source){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source]=1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i : adjList[node]){
                if(visited[i]==-1){
                    queue.add(i);
                    visited[i]=1;
                    parent[i]=node;
                }else{
                    if(parent[node] != i)
                        return true;
                }
            }
        }
        return false;
    }
}
