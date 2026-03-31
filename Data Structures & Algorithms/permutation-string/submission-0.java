class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1_freq = new int[26];
        int[] window_freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1_freq[s1.charAt(i) - 'a']++;
            window_freq[s2.charAt(i) - 'a']++;
        }
        if(matches(s1_freq, window_freq)) return true;
        for(int right = s1.length(); right < s2.length(); right++){
            window_freq[s2.charAt(right) - 'a']++;
            window_freq[s2.charAt(right - s1.length()) - 'a']--;
            if(matches(s1_freq,window_freq)) return true;
        }
        return false;
    }

    private boolean matches(int[] a1, int[] a2){
        for(int i = 0; i < a1.length; i++){
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }
}
