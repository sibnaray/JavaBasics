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

public class PalindromicPartitionRecursive {
    public static void main(String[] args) {
        System.out.println(findPPCuts("abdbca"));
        System.out.println(findPPCuts("cdpdd"));
        System.out.println(findPPCuts("pqr"));
        System.out.println(findPPCuts("pp"));
    }

    static private boolean isPalindrome(String st, int x, int y) {
        while(x < y) {
            if(st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;
    }

    static int findPPCuts(String str){
        return findPPCuts_Rec(str,0,str.length()-1);
    }

    static int findPPCuts_Rec(String str, int startIndex, int endIndex){
        if(startIndex >=endIndex || isPalindrome(str,startIndex,endIndex))
            return 0;

        int minCuts = endIndex - startIndex;

        for(int i = startIndex; i <= endIndex; i++){
            if(isPalindrome(str,startIndex,i)){
                minCuts=Math.min(minCuts, 1 + findPPCuts_Rec(str,i+1,endIndex));
            }
        }
        return minCuts;
    }
}
