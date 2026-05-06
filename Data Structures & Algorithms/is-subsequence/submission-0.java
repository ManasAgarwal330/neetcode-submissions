class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while(right < t.length() && left < s.length()){
            char sC = s.charAt(left);
            char tC = t.charAt(right);

            if(sC == tC){
                left++;
                right++;
            }else{
                right++;
            }
        }

        return left >= s.length() ? true : false;
    }
}