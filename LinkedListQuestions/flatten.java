class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        
        Node curr = head;
        while (curr != null) {

            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            
          


            Node nextTemp = curr.next;
            Node childHead = flatten(curr.child);
            
     
            curr.next = childHead;
            childHead.prev = curr;
            curr.child = null;
            
          

            Node tail = childHead;
            while (tail.next != null) {

                tail = tail.next;
            }
            
           

            if (nextTemp != null) {
                tail.next = nextTemp;
                nextTemp.prev = tail;
            }
            
            curr = nextTemp;
        }
        
        return head;
    }
}
