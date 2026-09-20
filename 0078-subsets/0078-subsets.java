class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        solve(list, new ArrayList<>(), nums, 0);

        return list;
    }

    public void solve(List<List<Integer>> list, List<Integer> subList, int[] nums, int i){
        if(i == nums.length){
            list.add(new ArrayList<>(subList));
            return;
        }

        subList.add(nums[i]);
        solve(list, subList, nums, i + 1);

        subList.remove(subList.size() - 1);
        solve(list, subList, nums, i + 1);
    }
}

/**
 * Approach: Backtracking.
 *
 * Time Complexity: O(N * 2^N)
 *                  - There are 2^N total subsets (each element is either
 *                    included or excluded).
 *                  - Each subset takes O(N) to copy into the result list.
 *
 * Space Complexity: O(N * 2^N) for storing all subsets (2^N subsets, each
 *                   up to length N), plus O(N) for the recursion stack.
 */