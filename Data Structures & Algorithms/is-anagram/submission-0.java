class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chArr = new int[26];

        for(char ch: s.toCharArray()){
            chArr[ch-'a']++;
        }

        for(char ch: t.toCharArray()){
            chArr[ch-'a']--;
        }

        for(int n:chArr){
            if(n != 0)return false;
        }

        return true;
    }
}
