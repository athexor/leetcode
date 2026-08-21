class Solution {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l+(r-l)/2;
            if(
                (mid == 0   || A[mid] != A[mid-1]) &&
                (mid == n-1 || A[mid] != A[mid+1]) 
            ){
                return A[mid];
            }

            int first = mid;
            if(mid != 0 && A[mid] == A[mid-1])
                first--;
            
            if(first % 2 == 0){
                l = mid+1;
            }else{
                r = mid-1;
            }   
        }

        return -1;
    }
}


/** 
 * if(n == 1) return A[0];
 * We don't need separate checks for the first and last elements. 
 * 
 * The conditions (mid == 0) and (mid == n - 1) already handle
 * this specific cases inside the main condition. 
 * 
 * We can add these checks as well.
 * if(A[0] != A[1]) return A[0];
 * if(A[n-1] != A[n-2]) return A[n-1];
 * This will save some extra time in specific edge cases.
 * 
 * Doubt: here using `mid` instead of `first` for updating l/r (l=mid+1, r=mid-1)
 * does this cause any correctness/infinite-loop issue?
**/