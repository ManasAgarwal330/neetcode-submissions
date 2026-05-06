class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetter(leftChar) && !Character.isDigit(leftChar)){
                left++;
                continue;
            }
            if(!Character.isLetter(rightChar) && !Character.isDigit(rightChar)){
                right--;
                continue;
            }
            if(Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)){
                left++;
                right--;
            }else{
                return false;
            }
        }

        return true;
    }
}
