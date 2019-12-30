package dynamicprograms.robortwalkingboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RobertWalksMazeTopDownMemoization {
    static class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        boolean[][] maze = new boolean[3][3];
        Arrays.fill(maze[0], Boolean.TRUE);
        Arrays.fill(maze[1], Boolean.TRUE);
        Arrays.fill(maze[2], Boolean.TRUE);
        maze[0][2] = false;
        maze[1][1] = false;
        maze[2][0] = false;

        ArrayList<Point> path = getPath(maze);
        if(null != path){
            for (Point p : path) {
                System.out.println(p.row + " " + p.col);
            }
        }else{
            System.out.println("No valid paths");
        }

    }

    static ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null)
            return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if(getPathHelper(maze,maze.length-1,maze[0].length-1,path,failedPoints)){
            return path;
        }
        return null;
    }
    static boolean getPathHelper(boolean[][]maze,int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
        if(col<0 || row <0 || !maze[row][col]){
            return false;
        }

        Point p = new Point(row,col);
        if(failedPoints.contains(p)){
            return false;
        }

        if((col == 0 && row == 0)
                || getPathHelper(maze,row-1,col,path,failedPoints)
                || getPathHelper(maze, row, col-1,path,failedPoints)){
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }
}
