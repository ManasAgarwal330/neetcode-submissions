class Solution {
    public String longestCommonPrefix(String[] strs) {
        String lcsAns = strs[0]; 
        for(int i=1;i<strs.length;i++){
            lcsAns = lcs(lcsAns,strs[i]);
            if(lcsAns.isEmpty()){
                return lcsAns;
            }
        }

        return lcsAns;
    }

    public String lcs(String a , String b){
        StringBuilder lcs = new StringBuilder("");

        for(int i=0;i<Math.min(a.length(),b.length());i++){
            char a1 =  a.charAt(i);
            char b1 = b.charAt(i);

            if(a1 == b1){
                lcs.append(a1);
            }else break;
        }

        return lcs.toString();
    }
}