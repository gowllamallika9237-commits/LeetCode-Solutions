import java.util.Arrays;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int[] values = new int[k * k];
                int index = 0;

                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        values[index++] = grid[r][c];
                    }
                }

                Arrays.sort(values);

                int minDiff = Integer.MAX_VALUE;
                for (int x = 1; x < values.length; x++) {
                    if (values[x] != values[x - 1]) {
                        minDiff = Math.min(minDiff, values[x] - values[x - 1]);
                    }
                }

                ans[i][j] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
            }
        }

        return ans;
    }
}