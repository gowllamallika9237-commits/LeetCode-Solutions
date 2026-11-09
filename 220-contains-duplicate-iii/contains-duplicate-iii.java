class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // Each bucket holds values within a range of valueDiff + 1.
        long bucketSize = (long) valueDiff + 1;
        Map<Long, Long> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long value = nums[i];
            long bucket = Math.floorDiv(value, bucketSize);

            // Same bucket guarantees the difference is at most valueDiff.
            if (buckets.containsKey(bucket)) {
                return true;
            }

            // Check neighboring buckets for values within valueDiff.
            if (buckets.containsKey(bucket - 1)
                    && value - buckets.get(bucket - 1) <= valueDiff) {
                return true;
            }
            if (buckets.containsKey(bucket + 1)
                    && buckets.get(bucket + 1) - value <= valueDiff) {
                return true;
            }

            buckets.put(bucket, value);

            // Keep only the previous indexDiff elements in the window.
            if (i >= indexDiff) {
                long oldValue = nums[i - indexDiff];
                buckets.remove(Math.floorDiv(oldValue, bucketSize));
            }
        }

        return false;
    }
}