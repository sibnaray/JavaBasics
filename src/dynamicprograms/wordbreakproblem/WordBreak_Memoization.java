package dynamicprograms.wordbreakproblem;

import java.util.HashSet;

public class WordBreak_Memoization {
    static HashSet<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        dictionary.add("to");
        dictionary.add("do");
        dictionary.add("todo");

        String s = "totodo";
        System.out.println(wordBreak(s));

    }

    static boolean wordBreak(String s){
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<s.length();i++){
            if(!dp[i])
                continue;
            for(String dw : dictionary){
                int dwl = dw.length();
                int end = i+dwl;
                if(end > s.length())
                    continue;
                if(dp[end])
                    continue;
                if(s.substring(i,end).equals(dw))
                    dp[end]=true;
            }
        }
        return dp[s.length()];
    }
}
