class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int n = sticks.length;
        int cost = 0;

        for(int i=0; i<=n-1; i++){
            pQueue.add(sticks[i]);
        }

        while(pQueue.size() > 1){
            int ele1 = pQueue.remove();
            int ele2 = pQueue.remove();
            int ele3 = ele1 + ele2;
            cost += ele3;
            pQueue.add(ele3);
        }

        return cost;
    }
}