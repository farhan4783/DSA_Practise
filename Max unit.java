import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
       
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

        
            int take = Math.min(numberOfBoxes, truckSize);
            
            totalUnits += take * unitsPerBox;
            truckSize -= take;

            if (truckSize == 0) break;
        }

        return totalUnits;
    }
}
