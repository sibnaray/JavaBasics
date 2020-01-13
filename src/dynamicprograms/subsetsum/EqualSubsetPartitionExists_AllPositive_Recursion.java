package dynamicprograms.subsetsum;

import java.util.ArrayList;
import java.util.List;

public class EqualSubsetPartitionExists_AllPositive_Recursion {
    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        s.add(10);
        s.add(-3);
        s.add(7);
        s.add(2);
        s.add(1);
        s.add(3);
        System.out.println(canPartition(s));
    }

    static boolean canPartition(List<Integer> s){
        int sum=0;
        for(int i =0;i<s.size();i++){
            sum = sum + s.get(i);
        }
        if(sum % 2 != 0)
            return false;

        return canPartitionRecursive(sum/2, 0, s);
    }

    static boolean canPartitionRecursive(int sum, int currentIndex, List<Integer> s){
        if(sum == 0)
            return true;
        if(s.size()==0 || currentIndex >= s.size())
            return false;

        if(s.get(currentIndex)<=sum) {
            //Include the current element and see if we can obtain sum
            if (canPartitionRecursive(sum - s.get(currentIndex), currentIndex + 1, s))
                return true;
        }
        //Exclude the current element and see if we can obtain sum
        return canPartitionRecursive(sum,currentIndex+1,s);

    }
}
