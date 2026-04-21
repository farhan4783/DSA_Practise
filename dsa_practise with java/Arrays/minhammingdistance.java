import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        
        for (int[] swap : allowedSwaps) {
            int root1 = find(parent, swap[0]);
            int root2 = find(parent, swap[1]);
            if (root1 != root2) parent[root1] = root2;
        }

        
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            groups.computeIfAbsent(root, k -> new HashMap<>()).put(source[i], 
                groups.get(root).getOrDefault(source[i], 0) + 1);
        }

        int hammingDistance = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> countMap = groups.get(root);
            if (countMap.getOrDefault(target[i], 0) > 0) {
                countMap.put(target[i], countMap.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
}
