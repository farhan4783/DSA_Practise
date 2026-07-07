class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            sum += digit;
            if (digit != 0) {
                sb.append(c);
            }
        }
        
        long x = sb.length() == 0 ? 0 : Long.parseLong(sb.toString());
        return x * sum;
    }
}
