class Solution {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int j=2*n-1; j>=0; j--){
            int i = j%n;
            
            while(!stack.isEmpty() && A[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }

            stack.push(A[i]);
        }

        return ans;
    }
}