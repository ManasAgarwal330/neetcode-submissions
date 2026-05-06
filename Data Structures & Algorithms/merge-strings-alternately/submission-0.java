class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left = 0;
        int right = 0;
        boolean turn = true;
        StringBuilder ans = new StringBuilder("");
        while(left < word1.length() && right < word2.length()){
            if(turn){
                ans.append(word1.charAt(left));
                left++;
            }else{
                ans.append(word2.charAt(right));
                right++;
            }
            turn = !turn;
        }

        while(left < word1.length()){
            ans.append(word1.charAt(left));
            left++;
        }

        while(right < word2.length()){
            ans.append(word2.charAt(right));
            right++;
        }

        return ans.toString();
    }
}