QUESTION: 03. Longest Substring Without Repeating Characters

// SLIDING WINDOW APPROACH

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;

        HashSet<Character> seen = new HashSet<>();

        for(int right = 0; right < n; right++)
        {
            char ch = s.charAt(right);

            // Shrink window until ch is no longer inside
            while(seen.contains(ch))
            {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}