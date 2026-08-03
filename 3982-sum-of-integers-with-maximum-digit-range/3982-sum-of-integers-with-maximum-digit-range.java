class Solution {
    public int maxDigitRange(int[] A) {
        int n = A.length;
        int maxRange = 0;
        int ans = 0;
        
        for(int i=0; i<=n-1; i++){
            int range = getRange(A[i]);

            if(range > maxRange){
                maxRange = range;
                ans = A[i];
            }else if(range == maxRange){
                ans += A[i];
            }
        }

        return ans;
    }

    public int getRange(int A){
        int max = 0;
        int min = 9;

        while(A > 0){
            int r = A%10;
            min = Math.min(min, r);
            max = Math.max(max, r);
            A = A / 10;
        }

        return max-min;
    }
}