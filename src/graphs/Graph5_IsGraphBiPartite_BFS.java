package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Leetcode 785 886

//Even length cycles
//No cross edge at same level
//cross edge at different level in BFS
public class Graph5_IsGraphBiPartite_BFS {
    public static void main(String[] args) {
        GraphBiPartiteBFS biPartiteGraph = new GraphBiPartiteBFS(4);
        biPartiteGraph.addEdge(0,1);
        biPartiteGraph.addEdge(0,3);
        biPartiteGraph.addEdge(1,2);
        biPartiteGraph.addEdge(2,3);
        System.out.println(biPartiteGraph.isBipartite_BFS());//true

        GraphBiPartiteBFS non_biPartiteGraph = new GraphBiPartiteBFS(4);
        non_biPartiteGraph.addEdge(0,1);
        non_biPartiteGraph.addEdge(0,2);
        non_biPartiteGraph.addEdge(0,3);
        non_biPartiteGraph.addEdge(1,2);
        non_biPartiteGraph.addEdge(2,3);

        System.out.println(non_biPartiteGraph.isBipartite_BFS());//false
    }

}

class GraphBiPartiteBFS{
    int V;
    List<Integer> adjList[];
    int[] visited;
    int[] parent;
    int[] level;

    GraphBiPartiteBFS(){}
    GraphBiPartiteBFS(int V){
        this.V = V;
        adjList=new ArrayList[V];
        for(int i=0;i<V;i++){
            adjList[i]=new ArrayList<>();
        }
        visited=new int[V];
        Arrays.fill(visited,-1);
        parent=new int[V];
        Arrays.fill(parent,-1);
        level=new int[V];
        Arrays.fill(level,-1);
    }

    void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    boolean isBipartite_BFS(){
        for(int i=0;i<V;i++){
            if(visited[i]==-1)
                if(isSameLevelCrossEdge(i))
                    return false;
        }
        return true;
    }

    boolean isSameLevelCrossEdge(int source){
        visited[source]=1;
        level[source]=0;
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbour:adjList[node]){
                if(visited[neighbour]==-1){
                    visited[neighbour]=1;
                    parent[neighbour]=node;
                    level[neighbour]=level[node]+1;
                    queue.add(neighbour);
                }else{
                    if(parent[node]!=neighbour)
                        if(level[node]==level[neighbour])
                            return true;
                }
            }
        }
        return false;
    }


}
