class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right =  Arrays.stream(piles).max().getAsInt();
        int ans = right;  
        while(left <= right){
            int mid = (left+right)/2;
            boolean isPossible = kokoEatBanana(piles,mid,h);

            if(isPossible){
                ans = Math.min(ans,mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return ans;
    }

    public boolean kokoEatBanana(int[] piles,int mid,int h){
        
        for(int i=0;i<piles.length;i++){
            h -= (piles[i]%mid) == 0 ? (piles[i]/mid) : (piles[i]/mid) + 1;
            if(h < 0)
            {
                return false;
            }
        }
        return true;
    }
}
