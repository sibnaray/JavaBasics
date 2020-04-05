package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph5_IsGraphBiPartite_DFS {
    public static void main(String[] args) {
        GraphBiPartiteDFS biPartiteGraph = new GraphBiPartiteDFS(4);
        biPartiteGraph.addEdge(0,1);
        biPartiteGraph.addEdge(0,3);
        biPartiteGraph.addEdge(1,2);
        biPartiteGraph.addEdge(2,3);
        System.out.println(biPartiteGraph.isBipartite_DFS());//true

        GraphBiPartiteDFS non_biPartiteGraph = new GraphBiPartiteDFS(4);
        non_biPartiteGraph.addEdge(0,1);
        non_biPartiteGraph.addEdge(0,2);
        non_biPartiteGraph.addEdge(0,3);
        non_biPartiteGraph.addEdge(1,2);
        non_biPartiteGraph.addEdge(2,3);

        System.out.println(non_biPartiteGraph.isBipartite_DFS());//false
    }
}

class GraphBiPartiteDFS{
    int V;
    List<Integer> adjList[];
    int[] visited;
    int[] parent;
    char[] levelLabel;
    GraphBiPartiteDFS(){}
    GraphBiPartiteDFS(int V){
        this.V=V;
        adjList = new ArrayList[V];
        for(int i=0;i<V;i++){
            adjList[i]=new ArrayList<>();
        }
        visited=new int[V];
        Arrays.fill(visited,-1);
        parent= new int[V];
        Arrays.fill(parent,-1);
        levelLabel =new char[V];
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    boolean isBipartite_DFS(){
        for(int i=0;i<V;i++){
            if(visited[i]==-1)
                if(isSameLabel_DFS(i,true))
                    return false;
        }
        return true;
    }

    boolean isSameLabel_DFS(int source, boolean level){
        visited[source]=1;
       if(level)
           levelLabel[source]='R';
       else
           levelLabel[source]='B';
        for(int neighbour:adjList[source]){
            if(visited[neighbour]==-1){
                visited[neighbour]=1;
                parent[neighbour]=source;
                if(isSameLabel_DFS(neighbour,!level))
                    return true;
            }else{
                if(parent[source]!=neighbour)
                    if(levelLabel[source]==levelLabel[neighbour])
                        return true;
            }
        }
        return false;
    }
}
