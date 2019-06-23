package HashTables;

import java.util.HashSet;

public class ContainsDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueInt = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(uniqueInt.contains(nums[i])){
                return true;
            }else{
                uniqueInt.add(nums[i]);
            }
        }
        return false;
    }
}
