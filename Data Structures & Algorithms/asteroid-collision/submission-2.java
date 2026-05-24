class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast: asteroids){
            if(stack.isEmpty()){
                stack.push(ast);
                continue;
            }
            boolean add = true;
            while(!stack.isEmpty())
            {
                if((ast < 0 && stack.peek() > 0)){
                    if(Math.abs(ast) > Math.abs(stack.peek())){
                        stack.pop();
                    }else if(Math.abs(ast) == Math.abs(stack.peek())){
                         stack.pop();
                         add = false;
                         break;
                    }
                    else{
                        add = false;
                        break;
                    }
                }else{
                    add = false;
                    stack.push(ast);
                    break;
                }
            }

            if(add)stack.push(ast);
        }

        int[] ans = new int[stack.size()];
        int j = stack.size()-1;
        while(!stack.isEmpty()){
            ans[j] = stack.pop();
            j--;
        }

        return ans;
    }
}