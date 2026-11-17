// 53. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int best = Integer.MIN_VALUE;
        int runningSum = 0;
        for(int i = 0; i < n; i++)
        {
            
            runningSum = Math.max(nums[i], runningSum + nums[i]);
            best = Math.max(runningSum, best);

        }
        return best;
    }
}