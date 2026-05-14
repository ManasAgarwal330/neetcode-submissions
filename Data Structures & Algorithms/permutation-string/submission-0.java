class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] originalArr = new int[26];
        for(char ch:s1.toCharArray()){
            originalArr[ch-'a']++;
        }

        int[] countArr = originalArr.clone();
        int left =0 ;
        int right = 0;
        while(right < s2.length()){
            char ch = s2.charAt(right);
            countArr[ch-'a']--;
            if(check(countArr))
            {
                return true;
            }

            if(countArr[ch-'a'] < 0){
                while(countArr[ch-'a'] < 0){
                    char ch2 = s2.charAt(left);
                    countArr[ch2-'a']++;
                    left++;
                }
            }
            right++;
        }

        return false;
    }

    public boolean check(int[] arr){
        for(int i=0;i<26;i++){
            if(arr[i] != 0)return false;
        }

        return true;
    }   
}
