class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long moves = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            moves += num; // Sum first, then subtract n * min below.
        }

        return (int) (moves - (long) nums.length * min);
    }
}