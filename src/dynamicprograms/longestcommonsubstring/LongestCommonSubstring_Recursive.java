package dynamicprograms.longestcommonsubstring;

//Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.
//Input: s1 = "abdca"
//       s2 = "cbda"
//Output: 2
//Explanation: The longest common substring is "bd".

//Input: s1 = "passport"
//       s2 = "ppsspt"
//Output: 3
//Explanation: The longest common substring is "ssp".

public class LongestCommonSubstring_Recursive {
    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }

    static int findLCSLength(String str1, String str2){
        return findLCSLength_Rec(str1, str2, 0, 0, 0);
    }

    static int findLCSLength_Rec(String str1, String str2, int si1, int si2, int count){
        if(si1 == str1.length() || si2 == str2.length())
            return count;

        if(str1.charAt(si1) == str2.charAt(si2))
            count = findLCSLength_Rec(str1, str2, si1+1, si2+1, count+1);

        int c1 = findLCSLength_Rec(str1, str2, si1+1, si2, 0);
        int c2 = findLCSLength_Rec(str1, str2, si1, si2+1, 0);

        return Math.max(count, Math.max(c1,c2));
    }
}
