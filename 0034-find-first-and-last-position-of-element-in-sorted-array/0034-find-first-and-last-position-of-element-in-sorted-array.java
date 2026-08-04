class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A.length == 0) return new int[]{-1, -1};

        int[] ans = new int[2];

        ans[0] = firstPosition(A, target);
        ans[1] = lastPosition(A, target);

        return ans;
    }

    public int firstPosition(int[] A, int target){
        int n = A.length;
        int l=0;
        int r=n-1;
        int ans = -1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] == target){
                ans = mid;
                r=mid-1;
            }else if(target > A[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return ans;
    }

    public int lastPosition(int[] A, int target){
        int n = A.length;
        int l=0;
        int r=n-1;
        int ans = -1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] == target){
                ans = mid;
                l=mid+1;
            }else if(target > A[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return ans;
    }
}