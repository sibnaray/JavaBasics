package dynamicprograms.longestcommonsubstring;

import java.util.HashMap;
import com.sun.source.tree.BreakTree;

public class LongestRepeatingSubsequence_TD_Memoization {
    public static void main(String[] args) {
        LongestRepeatingSubsequence_TD_Memoization lrs = new LongestRepeatingSubsequence_TD_Memoization();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }

    int findLRSLength(String str){
        //HashMap<String,Integer> dpMap =  new HashMap<>();
        Integer[][] dpMap = new Integer[str.length()][str.length()];
        return findLRSLength_TD(str, dpMap, 0, 0);
    }

    int findLRSLength_TD(String str, Integer[][] dpMap, int i1, int i2){
        if(i1==str.length() || i2==str.length())
            return 0;
        String key = i1+"|"+i2;
        //if(!dpMap.containsKey(key)){
        if(dpMap[i1][i2] == null){
            if(i1!=i2 && str.charAt(i1) == str.charAt(i2))
                dpMap[i1][i2] = 1 + findLRSLength_TD(str, dpMap,i1+1, i2+1);
                //dpMap.put(key, 1 + findLRSLength_TD(str, dpMap,i1+1, i2+1));
            else{
                int c1 = findLRSLength_TD(str,dpMap, i1+1,i2);
                int c2 = findLRSLength_TD(str, dpMap, i1, i2+1);
                dpMap[i1][i2] = Math.max(c1,c2);
                //dpMap.put(key, Math.max(c1,c2));
            }
        }
        return dpMap[i1][i2];
        //return dpMap.get(key);
    }

}
