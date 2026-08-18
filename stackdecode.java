class Solution {
    private int ptr = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;

        while (ptr < s.length()) {
            char ch = s.charAt(ptr);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
                ptr++;
            } else if (ch == '[') {
                ptr++;
                String sub = decodeString(s);
                while (k > 0) {
                    sb.append(sub);
                    k--;
                }
            } else if (ch == ']') {
                ptr++;
                return sb.toString();
            } else {
                sb.append(ch);
                ptr++;
            }
        }

        return sb.toString();
    }
}
