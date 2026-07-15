class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int max_freq = 0;
        int max_len = 0;
        for(int right = 0; right < s.length(); right++){
            int right_index = s.charAt(right) - 'A';
            counts[right_index]++;
            max_freq = Math.max(max_freq, counts[right_index]);
            while((right-left+1)-max_freq > k){
                int left_index = s.charAt(left) - 'A';
                counts[left_index]--;
                left++;
            }
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}
