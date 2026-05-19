class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean inserted = false;
        for(int[] interval: intervals){
            if(interval[0] > newInterval[0] && !inserted){
                list.add(newInterval);
                list.add(interval);
                inserted = true;
            }else{
                list.add(interval);
            }
        }
        if(!inserted) list.add(newInterval);
        List<int[]> ans = mergeInterval(list);
        return ans.toArray(new int[ans.size()][]);
    }

    public List<int[]> mergeInterval(List<int[]> list){
        List<int[]> ans = new ArrayList<>();
        int[] prev = new int[2];
        int idx = 0;
        for(int[] interval: list){
            if(idx == 0){
                prev = interval;
            }else{
                if(prev[1] >= interval[0]){
                    prev[1] = Math.max(prev[1],interval[1]);
                }
                else{
                    ans.add(prev);
                    prev = interval;
                }
            }
            idx++;
        }

        ans.add(prev);

        return ans;
    }
}
