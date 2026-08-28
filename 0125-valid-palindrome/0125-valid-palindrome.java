class Solution {
    public boolean isPalindrome(String A) {
        A = A.trim().toLowerCase().replaceAll("[^a-z0-9]", "");
        int n = A.length();
        int start = 0;
        int end = n-1;
        while(start <= end){
            if(A.charAt(start) != A.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}