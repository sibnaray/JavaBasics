/**
 * Given different dimensions and unlimited supply of boxes for each dimension, stack boxes
 * on top of each other such that it has maximum height but with caveat that length and width
 * of box on top should be strictly less than length and width of box under it. You can
 * rotate boxes as you like.
 * 
 * 1) Create all rotations of boxes such that length is always greater or equal to width
 * 2) Sort boxes by base area in non increasing order (length * width). This is because box
 * with more area will never ever go on top of box with less area.
 * 3) Take T[] and result[] array of same size as total boxes after all rotations are done
 * 4) Apply longest increasing subsequence type of algorithm to get max height.
 * 
 * If n number of dimensions are given total boxes after rotation will be 3n.
 * So space complexity is O(n)
 * Time complexity - O(nlogn) to sort boxes. O(n^2) to apply DP on it So really O(n^2)
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
 * http://people.cs.clemson.edu/~bcdean/dp_practice/
 */
 
 package dynamicprograms;

import java.util.Arrays;

public class BoxStackingForMaximumHeight {
    public static void main(String[] args){
        BoxStackingForMaximumHeight BSMH = new BoxStackingForMaximumHeight();
        BoxDimensions[] input = {new BoxDimensions(3,2,5), new BoxDimensions(1,2,4)};
        System.out.println(BSMH.getMaxHeight(input));
    }

    public void createAllRotations(BoxDimensions[] input, BoxDimensions[] allRotations){
        int index=0;
        for(int i=0;i<input.length;i++){
            allRotations[index++] = BoxDimensions.createDimensions(input[i].length,input[i].breadth,input[i].height);
            allRotations[index++] = BoxDimensions.createDimensions(input[i].breadth,input[i].height,input[i].length);
            allRotations[index++] = BoxDimensions.createDimensions(input[i].height,input[i].length,input[i].breadth);
        }
    }

    public int getMaxHeight(BoxDimensions[] input){
        BoxDimensions[] allRotations = new BoxDimensions[input.length * 3];
        createAllRotations(input,allRotations);
        Arrays.sort(allRotations);

        int[] dp = new int[allRotations.length];
        for(int i=0;i<allRotations.length;i++)
            dp[i]=allRotations[i].height;

        for(int i=1;i<allRotations.length;i++){
            for(int j=0;j<i;j++){
                if(allRotations[i].length < allRotations[j].length
                && allRotations[i].breadth < allRotations[j].breadth){
                    if(dp[j] + allRotations[i].height > dp[i]){
                        dp[i] = dp[j] + allRotations[i].height;
                    }
                }
            }
        }
        return dp[allRotations.length-1];
    }
}

class BoxDimensions implements Comparable<BoxDimensions>{
    int length;
    int breadth;
    int height;

    public BoxDimensions(){
    }

    public BoxDimensions(int length, int breadth, int height){
        this.length = length;
        this.height = height;
        this.breadth = breadth;
    }

    static BoxDimensions createDimensions(int side1, int side2, int height){
        BoxDimensions  bd = new BoxDimensions();
        bd.height = height;
        if(side1 >= side2){
            bd.length = side1;
            bd.breadth = side2;
        }else{
            bd.length=side2;
            bd.breadth=side1;
        }
        return bd;
    }

    @Override
    public int compareTo(final BoxDimensions o) {
        if(this.length * this.breadth >= o.length*o.breadth)
            return -1;
        else
            return 1;
    }
}
