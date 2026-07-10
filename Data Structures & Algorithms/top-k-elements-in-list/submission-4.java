class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+ 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        for(int num : freqMap.keySet()){
            int frequency = freqMap.get(num);
            minHeap.offer(new int[]{num, frequency});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
