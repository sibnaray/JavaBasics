package dynamicprograms.longestcommonsubstring;
//Given two sequences ‘s1’ and ‘s2’, write a method to find the length of the shortest
// sequence which has ‘s1’ and ‘s2’ as subsequences.
public class ShortestCommonSuperSequence_Recursion {

    public static void main(String[] args) {
        ShortestCommonSuperSequence_Recursion scs = new ShortestCommonSuperSequence_Recursion();
        System.out.println(scs.findSCSLength("abcf", "bdcf"));
        System.out.println(scs.findSCSLength("dynamic", "programming"));
    }

    private int findSCSLength(String str1, String str2){
        return findSCSLength_Rec(str1,str2, 0,0);
    }

    private int findSCSLength_Rec(String str1, String str2, int s1_i, int s2_i){
        if(s1_i == str1.length())
            return str2.length() - s2_i;
        if(s2_i==str2.length())
            return str1.length()- s1_i;

        if(str1.charAt(s1_i)==str2.charAt(s2_i))
            return 1 + findSCSLength_Rec(str1,str2,s1_i+1,s2_i+1);

        int c1 = 1 + findSCSLength_Rec(str1,str2, s1_i+1, s2_i);
        int c2 = 1 + findSCSLength_Rec(str1, str2, s1_i,s2_i+1);

        return Math.min(c1,c2);
    }
}
