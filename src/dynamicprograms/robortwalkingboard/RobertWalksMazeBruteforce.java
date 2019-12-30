package dynamicprograms.robortwalkingboard;

import java.util.ArrayList;
import java.util.Arrays;

public class RobertWalksMazeBruteforce {
        static class Point {
            int row;
            int column;

            Point(int row, int column) {
                this.row = row;
                this.column = column;
            }
        }

        public static void main (String[] args){
            boolean[][] maze = new boolean[3][3];
            Arrays.fill(maze[0], Boolean.TRUE);
            Arrays.fill(maze[1], Boolean.TRUE);
            Arrays.fill(maze[2], Boolean.TRUE);
            maze[0][2] = false;
            maze[1][1] = false;

            ArrayList<Point> path = getPath(maze);
            for (Point p : path) {
                System.out.println(p.row + " " + p.column);
            }
        }

        static ArrayList<Point> getPath ( boolean[][] maze){
            if (maze == null)
                return null;
            ArrayList<Point> path = new ArrayList<>();
            if (getPathHelper(maze, maze.length - 1, maze[0].length - 1, path))
                return path;
            return null;
        }

        static boolean getPathHelper ( boolean[][] maze, int row, int col, ArrayList<Point > path){
            if (row < 0 || col < 0 || !maze[row][col])
                return false;
            if ((row == 0 && col == 0)
                || getPathHelper(maze, row - 1, col, path)
                || getPathHelper(maze, row, col - 1, path)) {
                path.add(new Point(row, col));
                return true;
            }
            return false;
        }
}
