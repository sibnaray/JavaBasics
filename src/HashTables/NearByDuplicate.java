package HashTables;

import java.util.HashMap;
import java.util.Map;

public class NearByDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0;i< nums.length; i++){
            if(hashMap.containsKey(nums[i]) && i - hashMap.get(nums[i]) <= k){
                return true;
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return false;
    }
}
