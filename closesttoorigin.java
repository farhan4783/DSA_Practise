import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

      
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {

            pq.offer(point);

            if (pq.size() > k) {

                pq.poll(); 

            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {

            result[i++] = pq.poll();
        
        }

        return result;
    }
}


// this



import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSelect(int[][] points, int left, int right, int k) {

        if (left >= right) return;

        int pivotIndex = partition(points, left, right);

        if (pivotIndex == k) return;
        else if (pivotIndex < k) {
            quickSelect(points, pivotIndex + 1, right, k);
        } else {
            quickSelect(points, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[][] points, int left, int right) {

        int[] pivot = points[right];
        int pivotDist = dist(pivot);

        int i = left;

        for (int j = left; j < right; j++) {
            if (dist(points[j]) <= pivotDist) {
                swap(points, i, j);
                i++;
            }
        }

        swap(points, i, right);
        return i;
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
