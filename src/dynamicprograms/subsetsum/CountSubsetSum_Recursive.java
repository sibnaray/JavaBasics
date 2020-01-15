package dynamicprograms.subsetsum;

public class CountSubsetSum_Recursive {

    public static void main(String[] args) {
        int[] num = {1, 1, 2, 3};
        System.out.println(countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubsets(num, 9));
    }

    static int countSubsets(int[] num, int sum){
        return countSubsetRecursive(num,sum,0);
    }

    static int countSubsetRecursive(int[] num, int sum, int currentIndex){
        if(sum ==0)
            return 1;

        if(num.length == 0 || currentIndex >= num.length)
            return 0;

        int count1=0;
        if(sum >= num[currentIndex]){
            //include element
            count1=count1+countSubsetRecursive(num,sum-num[currentIndex],currentIndex+1);
        }
        //exclude
        int count2=0;
        count2 = count2+countSubsetRecursive(num,sum,currentIndex+1);

        return count1 + count2;
    }
}
