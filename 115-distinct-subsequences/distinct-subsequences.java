class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1; // One way to form the empty string.

        for (int i = 0; i < s.length(); i++) {
            // Iterate backward so each character in s is used at most once.
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[t.length()];
    }
}