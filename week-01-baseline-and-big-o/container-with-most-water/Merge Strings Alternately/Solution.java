// 1768. Merge String Alternately

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder output = new StringBuilder();

        int word1Index = 0;
        int word2Index = 0;

        int n = word1.length();
        int m = word2.length();

        // Interleave while both strings have characters left
        while(word1Index < n && word2Index < m)
        {
            output.append(word1.charAt(word1Index++));
            output.append(word2.charAt(word2Index++));
        }

        // Drain leftOver of word1 -> check word1Index against n
        while(word1Index < n)
        {
            output.append(word1.charAt(word1Index++));
        }

        // Drain leftOver of word2 -> check word2Index against m
        while(word2Index < m)
        {
            output.append(word2.charAt(word2Index++));
        }
        return output.toString();
    }
}