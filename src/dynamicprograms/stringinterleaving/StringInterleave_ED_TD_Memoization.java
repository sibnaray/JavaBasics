package dynamicprograms.stringinterleaving;

import java.util.HashMap;

public class StringInterleave_ED_TD_Memoization {
    public static void main(String[] args) {
        StringInterleave_ED_TD_Memoization si = new StringInterleave_ED_TD_Memoization();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }

    boolean findSI(String str1, String str2, String str3){
        HashMap<String,Boolean> dp = new HashMap<>();
        return findSI_TDMemo(dp,str1, str2, str3, 0, 0,0);
    }

    boolean findSI_TDMemo(HashMap<String,Boolean> dp, String str1, String str2, String str3, int s1_index, int s2_Index, int s3_Index){
        if(s1_index == str1.length() &&  s2_Index == str2.length() && s3_Index == str3.length())
            return true;

        if(s3_Index == str3.length())
            return false;
        String subProbKey = s1_index+"|"+s2_Index+"|"+s3_Index;
        if(!dp.containsKey(subProbKey)){
            boolean b1=false, b2 = false;
            if(s1_index<str1.length() && str1.charAt(s1_index)==str3.charAt(s3_Index))
                b1 = findSI_TDMemo(dp, str1, str2, str3, s1_index+1, s2_Index, s3_Index+1);

            if(s2_Index < str2.length() && str2.charAt(s2_Index) == str3.charAt(s3_Index))
                b2 = findSI_TDMemo(dp, str1, str2, str3, s1_index, s2_Index+1, s3_Index+1);

            dp.put(subProbKey, b1 || b2);
        }
        return dp.get(subProbKey);
    }
}
