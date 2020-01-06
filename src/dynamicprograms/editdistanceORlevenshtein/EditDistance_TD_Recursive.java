package dynamicprograms.editdistanceORlevenshtein;

public class EditDistance_TD_Recursive {
    public static void main(String[] args) {
        System.out.println(findMinOperations("bat", "but"));
        System.out.println(findMinOperations("abdca", "cbda"));
        System.out.println(findMinOperations("passpot", "ppsspqrt"));
    }

    static int findMinOperations(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0;i<=s1.length();i++){
            for(int j = 0 ; j<=s2.length();j++){
                dp[i][j]=-1;
            }
        }
        return minOperationHelper(dp,s1,s2,0,0);
    }

    static int minOperationHelper(int[][] dp,String s1, String s2, int s1i, int s2i){
        if(dp[s1i][s2i] == -1){
            if(s1i == s1.length())
                dp[s1i][s2i] = s2.length() - s2i;
            else if(s2i == s2.length())
                dp[s1i][s2i] = s1.length() - s1i;
            else if(s1.charAt(s1i) == s2.charAt(s2i))
                dp[s1i][s2i]=minOperationHelper(dp,s1,s2,s1i+1,s2i+1);
            else{
                dp[s1i][s2i] = 1 + Math.min(minOperationHelper(dp,s1,s2,s1i+1,s2i),
                        Math.min(minOperationHelper(dp,s1,s2,s1i,s2i+1)
                                ,minOperationHelper(dp,s1,s2,s1i+1,s2i+1)));
            }
        }
        return dp[s1i][s2i];
    }
}
