class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] str = new char[2*n];

        solve(str, list, 0, n, 0, 0);

        return list;
    }

    public void solve(char[] str, List<String> list, int i, int n, int open, int close){
        if(i == 2*n){
            list.add(new String(str));
            return;
        }

        if(open < n){
            str[i] = '(';
            solve(str, list, i+1, n, open+1, close);
        }

        if(close < open){
            str[i] = ')';
            solve(str, list, i+1, n, open, close+1);
        }
    }
}

/**
 * Approach: Backtracking.
 *
 * Time Complexity: O(4^N / sqrt(N))
 *                  - This is the Nth Catalan number, which is both the exact
 *                    count of valid parentheses combinations generated and
 *                    the bound on total recursive calls made.
 *
 * Space Complexity: O(4^N / sqrt(N))
 *                  - For storing all valid result strings.
 *                  - Plus O(N) for the recursion call stack, since each
 *                    valid string has length 2N, so recursion goes at most
 *                    2N levels deep.
 */