package crakingcoding.ch01_arrays_and_strings.Q1_Is_Unique;

//First question to ask if its ASCII.. cause ASCII is 128
public class Solution1 {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }

    public static boolean isUnique(String str){
        if(str.length() >128)
            return false;
        boolean[] charset = new boolean[128];
        for(int i=0;i<str.length(); i++){
            int val = str.charAt(i);
            if(charset[val]==false)
                charset[val]=true;
            else
                return false;
        }
        return true;
    }
}

