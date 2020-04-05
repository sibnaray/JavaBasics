package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph4_GraphIs_ValidTree_DFS {
    public static void main(String[] args) {
        Graph_DFS_CheckingCycle  graph1 = new Graph_DFS_CheckingCycle(5);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(0,3);
        graph1.addEdge(1,4);
        System.out.println("Is valid Tree : "+graph1.isValidTree());

    }
}

class Graph_DFS_CheckingCycle{
    int V;
    List<Integer> adjList[];
    int visited[];
    int parent[];

    Graph_DFS_CheckingCycle(){

    }

    Graph_DFS_CheckingCycle(int V){
        this.V = V;
        adjList = new ArrayList[V];
        for(int i=0;i<V;i++){
            adjList[i]=new ArrayList<>();
        }
        visited = new int[V];
        Arrays.fill(visited,-1);
        parent = new int[V];
        Arrays.fill(parent,-1);
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    boolean isValidTree(){
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

    boolean isCyclePresent(int node){
        visited[node]=1;
        for(int i : adjList[node]){
            if(visited[i]==-1){
                parent[i]=node;
                visited[i]=1;
                if(isCyclePresent(i))
                    return true;
            }else{
                if(parent[node] != i){
                    return true;
                }
            }
        }
        return false;
    }
}
