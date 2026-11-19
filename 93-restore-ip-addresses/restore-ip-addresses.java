import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           List<String> segments, List<String> result) {
        int remainingDigits = s.length() - index;
        int remainingParts = 4 - parts;

        // Each remaining part needs 1–3 digits.
        if (remainingDigits < remainingParts ||
            remainingDigits > remainingParts * 3) {
            return;
        }

        if (parts == 4) {
            if (index == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        for (int length = 1; length <= 3 && index + length <= s.length(); length++) {
            String segment = s.substring(index, index + length);

            if (length > 1 && segment.charAt(0) == '0') {
                break; // Leading zero
            }

            if (Integer.parseInt(segment) > 255) {
                break;
            }

            segments.add(segment);
            backtrack(s, index + length, parts + 1, segments, result);
            segments.remove(segments.size() - 1);
        }
    }
}