class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> a = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i != 0 && nums[i] == nums[i-1])continue;
            int target = 0 - nums[i];
            List<List<Integer>> ans = twoSum(nums,i+1,nums.length-1,target);
            for(List<Integer> b: ans){
                b.add(nums[i]);
                a.add(b);
            }
        }

        return a;
    }

    public List<List<Integer>> twoSum(int[] nums,int left,int right,int target){
        List<List<Integer>> a = new ArrayList<>();
        while(left < right){
            int leftVal = nums[left];
            int rightVal = nums[right];

            if(leftVal+rightVal < target){
                left++;
            }else if(leftVal + rightVal > target){
                right--;
            }else{
                List<Integer> newList = new ArrayList<>();
                newList.add(leftVal);
                newList.add(rightVal);
                a.add(newList);
                left++;
                right--;
                while(left != 0 && left<right && nums[left] == nums[left-1])left++;
                while(right != nums.length-1 && right > left && nums[right] == nums[right+1])right--;
            }
        }
        return a;
    }
}
