class Solution {
    class Pair{
        int key;
        int occurence;
        public Pair(int key,int occurence){
            this.key = key;
            this.occurence = occurence;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.occurence,b.occurence));
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key:map.keySet()){
            int val = map.get(key);
            if(minHeap.size() < k){
                minHeap.add(new Pair(key,val));
            }else{
                if(minHeap.peek().occurence < val){
                    minHeap.poll();
                    minHeap.add(new Pair(key,val));
                }
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            ans[i] = minHeap.poll().key;
            i++;
        }

        return ans;
    }
}
