class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suf = new int[m + 1];
        
        for (int i = 0; i <= m; i++) {
            suf[i] = -1;
        }
        suf[m] = n;
        
        int p = m - 1;
        for (int i = n - 1; i >= 0 && p >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(p)) {
                suf[p] = i;
                p--;
            }
        }
        
        int[] ans = new int[m];
        boolean changed = false;
        int j = 0;
        
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } else if (!changed && suf[j + 1] != -1 && i < suf[j + 1]) {
                ans[j] = i;
                j++;
                changed = true;
            }
        }
        
        if (j == m) {
            return ans;
        }
        
        return new int[0];
    }
}
