package dynamicprograms.editdistanceORlevenshtein;

public class EditDistance_Recursive_BF {
    public static void main(String[] args) {
        System.out.println(findMinOperations("bat", "but"));
        System.out.println(findMinOperations("abdca", "cbda"));
        System.out.println(findMinOperations("passpot", "ppsspqrt"));
    }

    static int findMinOperations(String s1, String s2){
        return minOperationsHelper(s1,s2,0,0);
    }

    static int minOperationsHelper(String s1, String s2, int s1i, int s2i){
        if(s1i == s1.length()){
            return s2.length() - s2i;
        }
        if(s2i == s2.length()){
            return s1.length() - s1i;
        }
        if(s1.charAt(s1i) == s2.charAt(s2i)){
            return minOperationsHelper(s1,s2,s1i+1,s2i+1);
        }
        int c1 = 1 + minOperationsHelper(s1,s2,s1i+1,s2i);//perform deletion, we are deleting s1i
        int c2 = 1 + minOperationsHelper(s1,s2,s1i,s2i+1);//perform insertion, we need to insert
        int c3 = 1 + minOperationsHelper(s1,s2,s1i+1,s2i+1); // replace
        return Math.min(c1,Math.min(c2,c3));
    }
}
