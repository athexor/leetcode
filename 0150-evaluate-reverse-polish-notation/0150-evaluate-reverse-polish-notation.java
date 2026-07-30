class Solution {
    public int evalRPN(String[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n-1; i++){
            if(A[i].equals("+") || 
               A[i].equals("-") || 
               A[i].equals("*") ||
               A[i].equals("/")
               ){
                
                int b = stack.pop();
                int a = stack.pop();

                switch (A[i]){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    default:
                        stack.push(a/b);
                }
            }else{
                stack.push(Integer.parseInt(A[i]));
            }
        }

        return stack.pop();
    }
}