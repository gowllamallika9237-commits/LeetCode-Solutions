import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();

        return buildSentences(s, 0, dictionary, memo);
    }

    private List<String> buildSentences(
            String s,
            int start,
            Set<String> dictionary,
            Map<Integer, List<String>> memo) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> sentences = new ArrayList<>();

        if (start == s.length()) {
            sentences.add("");
            return sentences;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (dictionary.contains(word)) {
                List<String> suffixes =
                        buildSentences(s, end, dictionary, memo);

                for (String suffix : suffixes) {
                    sentences.add(
                            suffix.isEmpty() ? word : word + " " + suffix
                    );
                }
            }
        }

        memo.put(start, sentences);
        return sentences;
    }
}