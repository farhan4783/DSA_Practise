import java.util.*;

class Solution {
    private int[][][] directions = {
        {}, 
        {{0, -1}, {0, 1}}, 
        {{-1, 0}, {1, 0}}, 
        {{0, -1}, {1, 0}}, 
        {{0, 1}, {1, 0}},  
        {{0, -1}, {-1, 0}},
        {{0, 1}, {-1, 0}}  
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            int pipeType = grid[r][c];
            for (int[] dir : directions[pipeType]) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (isBackConnected(nr, nc, r, c, grid)) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    private boolean isBackConnected(int nr, int nc, int pr, int pc, int[][] grid) {
        int nextPipeType = grid[nr][nc];
        for (int[] dir : directions[nextPipeType]) {
            if (nr + dir[0] == pr && nc + dir[1] == pc) {
                return true;
            }
        }
        return false;
    }
}
