package dp;

public class ClimbingStairs {

    public int climbStairs(int n) {
        // this is secretly a fibonacci problem: f(n) = f(n-1) + f(n-2)

        // for base cases
        if (n <= 2) return n;

        int firstStep = 1; // this is the number of ways to climb the first step
        int secondStep = 2; // this is the number of ways to climb the second step

        for(int i = 3; i <= n; i++){

            int thirdStep = firstStep + secondStep;
            // Shift pointers forward i.e. sliding
            firstStep = secondStep;
            secondStep = thirdStep;
        }
        return secondStep;
    }

}