// Two Sum — LeetCode #1
// Pattern: Hashing | Time: O(n) | Space: O(n)
// One-pass complement check. Look up target-num BEFORE inserting
// (this order handles duplicates correctly).
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{ seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }
}