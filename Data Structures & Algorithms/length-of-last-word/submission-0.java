class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int i = words.length-1;
        while(words[i].isEmpty() && i > 0){
            i--;
        }

        return words[i].length();
    }
}