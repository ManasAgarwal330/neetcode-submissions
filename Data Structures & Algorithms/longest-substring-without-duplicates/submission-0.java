class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < s.length())
        {
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch,right);
                ans = Math.max(ans,right-left+1);
            }else{
                int idx = map.get(ch);
                while(left <= idx){
                    char ch2 = s.charAt(left);
                    map.remove(ch2);
                    left++;
                }
                continue;
            }
            right++;
        }

        return ans;
    }
}
