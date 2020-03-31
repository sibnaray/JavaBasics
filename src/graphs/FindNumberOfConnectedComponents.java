package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNumberOfConnectedComponents {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        int count=0;
        for (int i=0;i<graph.V;i++){
            if(graph.visited[i]==-1){
                count=count+1;
                graph.BFS(i);
            }
        }
        System.out.println("Count : "+count);
    }
}

class Graph{
    int V;
    List<Integer> adjList[];
    int[] visited;
    Graph(){
    }

    public Graph(int V){
        this.V=V;
        visited= new int[V];
        Arrays.fill(visited,-1);
        adjList=new ArrayList[V];
        for(int i=0;i<V;i++)
            adjList[i]=new ArrayList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public void BFS(int source){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source]=1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i:adjList[node]){
                if(visited[i]==-1){
                    queue.add(i);
                    visited[i]=1;
                }
            }
        }
    }
}
