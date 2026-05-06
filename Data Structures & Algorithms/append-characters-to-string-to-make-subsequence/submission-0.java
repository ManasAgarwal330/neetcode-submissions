class Solution {
    public int appendCharacters(String s, String t) {
        int left = 0;
        int right = 0;

        while(left < s.length() && right < t.length() ){
            char sC = s.charAt(left);
            char tC = t.charAt(right);

            if(sC == tC){
                left++;
                right++;
            }else{
                left++;
            }
        }

        return right == t.length() ? 0 : (t.length() - right);
    }
}