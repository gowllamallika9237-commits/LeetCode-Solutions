class Solution {
    public char findTheDifference(String s, String t) {
        char extra = 0;

        for (char c : s.toCharArray()) {
            extra ^= c;
        }
        for (char c : t.toCharArray()) {
            extra ^= c;
        }

        return extra;
    }
}