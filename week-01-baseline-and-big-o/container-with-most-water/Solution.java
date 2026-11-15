// Container With Most Water — LeetCode #11
// Pattern: Two Pointers | Time: O(n) | Space: O(1)
// Start at both ends; move the shorter wall inward (it's the bottleneck).
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int best = 0;
        
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            best = Math.max(best, h * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return best;
    }
}