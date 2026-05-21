class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums,int left,int right){
        if(left >= right) return;
        
        int mid = (left+right)/2;

        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        merge(nums, left,mid,right);
    }

    public void merge(int[] nums, int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int[] ans = new int[right-left+1];
        int k = 0;
        while(i  <= mid && j <= right){
            if(nums[i] < nums[j]){
                ans[k] = nums[i];
                i++;
            }else{
                ans[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            ans[k] = nums[i];
            i++;
            k++;
        }

        while(j <= right){
            ans[k] = nums[j];
            j++;
            k++;
        }

        for(int m = 0;m <= ans.length-1 ; m++){
            nums[left] = ans[m];
            left++;
        }
    }
}