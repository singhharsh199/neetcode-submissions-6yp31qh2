class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Max-PriorityQueue storing [value, index]
PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
int[] result = new int[nums.length - k + 1];
int idx = 0;
for (int i = 0; i < nums.length; i++) {
// 1. Sliding Window: Expand by adding current element
maxHeap.offer(new int[]{nums[i], i});
// 2. Heap Fundamentals: Lazy Removal
// Remove top elements if they are outside the sliding window
while (maxHeap.peek()[1] <= i - k) {
maxHeap.poll();
}
// 3. Record result once window size 'k' is reached
if (i >= k - 1) {
result[idx++] = maxHeap.peek()[0];
}
}
return result;
    }
}
