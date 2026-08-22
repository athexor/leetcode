class Solution {
    public boolean containsDuplicate(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int n = A.length;

        for(int i=0; i<=n-1; i++){
            if(set.contains(A[i]))
                return true;
            set.add(A[i]);
        }

        return false;
    }
}