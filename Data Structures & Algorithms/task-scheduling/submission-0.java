class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cycle = 0;
        Queue<int[]> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        int[] ch = new int[26];

        for(int i=0;i<tasks.length;i++){
            ch[tasks[i]-'A']++;
        } 

        for(int i=0;i<ch.length;i++){
            if(ch[i] != 0)
                pq.add(ch[i]);
        }

        int time = 1;
        while(!pq.isEmpty() || !deque.isEmpty()){
            if(!pq.isEmpty())
            {
                int num = pq.poll();
                if(num-1 > 0){
                    deque.add(new int[]{num-1,time+n});
                }
            }
            if(!deque.isEmpty() && deque.peek()[1] == time)
            {
                pq.add(deque.poll()[0]);
            }

            time++;
        }

        return time-1;


    }
}
