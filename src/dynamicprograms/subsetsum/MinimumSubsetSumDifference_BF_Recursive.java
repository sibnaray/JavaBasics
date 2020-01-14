package dynamicprograms.subsetsum;

public class MinimumSubsetSumDifference_BF_Recursive {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 9};
//        System.out.println(canPartition(num));
//        num = new int[]{1, 2, 7, 1, 5};
//        System.out.println(canPartition(num));
        num = new int[]{1, 2, 4};
        System.out.println(canPartition(num));
    }

    static int canPartition(int[] num){
        return partitionRecursive(num,0,0,0);
    }

    static int partitionRecursive(int[] num, int currentIndex, int S1, int S2){
        System.out.println(currentIndex+" "+S1+" "+S2);
        if(num.length == currentIndex){
            System.out.println(Math.abs(S1-S2));
            return Math.abs(S1-S2);
        }


        //Including num[currentIndex] as part of firstSet and taking diff
        int diff1 = partitionRecursive(num,currentIndex+1,S1+num[currentIndex],S2);

        //Including num[currentIndex] as part of firstSet and taking diff
        int diff2 = partitionRecursive(num,currentIndex+1,S1,S2+num[currentIndex]);

        //returning min difference from above 2
        return Math.min(diff1 , diff2);
    }
}
