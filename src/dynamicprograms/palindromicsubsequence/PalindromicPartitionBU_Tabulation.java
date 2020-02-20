package dynamicprograms.palindromicsubsequence;

//Given a string, we want to cut it into pieces such that each piece is a palindrome.
// Write a function to return the minimum number of cuts needed.
//Input: "abdbca"
//Output: 3
//Explanation: Palindrome pieces are "a", "bdb", "c", "a".

//Input: = "cddpd"
//Output: 2
//Explanation: Palindrome pieces are "c", "d", "dpd".

//Input: = "pqr"
//Output: 2
//Explanation: Palindrome pieces are "p", "q", "r".

public class PalindromicPartitionBU_Tabulation {
    public static void main(String[] args) {
        System.out.println(findPPCuts("abdbca"));
        System.out.println(findPPCuts("cdpdd"));
        System.out.println(findPPCuts("pqr"));
        System.out.println(findPPCuts("pp"));
    }

    static int findPPCuts(String str){
        // isPalindrome[i][j] will be 'true' if the string from index 'i' to index 'j' is a palindrome
        boolean[][] isPalindrome = new boolean[str.length()][str.length()];

        for(int i = 0; i<str.length();i++)
            isPalindrome[i][i]=true;

        for(int startIndex=str.length()-1;startIndex >=0; startIndex--){
            for(int endIndex=startIndex+1;endIndex<=str.length()-1;endIndex++){
                if(str.charAt(startIndex)==str.charAt(endIndex)){
                    // if it's a two character string or if the remaining string is a palindrome too
                    if(endIndex - startIndex == 1 || isPalindrome[startIndex+1][endIndex-1]){
                        isPalindrome[startIndex][endIndex]=true;
                    }
                }
            }
        }

        // now lets populate the second table, every index in 'cuts' stores the minimum cuts needed
        // for the substring from that index till the end
        int[] cuts = new int[str.length()];
        for(int startIndex=str.length()-1;startIndex>=0;startIndex--){
            int minCuts = str.length();
            for(int endIndex=str.length()-1; endIndex>=startIndex; endIndex--){
                // we can cut here as we got a palindrome
                // also we dont need any cut if the whole substring is a palindrome
                if(isPalindrome[startIndex][endIndex]){
                    minCuts = (endIndex == str.length()-1) ? 0:Math.min(minCuts, 1 + cuts[endIndex+1]);
                }
            }
            cuts[startIndex]=minCuts;
        }
        return cuts[0];
    }
}
