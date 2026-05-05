class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String sorted =  new String(a);
            List<String> list  = map.getOrDefault(sorted,new ArrayList<>());
            list.add(strs[i]);
            map.put(sorted,list);
        }

       List<List<String>> ans = new ArrayList<>(map.values());

        return ans;
    }
}
