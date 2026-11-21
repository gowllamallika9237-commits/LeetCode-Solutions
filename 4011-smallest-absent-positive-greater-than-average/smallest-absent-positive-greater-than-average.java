class Solution {
    public int smallestAbsent(int[] nums) {
        int sum = 0;
        boolean[] present = new boolean[202];

        for (int num : nums) {
            sum += num;
            if (num > 0) {
                present[num] = true;
            }
        }

        // Find the first integer x where x > sum / nums.length.
        // This is equivalent to x * nums.length > sum.
        int candidate = 1;
        while ((long) candidate * nums.length <= sum || present[candidate]) {
            candidate++;
        }

        return candidate;
    }
}