class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length;
        int sum = 0;

        for(int i=0; i<=n-1; i++){
            sum += nums[i];
            minHeap.add(nums[i]);
        }

        while(k > 0){
            int min = minHeap.remove();
            if(min > 0 && k % 2 == 0)
                break;
            sum -= min;
            min = -min;
            sum += min;
            minHeap.add(min);
            k--;
        }

        return sum;
    }
}