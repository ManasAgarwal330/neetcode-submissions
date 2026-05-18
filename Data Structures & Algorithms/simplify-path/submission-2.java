class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] data = path.split("/");
        for(String str: data){
            if((str.equals("..")) && !stack.isEmpty())stack.pop();
            else if(str.equals("..") || str.equals(".")){}
            else if(!str.isEmpty()){
                stack.push(str);
            }
        }

        StringBuilder st = new StringBuilder();
        while(!stack.isEmpty()){
            st.insert(0,stack.pop());
            st.insert(0,"/");
        }

        if(st.isEmpty()) st.insert(0,"/");
        return st.toString();
    }
}