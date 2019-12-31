package dynamicprograms;

public class FindMagicIndex_Recursion {
    //Given a sorted array of distinct integers, write a method to find a magic index if it exists.
    // A magic index is A[i] = i;
    //since sorted QuicksortApproach can be used.

    public static void main(String[] args) {
        int[] array = new int[]{-10,-5,2,2,2,3,4,7,9,12,13};
        findMagicIndex(array);
    }
    static void findMagicIndex(int[] array){
        System.out.println(magicIndexFinder(array,0,array.length));
    }
    static int magicIndexFinder(int[] array, int start, int end){
        if(start>end){
            return -1;
        }
        int midIndex = (start + end)/2;
        int midVal = array[midIndex];

        if(midVal == midIndex){
            return midIndex;
        }
        //Search left min(midIndex -1 OR midVal
        if(midVal < midIndex){
            int leftIndex = Math.min(midIndex-1,midVal);
            int left =  magicIndexFinder(array,start,leftIndex);
            if(left >=0)
                return left;
        }
        //Search left max(midIndex +1 OR midVal
        int righIndex = Math.max(midIndex+1,midVal);
        int right = magicIndexFinder(array,righIndex,end);
        if(right>=0);
        return right;
    }
}
