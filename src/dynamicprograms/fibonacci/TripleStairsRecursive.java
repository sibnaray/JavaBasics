package dynamicprograms.fibonacci;

public class TripleStairsRecursive {
    public static void main(String[] args) {
        System.out.println("Ways to climp 3 stairs : "+ tripleStairsRecursvie(3));
        System.out.println("Ways to climp 5 stairs : "+ tripleStairsRecursvie(4));
        System.out.println("Ways to climp 5 stairs : "+ tripleStairsRecursvie(5));
    }
    static int tripleStairsRecursvie(int steps){
        if(steps < 0)
            return 0;
        if(steps == 0)
            return 1;
        int count = tripleStairsRecursvie(steps-1)
                + tripleStairsRecursvie(steps-2)
                + tripleStairsRecursvie(steps-3);
        return count;
    }
}
