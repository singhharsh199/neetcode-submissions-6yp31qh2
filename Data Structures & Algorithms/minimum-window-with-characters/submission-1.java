class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] target_counts = new int[128];
        int required_unique_characters = 0;
        for(char ch : t.toCharArray()){
            if(target_counts[ch] == 0) required_unique_characters++;
            target_counts[ch]++;
        }
        int[] current_counts = new int[128];
        int matched_unique_characters = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int best_start = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            current_counts[ch]++;
            if(target_counts[ch] > 0 && current_counts[ch] == target_counts[ch]) {
                matched_unique_characters++;
            }
            while(matched_unique_characters == required_unique_characters){
                if((right - left + 1) < minLen){
                    minLen = right - left + 1;
                    best_start = left;
                }
                char left_char = s.charAt(left);
                current_counts[left_char]--;

                if(target_counts[left_char] > 0 && current_counts[left_char] < target_counts[left_char]){
                    matched_unique_characters--;
                }
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(best_start, best_start + minLen);
    }
}
