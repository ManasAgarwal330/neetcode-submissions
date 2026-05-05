class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(int num: nums){
            map.put(num , map.getOrDefault(num,0)+1);

            if(map.get(num) > nums.length/2){
                ans = num;
                break;
            }

        }

        return ans;
    }
}