class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      for(String ch: tokens){
        if (ch.equals("+") || 
    ch.equals("-") || 
    ch.equals("*") || 
    ch.equals("/")) {
            int val2 = stack.pop();
            int val1 = stack.pop();
            int ans = 0;
            if(ch.equals("+")){
                ans = val1+val2;
            }else if(ch.equals("-"))
            {
                ans = val1-val2;
            }else if(ch.equals("*") ){
                ans = val1*val2;
            }else{
                ans = val1/val2;
            }
            stack.push(ans);
        }else{
            stack.push(Integer.parseInt(ch));
        }
      }

      return stack.pop();  
    }
}
