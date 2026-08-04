class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;

        int l=1;
        int r=x;
        int ans=l;

        while(l<=r){
            int mid = l+(r-l)/2;
            long sqr = (long)mid*mid;
            if(sqr <= x){
                ans = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return ans;
    }
}