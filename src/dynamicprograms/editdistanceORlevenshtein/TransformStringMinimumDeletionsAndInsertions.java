package dynamicprograms.longestcommonsubstring;

//Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters.
// Write a function to calculate the count of the minimum number of deletion and insertion operations.

//Input: s1 = "abc"
//       s2 = "fbc"
//Output: 1 deletion and 1 insertion.
//Explanation: We need to delete {'a'} and insert {'f'} to s1 to transform it into s2.

//Input: s1 = "abdca"
//       s2 = "cbda"
//Output: 2 deletions and 1 insertion.
//Explanation: We need to delete {'a', 'c'} and insert {'c'} to s1 to transform it into s2

//Input: s1 = "passport"
//       s2 = "ppsspt"
//Output: 3 deletions and 1 insertion
//Explanation: We need to delete {'a', 'o', 'r'} and insert {'p'} to s1 to transform it into s2.

//solution:
//This problem can easily be converted to the Longest Common Subsequence (LCS).
// If we can find the LCS of the two input strings, we can easily find how many characters we need to insert and delete from s1. Here is how we can do this:
//
//Let’s assume len1 is the length of s1 and len2 is the length of s2.
//Now let’s assume c1 is the length of LCS of the two strings s1 and s2.
//To transform s1 into s2, we need to delete everything from s1 which is not part of LCS,
// so minimum deletions we need to perform from s1 => len1 - c1
//Similarly, we need to insert everything in s1 which is present in s2 but not part of LCS,
// so minimum insertions we need to perform in s1 => len2 - c1

public class TransformStringMinimumDeletionsAndInsertions {

    public static void main(String[] args) {
        findMDI("abc", "fbc");
        findMDI("abdca", "cbda");
        findMDI("passport", "ppsspt");
    }
    public static void findMDI(String s1, String s2) {
        int c1 = findLCSLength(s1, s2);
        System.out.println("Minimum deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum insertions needed: " + (s2.length() - c1));
    }

    static int findLCSLength(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i1=1;i1<=s1.length();i1++){
            for(int i2=1;i2<=s2.length();i2++){
                if(s1.charAt(i1-1) == s2.charAt(i2-1))
                   dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else{
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
