class Solution {
    public int findPeakElement(int[] A) {
        int n = A.length;
        int l=0;
        int r=n-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(
                (mid == 0   || A[mid] >= A[mid-1]) &&
                (mid == n-1 || A[mid] >= A[mid+1]) 
            ){
                return mid;
            }else if( mid != n-1 && A[mid+1] >= A[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        
        return -1;
    }
}