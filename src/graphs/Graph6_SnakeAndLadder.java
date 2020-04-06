package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Model should be that Snake or Ladder should be put as a hashmap, or in effect the landing vertice of a vertice.
public class Graph6_SnakeAndLadder {
   public static HashMap<Integer,Integer> SnakeAndLadderMap = new HashMap<Integer, Integer>();
    static{
        for(int i=1;i<=100;i++)
            SnakeAndLadderMap.put(i,i);
        SnakeAndLadderMap.put(1,38); //ladder, this means if you land in 1 you go to 38
        SnakeAndLadderMap.put(4,14);
        SnakeAndLadderMap.put(9,31);
        SnakeAndLadderMap.put(17,7);//snake, if you land here you end up in 7
        SnakeAndLadderMap.put(21,42);
        SnakeAndLadderMap.put(28,84);
        SnakeAndLadderMap.put(51,67);
        SnakeAndLadderMap.put(54,34);
        SnakeAndLadderMap.put(62,19);
        SnakeAndLadderMap.put(64,60);
        SnakeAndLadderMap.put(72,91);
        SnakeAndLadderMap.put(80,99);
        SnakeAndLadderMap.put(87,36);
        SnakeAndLadderMap.put(93,73);
        SnakeAndLadderMap.put(95,75);
        SnakeAndLadderMap.put(98,79);
    }

    public static void main(String[] args) {
        SnakeAndLadderGraph snakeAndLadderGraph = new SnakeAndLadderGraph(101,SnakeAndLadderMap);
        System.out.println(snakeAndLadderGraph.getLeastNoOfDiceThrow(0));
    }
}

class SnakeAndLadderGraph{
    int V;
    List<Integer> adjList[];
    int[] parent ;
    int[] visited;
    int[] distance;

    SnakeAndLadderGraph(){}
    SnakeAndLadderGraph(int V,HashMap<Integer,Integer> SnakeAndLadderMap){
        this.V=V;
        adjList=new ArrayList[V];
        for(int ver=0;ver<V;ver++){
            adjList[ver]=new ArrayList<>();
            //every vertice has 6 vertice it can land in.
            for(int dice=1;dice<=6;dice++){
                if(ver+dice <=100){
                    adjList[ver].add(SnakeAndLadderMap.get(ver+dice)); //7
                }
            }
        }
        visited=new int[V];
        Arrays.fill(visited,-1);
        distance=new int[V];
        Arrays.fill(distance,-1);
    }

    int getLeastNoOfDiceThrow(int source){
        visited[source]=1;
        distance[source]=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int ver=queue.poll();
            for(int nextVer:adjList[ver]){
                if(visited[nextVer]==-1){
                    visited[nextVer]=1;
                    distance[nextVer]=distance[ver]+1;
                    queue.add(nextVer);
                }
            }
        }
        return distance[100];
    }

}


