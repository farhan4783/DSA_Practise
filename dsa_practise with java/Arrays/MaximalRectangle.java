import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
           
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }

        return maxArea;
    }

    private int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
           
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
