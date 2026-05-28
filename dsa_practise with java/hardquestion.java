class Solution {
    static class Node {
        Node[] child = new Node[26];
        int bestIdx = -1;
        int bestLen = Integer.MAX_VALUE;
    }

    Node root = new Node();

    private void updateBest(Node node, int idx, int len) {
        if (node.bestIdx == -1 || len < node.bestLen || (len == node.bestLen && idx < node.bestIdx)) {
            node.bestIdx = idx;
            node.bestLen = len;
        }
    }

    private void insert(String word, int idx) {
        Node cur = root;
        int len = word.length();
        updateBest(cur, idx, len);
        for (int i = len - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.child[c] == null) cur.child[c] = new Node();
            cur = cur.child[c];
            updateBest(cur, idx, len);
        }
    }

    private int query(String word) {
        Node cur = root;
        int ans = cur.bestIdx;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.child[c] == null) break;
            cur = cur.child[c];
            ans = cur.bestIdx;
        }
        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        int[] res = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            res[i] = query(wordsQuery[i]);
        }
        return res;
    }
}
