//task schedular optimized



import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
       
        int[] freq = new int[26];

        for (char task : tasks) {

            freq[task - 'A']++;

        }

       
        Arrays.sort(freq);
        int fMax = freq[25];

       
        int nMax = 0;
        for (int i = 25; i >= 0; i--) {




            if (freq[i] == fMax) {


                nMax++;
            } else {
                break;
            }
        }

       
        int totalTime = (fMax - 1) * (n + 1) + nMax;



        

        
        return Math.max(totalTime, tasks.length);



    }
}
