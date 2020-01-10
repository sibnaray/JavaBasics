package dynamicprograms.wordbreakproblem;

import java.util.HashSet;

public class WordBreak_Recursive {
    static HashSet<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        dictionary.add("to");
        dictionary.add("do");
        dictionary.add("todo");

        String s = "totodo";
        System.out.println(wordBreakHelper(s,0));

    }

    static boolean wordBreakHelper(String str, int start){
        if(start == str.length())
            return true;
        for(String dw : dictionary){
            int dwl = dw.length();
            int end = start+dwl;
            if(end > str.length())
                continue;
            if(str.substring(start,end).equals(dw)){
                if(wordBreakHelper(str,end))
                    return true;
            }
        }
        return false;
    }

}
