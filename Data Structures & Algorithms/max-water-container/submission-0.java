class Solution {
    public int maxArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length-1;

        while(left < right){
            int h1 = heights[left];
            int h2 = heights[right];

            int vol = Math.min(h1,h2) * (right-left);
            ans = Math.max(ans,vol);

            if(h1 < h2){
                left++;
            }else{
                right--;
            }
        }

        return ans;
    }
}
