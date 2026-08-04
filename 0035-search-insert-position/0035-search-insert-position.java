class Solution {
    public int searchInsert(int[] A, int target) {
        int n = A.length;
        int l=0;
        int r=n-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] < target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return l;
    }
}