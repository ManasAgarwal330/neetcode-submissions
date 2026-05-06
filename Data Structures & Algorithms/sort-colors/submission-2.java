class Solution {
    public void sortColors(int[] nums) {
        int nonZero = 0;
        while(nonZero < nums.length && nums[nonZero] == 0){
            nonZero++;
        }
        int middle = nonZero;
        int nonTwo = nums.length-1;
        while(nonTwo > 0 && nums[nonTwo] == 2 )nonTwo--;

        while(middle <= nonTwo){
            if(nums[middle] == 2){
                nums[middle] = nums[nonTwo];
                nums[nonTwo] = 2;
                nonTwo--;
            }else if(nums[middle] == 0){
                nums[middle] = nums[nonZero];
                nums[nonZero] = 0;
                nonZero++;
                middle++;
            }else{
                middle++;
            }
        }

        return;
    }
}