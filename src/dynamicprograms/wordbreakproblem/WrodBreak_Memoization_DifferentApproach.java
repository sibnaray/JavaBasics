package dynamicprograms.wordbreakproblem;

import java.util.Arrays;
import java.util.HashSet;

public class WrodBreak_Memoization_DifferentApproach {
    static HashSet<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        dictionary.add("to");
        dictionary.add("do");
        dictionary.add("todo");

        String s = "totodo";
        System.out.println(wordBreak(s));

    }

    static boolean wordBreak(String s){
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                if(dp[i]!=-1){
                    String sub = s.substring(i, j);
                    if(dictionary.contains(sub))
                        dp[j]=i;
                }
            }
        }
        return dp[s.length()] != -1;
    }
}
