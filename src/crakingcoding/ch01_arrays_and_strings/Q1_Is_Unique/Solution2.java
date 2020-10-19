package crakingcoding.ch01_arrays_and_strings.Q1_Is_Unique;

//Assumption is only characters from a - z

public class Solution2 {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique_bit_vector(word));
        }
    }

    public static boolean isUnique_bit_vector(String s){
        int checker = 0;
        for(int i = 0 ; i< s.length(); i++){
            int val = s.charAt(i) - 'a';
            if((checker & (1 << val )) > 0){
                return false;
            }else{
                checker |= (1 << val );
            }
        }
        return true;
    }
}
