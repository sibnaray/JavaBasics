package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphImpl {
    int V;
    int[] visited;
    List<Integer> adjListArray[];

    GraphImpl(){}
    GraphImpl(int V){
        this.V=V;
        visited= new int[V+1];
        Arrays.fill(visited,-1);
        adjListArray = new ArrayList[V+1];
        for(int i=0;i<V+1;i++){
            adjListArray[i]=new ArrayList<>();
        }
    }

    void addEdge(int source, int destination){
        adjListArray[source].add(destination);
        adjListArray[destination].add(source);
    }

    void BFS(int source){
        Queue<Integer> queue = new LinkedList<>();
        visited[source]=1;
        queue.add(source);
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);
            for(int neighbour : adjListArray[node]){
                if(visited[neighbour]==-1){
                    visited[neighbour]=1;
                    queue.add(neighbour);
                }
            }
        }
    }

    void DFS(int source){
        visited[source]=1;
        for(int neighbour : adjListArray[source]){
            if(visited[neighbour]==-1){
                visited[neighbour]=1;
                DFS(neighbour);
                System.out.println(neighbour);
            }
        }
    }

    void DFS_Stack(int source){
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source]=1;
        String result = "";
        while(!stack.isEmpty()){
            int node = stack.pop();
            result+=String.valueOf(node);
            for(int neighbour : adjListArray[node]){
                if(visited[neighbour]==-1){
                    visited[neighbour]=1;
                    stack.add(neighbour);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(6);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(3,6);
        System.out.println("Breadth First...");
        //graph.BFS(1);
        Arrays.fill(graph.visited,-1);
        //graph.DFS(1);
        graph.DFS_Stack(1);
    }

}
