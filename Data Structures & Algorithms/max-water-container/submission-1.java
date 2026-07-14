class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max_area = 0;
        while(left < right){
            int current_height = Math.min(heights[left], heights[right]);
            int current_width = right - left;
            int current_area = current_height * current_width;
            max_area = Math.max(max_area, current_area);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return max_area;
    }
}
