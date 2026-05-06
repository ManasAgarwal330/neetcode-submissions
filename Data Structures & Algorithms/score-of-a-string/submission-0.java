class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for(int i=1;i<s.length();i++){
            char prev = s.charAt(i-1);
            char cur = s.charAt(i);

            score += Math.abs(cur - prev);
        }

        return score;
    }
}