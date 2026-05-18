class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K = k;
        for(int num: nums)
        {
            if(pq.size() < k){
                pq.add(num);
            }else{
                if(pq.peek() < num){
                    pq.poll();
                    pq.add(num);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < K){
                pq.add(val);
        }else{
            if(pq.peek() < val){
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
