import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countPartitions(int[] nums, int k) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;

        // dp[i] = ways to partition the first i elements
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while ((long) nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            // Valid final segments start at any index from left through right.
            dp[right + 1] = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
            dp[right + 1] %= MOD;
            if (dp[right + 1] < 0) dp[right + 1] += MOD;

            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}