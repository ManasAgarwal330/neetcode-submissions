class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder("");
        for(String word:strs){
            s.append(word.length()+"#");
            s.append(word);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> ans = new ArrayList<>();
        int left = 0;
        while(left < str.length()){
            char chr = str.charAt(left);
            int num = 0;
            while(chr != '#')
            {
                num = (num*10)+(chr - '0');
                left++;
                chr = str.charAt(left);
            }
            left++;
            StringBuilder word = new StringBuilder("");
            while(num > 0){
                char ch = str.charAt(left);
                word.append(ch);
                num--;
                left++;
            }
            ans.add(word.toString());
        }

        return ans;
    }
}
