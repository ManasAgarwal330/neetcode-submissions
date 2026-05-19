class Twitter {
    class Pair{
        int idx;
        int elem;
        public Pair(int idx,int elem){
            this.idx = idx;
            this.elem = elem;
        }
    }
    int t = 0;
    HashMap<Integer,PriorityQueue<Pair>> map;
    HashMap<Integer,HashSet<Integer>> followMap;
    public Twitter() {
        map = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(map.containsKey(userId)){
            map.get(userId).add(new Pair(t,tweetId));
        }else{
            map.put(userId,new PriorityQueue<>((a,b) -> Integer.compare(b.idx,a.idx)));
            map.get(userId).add(new Pair(t,tweetId));
        }
        t++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.idx,a.idx));
        if(followMap.containsKey(userId)){
         for(int user: followMap.get(userId)){
            if(map.containsKey(user)){
                for(Pair tweet: map.get(user)){
                    pq.add(tweet);
                }
            }
         }
       }
       if(map.containsKey(userId)){
                for(Pair tweet: map.get(userId)){
                    pq.add(tweet);
                }
            }
        int n= 10;
        while(!pq.isEmpty() && n > 0) {
            list.add(pq.poll().elem);
            n--;
        }

        return list;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).add(followeeId);
        }else{
            followMap.put(followerId,new HashSet<Integer>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
