class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num : nums) num_set.add(num);
        int longestSequence = 0;
        for(int num : num_set){
            if(!num_set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;
                while(num_set.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }
                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }
        return longestSequence;
    }
}
