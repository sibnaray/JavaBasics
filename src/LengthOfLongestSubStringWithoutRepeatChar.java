import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubStringWithoutRepeatChar {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLength=0, i=0, j = 0;
        Set charSet = new HashSet();
        int n = s.length();
        while(i<n && j< n){
            if(charSet.contains(s.charAt(j))){
                charSet = new HashSet();
                i++;
                j=i;
            }else{
                charSet.add(s.charAt(j));
                j++;
            }
            if(maxLength<j-i){
                maxLength = j-i;
            }
        }
        return maxLength;
    }
}
