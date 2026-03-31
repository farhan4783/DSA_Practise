class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        char[] ans = new char[n + m - 1];
        
        
        for (int i = 0; i < ans.length; i++) {
            ans[i] = '?';
        }
        
        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] == '?' || ans[i + j] == str2.charAt(j)) {
                        ans[i + j] = str2.charAt(j);
                    } else {
                        return ""; 
                    }
                }
            }
        }
        
        
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') ans[i] = 'a';
        }
        
        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                
                if (match) {
                    
                    boolean changed = false;
                    
                    for (int j = m - 1; j >= 0; j--) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != ans[i + j]) {
                                char old = ans[i + j];
                                ans[i + j] = c;
                                
                                
                                boolean valid = true;
                                for (int k = 0; k < n; k++) {
                                    if (str1.charAt(k) == 'T') {
                                        for (int x = 0; x < m; x++) {
                                            if (ans[k + x] != str2.charAt(x)) {
                                                valid = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!valid) break;
                                }
                                
                                if (valid) {
                                    changed = true;
                                    break;
                                }
                                
                                ans[i + j] = old;
                            }
                        }
                        if (changed) break;
                    }
                    
                    if (!changed) return "";
                }
            }
        }
        
        return new String(ans);
    }
}
