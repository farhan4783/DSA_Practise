class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0;
        int rCount = 0;
        int underscoreCount = 0;

       
        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                lCount++;
            } else if (move == 'R') {
                rCount++;
            } else {
                underscoreCount++;
            }
        }

        
        return Math.abs(lCount - rCount) + underscoreCount;
    }
}
