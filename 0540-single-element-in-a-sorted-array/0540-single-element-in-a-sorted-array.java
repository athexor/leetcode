class Solution {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;
        int l = 0;
        int r = n-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(
                (mid == 0   || A[mid] != A[mid-1]) &&
                (mid == n-1 || A[mid] != A[mid+1])
            ){
                return A[mid];
            }
            
            if(mid !=0 && A[mid] == A[mid-1])  mid--;

            if(mid % 2 == 0){
                l = mid+2;
            }else{
                r = mid-1;
            }
        }

        return -1;
    }
}