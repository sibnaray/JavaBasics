import java.util.HashMap;

public class LengthOfLongestSubStringWithoutRepeatChar_2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abac"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int max1=0;
        int max2=0;
        int startIndex=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
                if(map.containsKey(s.charAt(i))){
                    startIndex = startIndex<=map.get(c)+1 ? map.get(c)+1 : startIndex;
                    max1 = max1 <= i+1 - startIndex ? i+1 - startIndex : max1;
                    map.put(c,i);
                    System.out.println(c+" i : "+i +" startIndex "+startIndex+" max1 : "+max1+" max2 : "+max2);

                }else{
                    map.put(c,i);
                    max2= max2<= i+1-startIndex ? i+1-startIndex : max2 ;
                    System.out.println(c+" i : "+i +" startIndex "+startIndex+" max1 : "+max1+" max2 : "+max2);
                }
        }
        return Math.max(max1,max2);
    }
}
