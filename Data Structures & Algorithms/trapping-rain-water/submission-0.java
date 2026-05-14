class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[height.length];
        int[] nge = new int[height.length];
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && stack.peek() < height[i])stack.pop();
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            if(stack.isEmpty())stack.push(height[i]);
        }

        stack = new Stack<>();
        for(int i=height.length-1;i>0;i--){
            while(!stack.isEmpty() && stack.peek() < height[i])stack.pop();
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            if(stack.isEmpty())stack.push(height[i]);
        }

        int ans = 0;
        for(int i=0;i<height.length;i++){
            if(nge[i] == -1 || pge[i] == -1)continue;
            int waterAtIdx = Math.min(nge[i],pge[i]) - height[i];
            ans += waterAtIdx;
        }

        return ans;

    }
}
