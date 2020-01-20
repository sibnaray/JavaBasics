package dynamicprograms.fibonacci;

//There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses.
// The only restriction the thief has is that he can’t steal from two consecutive houses,
// as that would alert the security system. How should the thief maximize his stealing?

//Input: {2, 5, 1, 3, 6, 2, 4}
//Output: 15
//Explanation: The thief should steal from houses 5 + 6 + 4

//Input: {2, 10, 14, 8, 1}
//Output: 18
//Explanation: The thief should steal from houses 10 + 8

public class HouseThief_Recursive {
    public static void main(String[] args) {
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(findMaxSteal(wealth));
    }

    static int findMaxSteal(int[] wealth){
        return findMaxSteal_Recursive(wealth, 0);
    }

    static int findMaxSteal_Recursive(int[] wealth, int currentIndex){
        if(currentIndex > wealth.length-1)
            return 0;

        //if including 'i'th house then we can chose 'i+2' since we cant steal from adjacent house
        int includeHouse = wealth[currentIndex] + findMaxSteal_Recursive(wealth, currentIndex+2);
        int excludeHouse = findMaxSteal_Recursive(wealth, currentIndex+1);

        return Math.max(includeHouse,excludeHouse);
    }
}
