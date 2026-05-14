class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int ans = 0;
        int left= 0;
        int right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            charCount[ch-'A']++;
            int maxIdx = getMaxCount(charCount);
            int totalReplacementRequired = (right-left+1) - charCount[maxIdx];
            if(totalReplacementRequired <= k){
                ans = Math.max(ans,right-left+1);
            }
            else{
                while(totalReplacementRequired > k && left < right){
                    char ch2 = s.charAt(left);
                    charCount[ch2-'A']--;
                    left++;
                    if((ch2-'A') == maxIdx){
                        maxIdx = getMaxCount(charCount);
                    }
                    totalReplacementRequired = (right-left+1) - charCount[maxIdx];
                }
                charCount[ch-'A']--;
                continue;
            }
            right++;
        }

        return ans;

    }

    public int getMaxCount(int[] arr){
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
