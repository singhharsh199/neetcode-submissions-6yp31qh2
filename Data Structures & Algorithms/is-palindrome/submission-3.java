class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {i++;}
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {j--;}
            if(s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j)) {return false;}
            i++;j--;
        }
        return true;
    }
}
