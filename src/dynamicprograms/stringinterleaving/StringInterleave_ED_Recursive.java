package dynamicprograms.stringinterleaving;

//The problem follows the Longest Common Subsequence (LCS) pattern and has some similarities with Subsequence Pattern Matching.
//
//A basic brute-force solution could be to try matching ‘m’ and ‘n’ with ‘p’ one letter at a time.
// Let’s assume mIndex, nIndex, and pIndex represent the current indexes of ‘m’, ‘n’, and ‘p’ strings respectively. Therefore, we have two options at any step:
//
//If the letter at mIndex matches with the letter at pIndex,
// we can recursively match for the remaining lengths of ‘m’ and ‘p’.
//If the letter at nIndex matches with the letter at ‘pIndex’,
// we can recursively match for the remaining lengths of ‘n’ and ‘p’.

//Input: m="abd", n="cef", p="abcdef"
//Output: true
//Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.

//Input: m="abd", n="cef", p="adcbef"
//Output: false
//Explanation: 'p' contains all the letters from 'm' and 'n' but does not preserve the order.

//Input: m="abc", n="def", p="abdccf"
//Output: false
//Explanation: 'p' does not contain all the letters from 'm' and 'n'.

//Input: m="abcdef", n="mnop", p="mnaobcdepf"
//Output: true
//Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.

public class StringInterleave_ED_Recursive {
    public static void main(String[] args) {
        StringInterleave_ED_Recursive si = new StringInterleave_ED_Recursive();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }

    boolean findSI(String str1, String str2, String str3){
        return findSIRecursive(str1, str2, str3, 0, 0, 0);
    }

    boolean findSIRecursive(String m, String n, String p, int m_index, int n_index, int p_Index){
        if(m_index == m.length() && n_index==n.length() && p_Index==p.length())
            return true;
        if(p_Index == p.length())
            return false;

        boolean b1=false, b2=false;
        if(m_index < m.length() && m.charAt(m_index) == p.charAt(p_Index))
            b1 = findSIRecursive(m, n, p, m_index+1, n_index,p_Index+1);

        if(n_index < n.length() && n.charAt(n_index) == p.charAt(p_Index))
            b2 = findSIRecursive(m, n, p, m_index, n_index+1, p_Index+1);

        return b1 || b2;
    }
}
