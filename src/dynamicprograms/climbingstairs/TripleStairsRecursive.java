package dynamicprograms.climbingstairs;

public class TripleStairsRecursive {
    public static void main(String[] args) {
        System.out.println("Ways to climp 3 stairs : "+ tripleStairsRecursvie(3));
        System.out.println("Ways to climp 5 stairs : "+ tripleStairsRecursvie(5));
    }
    public static int tripleStairsRecursvie(int stepsToClimp){
        if(stepsToClimp < 0)
            return 0;
        else if(stepsToClimp == 0)
            return 1;
        else{
            return tripleStairsRecursvie(stepsToClimp-1)
                    + tripleStairsRecursvie(stepsToClimp-2)
                    + tripleStairsRecursvie(stepsToClimp - 3);
        }
    }
}
