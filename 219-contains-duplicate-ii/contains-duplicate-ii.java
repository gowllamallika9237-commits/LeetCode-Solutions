import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer previousIndex = lastSeen.put(nums[i], i);
            if (previousIndex != null && i - previousIndex <= k) {
                return true;
            }
        }

        return false;
    }
}