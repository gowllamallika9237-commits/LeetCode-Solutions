class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Convert to a zero-based range: 0 to 25
            int remainder = columnNumber % 26;
            title.append((char) ('A' + remainder));
            columnNumber /= 26;
        }

        return title.reverse().toString();
    }
}