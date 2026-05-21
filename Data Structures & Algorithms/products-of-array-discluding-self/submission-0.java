class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            leftToRight[i] = i == 0 ? 1 : leftToRight[i-1]*nums[i-1];
        }

        for(int i=nums.length-1;i>=0;i--){
            rightToLeft[i] = (i == nums.length-1) ? 1 : rightToLeft[i+1]*nums[i+1];
        }
        
        int[] ans = new int[nums.length];
        for(int i = 0;i < ans.length;i++){
            ans[i] = leftToRight[i] * rightToLeft[i];
        }

        return ans;
    }
}  
