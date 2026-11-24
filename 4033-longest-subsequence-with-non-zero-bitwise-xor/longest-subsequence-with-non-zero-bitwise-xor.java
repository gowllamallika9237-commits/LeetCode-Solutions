class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;

        for (int value : nums) {
            totalXor ^= value;
        }

        // If the XOR of the whole array is non-zero,
        // the entire array is the longest valid subsequence.
        if (totalXor != 0) {
            return nums.length;
        }

        // The total XOR is zero. Removing any one non-zero
        // element leaves a subsequence with non-zero XOR.
        for (int value : nums) {
            if (value != 0) {
                return nums.length - 1;
            }
        }

        // Every element is zero, so no non-zero XOR is possible.
        return 0;
    }
}