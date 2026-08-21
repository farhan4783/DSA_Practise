import java.util.Arrays;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        
        int minCoin = Arrays.stream(coins).min().getAsInt();
        long high = (long) minCoin * k;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countAmounts(mid, coins) >= k) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }

        return result;
    }

    private long countAmounts(long target, int[] coins) {
        long count = 0;
        int n = coins.length;
        int totalSubsets = 1 << n; 

        
        for (int i = 1; i < totalSubsets; i++) {
            long currentLcm = 1;
            int bitCount = 0;

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins[j]);
                  
                    if (currentLcm > target) {
                        break;
                    }
                }
            }

            if (currentLcm <= target) {
                if (bitCount % 2 == 1) {
                    count += target / currentLcm;
                } else {
                    count -= target / currentLcm;
                }
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }
}
