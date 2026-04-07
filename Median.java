import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    private PriorityQueue<Integer> small; 
    private PriorityQueue<Integer> large; 

    public MedianFinder() {
        



        small = new PriorityQueue<>(Collections.reverseOrder());
       


        large = new PriorityQueue<>();



    }
    
    public void addNum(int num) {
        


        small.offer(num);
        
        


        large.offer(small.poll());
        
        


        if (small.size() < large.size()) {


            small.offer(large.poll());


        }
    }
    
    public double findMedian() {

        if (small.size() > large.size()) {

            return (double) small.peek();

        } else {


            return (small.peek() + large.peek()) / 2.0;








        }




        
    }
}
