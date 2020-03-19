package dynamicprograms.longestcommonsubstring;

//Given a string and a pattern, write a method to count the number of times the pattern appears in the string as a subsequence.
//
//Example 1: Input: string: “baxmx”, pattern: “ax”
//Output: 2
//Explanation: {baxmx, baxmx}.
//
//Example 2:
//
//Input: string: “tomorrow”, pattern: “tor”
//Output: 4
//Explanation: Following are the four occurences: {tomorrow, tomorrow, tomorrow, tomorrow}.

//We can match the pattern with the given string one character at a time, so we can do two things at any step:
//1) If the pattern has a matching character with the string, we can recursively match for the remaining lengths of the pattern and the string.
//2)At every step, we can always skip a character from the string to try to match the remaining string with the pattern.
// So we can start a recursive call by skipping one character from the string.

public class SubsequencePatternMatchingCount_Rec {

    public static void main(String[] args) {
        SubsequencePatternMatchingCount_Rec spm = new SubsequencePatternMatchingCount_Rec();
        System.out.println(spm.findSPMCount("baxmx", "ax"));
        System.out.println(spm.findSPMCount("tomorrow", "tor"));
    }

    int findSPMCount(String str, String pat){
        return findSPMCount_Rec(str,pat,0,0);
    }

    int findSPMCount_Rec(String str, String pat, int str_i, int pat_i){
        if(pat.length() == pat_i)
            return 1;
        if(str.length() == str_i)
            return 0;

        //if matching match for next char in pattern
        int c1 = 0;
        if(str.charAt(str_i)==pat.charAt(pat_i))
            c1 = findSPMCount_Rec(str,pat, str_i+1,pat_i+1);

        //increment string index to match patterns again
        int c2 = findSPMCount_Rec(str, pat, str_i+1, pat_i);

        return c1 + c2;
    }
}
