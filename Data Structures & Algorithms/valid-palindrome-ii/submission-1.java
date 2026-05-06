class Solution {
    boolean lifeline = true;
    boolean isValid = true;
    public boolean validPalindrome(String s) {
        return palindrome(s,0,s.length()-1);
    }

    public boolean palindrome(String s, int left , int right){
        if(left > right)return true;

        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        boolean ans = false;
        if(leftChar != rightChar && lifeline){
            lifeline = false;
            ans |= palindrome(s,left+1,right);
            ans |= palindrome(s,left,right-1);
        }else if(leftChar == rightChar){
            ans |= palindrome(s,left+1,right-1);
        }else{
            return false;
        }

        return ans;
        
    }
}