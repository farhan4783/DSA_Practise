class Solution {
    static long numberOfWays(long n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long prev2 = 1; 
        long prev1 = 2; 

        for (int i = 3; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

//recursive

class Solution {
    static long numberOfWays(long n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return numberOfWays(n - 1) + numberOfWays(n - 2);
    }
}
