class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        long reversed = 0; 

 
        int temp = n;
        while (temp > 0) {
            int lastDigit = temp % 10;
            reversed = reversed * 10 + lastDigit;
            temp /= 10;
        }
        return (int) Math.abs(original - reversed);
    }
}
