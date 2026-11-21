import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int longest = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            if (counts.containsKey(value + 1)) {
                longest = Math.max(longest, entry.getValue() + counts.get(value + 1));
            }
        }

        return longest;
    }
}