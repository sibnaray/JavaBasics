package dynamicprograms.editdistanceORlevenshtein;

public class EditDistance_BU_DP {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("bat", "but"));
        System.out.println(levenshteinDistance("abdca", "cbda"));
        System.out.println(levenshteinDistance("passpot", "ppsspqrt"));
    }

    static int levenshteinDistance(String strWord1, String strWord2){
        int[][] dp = new int[strWord1.length()+1][strWord2.length()+1];
        for(int i = 0;i<=strWord1.length();i++){
            for(int j = 0 ; j<=strWord2.length();j++){
                dp[i][j]=-1;
            }
        }
        for(int i = 0;i<=strWord1.length();i++) {
            for (int j = 0; j <= strWord2.length(); j++) {
                if(i==0 && j==0)
                    dp[i][j] = 0;
                else if(i==0){
                    dp[i][j] = j;
                }else if(j==0){
                    dp[i][j] = i;
                }else if(strWord1.charAt(i-1)==strWord2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        return dp[strWord1.length()][strWord2.length()];
    }
}
