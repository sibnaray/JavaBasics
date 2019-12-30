package dynamicprograms.robortwalkingboard;

import java.util.Arrays;

//dp table as below

//true true false 
//true false false 
//true true true 

public class RobertWalksMazeIsValidPathAvailableBottomUp {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[3][3];
        Arrays.fill(maze[0], Boolean.TRUE);
        Arrays.fill(maze[1], Boolean.TRUE);
        Arrays.fill(maze[2], Boolean.TRUE);
        maze[0][2] = false;
        maze[1][1] = false;
        System.out.println(validPathExists(maze));
    }
    static boolean validPathExists(boolean[][] maze){
        boolean[][] dp = new boolean[maze.length][maze[0].length];
        dp[0][0] = true;
        for(int r =0;r<maze.length;r++){
            for(int c=0;c<maze.length;c++){
                if(r == 0){
                    dp[r][c] = maze[r][c];
                }else if(c==0){
                    dp[r][c] = maze[r][c] && dp[r-1][c];
                }else{
                    dp[r][c] = (dp[r-1][c] || dp[r][c-1]) && maze[r][c];
                }
            }
        }
        for(int r =0;r<maze.length;r++) {
            for (int c = 0; c < maze.length; c++) {
                System.out.print(dp[r][c]+" ");
            }
            System.out.println("");
        }
        return dp[maze.length-1][maze[0].length-1];
    }
}
