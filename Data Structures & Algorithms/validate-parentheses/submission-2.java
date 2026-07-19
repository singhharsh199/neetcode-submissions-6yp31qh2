class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                char topChar = st.pop();
                if(topChar == '{' && ch != '}') return false;
                if(topChar == '(' && ch != ')') return false;
                if(topChar == '[' && ch != ']') return false;
            }
        }
        return st.isEmpty();
    }
}
