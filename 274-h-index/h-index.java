class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        for (int citation : citations) {
            papers[Math.min(citation, n)]++;
        }

        int count = 0;
        for (int h = n; h >= 0; h--) {
            count += papers[h];
            if (count >= h) {
                return h;
            }
        }

        return 0;
    }
}