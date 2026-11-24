class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int answer = 1;

        for (int left = 0; left < n; left++) {
            long product = 1;
            int gcd = 0;
            long lcm = 1;

            for (int right = left; right < n; right++) {
                int value = nums[right];

                product *= value;
                gcd = gcd(gcd, value);
                lcm = lcm(lcm, value);

                if (product == lcm * gcd) {
                    answer = Math.max(answer, right - left + 1);
                }
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd((int) a, (int) b) * b;
    }
}