package dynamicprograms.wordbreakproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakCountCombinations_1 {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("kick");
        dictionary.add("start");
        dictionary.add("kickstart");
        dictionary.add("is");
        dictionary.add("awe");
        dictionary.add("some");
        dictionary.add("awesome");

        String s = "kickstartisawesome";
        System.out.println(wordBreakCount(dictionary,s));
    }

    static int wordBreakCount(List<String> dictionary, String s){
        HashSet<String> dictionarySet = new HashSet<>();
        for(String word : dictionary)
            dictionarySet.add(word);
        ArrayList<String>[] dp = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(dp[i]==null)
                continue;
            for(int j = i+1;j<=s.length();j++){
                String temp = s.substring(i,j);
                if(dictionarySet.contains(temp)){
                    if(dp[j]==null){
                        dp[j]= new ArrayList<>();
                        dp[j].add(temp);
                    }else{
                        dp[j].add(temp);
                    }
                }
            }
        }
        if(dp[s.length()]==null)
            return 0;
        else {
            ArrayList<String> result = new ArrayList<>();
            wordBreak2Helper(dp,"",result,s.length());
            return result.size();
        }
    }

    static void wordBreak2Helper(ArrayList<String>[] dp,String tempString,ArrayList<String> result,int currentIndex){
        if(currentIndex == 0){
            result.add(tempString);
            return;
        }else{
            for(String word : dp[currentIndex]){
                wordBreak2Helper(dp,tempString+" "+word,result,currentIndex-word.length());
            }
        }

    }

}


