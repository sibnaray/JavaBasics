package dynamicprograms.fibonacci;

//Given an array of positive numbers, where each element represents the max number of jumps that
// can be made forward from that element, write a program to find the minimum number of jumps needed
// to reach the end of the array (starting from the first element). If an element is 0,
// then we cannot move through that element.

//Input = {2,1,1,1,4}
//Output = 3
//Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4

//Input = {1,1,3,6,9,3,0,1,3}
//Output = 4
//Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8

public class MinimumJumpCountToArrayEnd_Recursive {
    public static void main(String[] args) {
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(countMinJumps(jumps));
    }

    static int countMinJumps(int[] jump){
        return countMinJumps_Recursive(jump,0);
    }

    static int countMinJumps_Recursive(int[] jumps, int currentIndex){
        if(currentIndex == jumps.length-1)
            return 0;
        if(currentIndex >= jumps.length || jumps[currentIndex] == 0)
            return Integer.MAX_VALUE;

        int totJump =  Integer.MAX_VALUE;
        int start =  currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];
        while(start < jumps.length && start <= end){
            int minJump = countMinJumps_Recursive(jumps, start++);
            if(minJump != Integer.MAX_VALUE)
                totJump =  Math.min(minJump+1,totJump);
        }
        return totJump;
    }
}
