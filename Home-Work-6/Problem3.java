class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] represents whether s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always valid
        
        // For each position in string
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible previous positions
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] can be segmented and s[j...i-1] is in dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Found valid segmentation up to i
                }
            }
        }
        
        return dp[s.length()];
    }
}
