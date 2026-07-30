class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<=n-1; i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;

                char pop = stack.pop();
                if(
                    (pop == '(' && ')' != ch) ||
                    (pop == '{' && '}' != ch) ||
                    (pop == '[' && ']' != ch) 
                ){
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}