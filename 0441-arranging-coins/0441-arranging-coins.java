class Solution {
    public int arrangeCoins(int n) {
        long l = 1;
        long r = n;
        long ans = 1;

        while(l <= r){
            long mid = l+(r-l)/2;
            if(possible(n, mid)){
                ans = mid;
                l = mid+1;
            }else{
                r=mid-1;
            }
        }

        return (int)ans;
    }

    public boolean possible(long totalCoins, long target){
        long noOfCoins = 0;

        for(long i=0; i<=target-1; i++){
            noOfCoins += i+1;

            if(noOfCoins > totalCoins){
                return false;
            }
        }

        return true;
    }
}