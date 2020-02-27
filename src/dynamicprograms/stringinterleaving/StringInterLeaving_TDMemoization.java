package dynamicprograms.stringinterleaving;

public class StringInterLeaving_TDMemoization {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bcd";
        String s3 = "abcbdc";
        System.out.println(stringInterLeaving(s1,s2,s3));
    }
    static boolean stringInterLeaving(String s1, String s2, String s3){
        int[][] memo= new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                memo[i][j]=-1;
            }
        }
        return stringInterLeavingTDMemo(s1,0,s2,0,s3,0,memo);
    }
    static boolean stringInterLeavingTDMemo(String s1, int s1index, String s2, int s2index, String s3,int s3index, int [][] memo){
        if(s1index == s1.length()){
            return s2.substring(s2index).equals(s3.substring(s3index));
        }
        if(s2index == s2.length()){
            return s1.substring(s1index).equals(s3.substring(s3index));
        }
        if(memo[s1index][s2index]>=0){
            return memo[s1index][s2index]==1 ? true : false;
        }

        boolean ans = false;
        if((s3.charAt(s3index)==s1.charAt(s1index) && stringInterLeavingTDMemo(s1,s1index+1,s2,s2index,s3,s3index+1,memo))
                || (s3.charAt(s3index) == s2.charAt(s2index) && stringInterLeavingTDMemo(s1,s1index,s2,s2index+1,s3,s3index+1,memo))){
            ans = true;
            memo[s1index][s2index] = ans?1:0;
        }
        return ans;
    }
}
