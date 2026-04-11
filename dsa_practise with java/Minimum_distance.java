import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
       

        Map<Integer, int[]> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {

            int val = nums[i];
            
            if (!map.containsKey(val)) {
                

                map.put(val, new int[]{i, -1});
            } else {

                int[] indices = map.get(val);
                int last = indices[0];
                int secondLast = indices[1];

                if (secondLast != -1) {

                    


                    int currentDistance = 2 * (i - secondLast);
                    minDistance = Math.min(minDistance, currentDistance);
                    found = true;
                }

              
                indices[1] = last;
                indices[0] = i;
            }
        }

        return found ? minDistance : -1;
    }
}
