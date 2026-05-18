class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int i = 0;
        for(int num:nums){
           if(map.containsKey(num) && Math.abs(map.get(num)-i) <= k){
                return true;
           }else{
                map.put(num,i);
           }

           i++;
        }

        return false;
    }
}