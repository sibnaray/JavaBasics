package dynamicprograms.stringinterleaving;

public class StringInterlnterLeavingBruteforce_Recursion {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bcd";
        String s3 = "abcbdc";
        System.out.println(isInterleave(s1,s2,s3));
    }

    static boolean isInterleave(String s1, String s2, String s3){
        return isInterleaveHelper(s1,0,s2,0,s3,"");
    }
    static boolean isInterleaveHelper(String s1, int s1i, String s2, int s2i, String s3 ,String subStr ){
        if(s3.equals(subStr) && s1i == s1.length() && s2i == s2.length()){
            return true;
        }
        boolean ans = false;
        if(s1i<s1.length())
            ans |= isInterleaveHelper(s1,s1i+1,s2,s2i,s3,subStr+s1.charAt(s1i));
        if(s2i<s2.length())
            ans |= isInterleaveHelper(s1,s1i,s2,s2i+1,s3,subStr+s2.charAt(s2i));

        return ans;
    }
}
