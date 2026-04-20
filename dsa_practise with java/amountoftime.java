import java.util.*;

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        buildGraph(root, null, adj);

      
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(start);
        visited.add(start);
        
        int minutes = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            minutes++;
        }

        return minutes;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> adj) {
        if (node == null) return;
        
        adj.putIfAbsent(node.val, new ArrayList<>());
        if (parent != null) {
            adj.get(node.val).add(parent.val);
            adj.get(parent.val).add(node.val);
        }
        
        buildGraph(node.left, node, adj);
        buildGraph(node.right, node, adj);
    }
}
