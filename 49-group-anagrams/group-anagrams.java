import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            int[] counts = new int[26];

            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }

            // The character counts uniquely identify an anagram group.
            StringBuilder key = new StringBuilder();
            for (int count : counts) {
                key.append('#').append(count);
            }

            groups.computeIfAbsent(key.toString(), k -> new ArrayList<>())
                  .add(word);
        }

        return new ArrayList<>(groups.values());
    }
}