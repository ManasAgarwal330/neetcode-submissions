class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int num: nums){
            map.put(num,1);
        }

        for(int num: nums){
            if(!map.containsKey(num-1)){
                int len = 1;
                while(map.containsKey(num+1)){
                    len++;
                    num++;
                }
                ans = Math.max(ans,len);
            }
        }

        return ans;
    }
}
