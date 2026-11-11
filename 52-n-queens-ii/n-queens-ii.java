class Solution {
    public int totalNQueens(int n) {
        return backtrack(n, 0, 0, 0, 0);
    }

    private int backtrack(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        int available = ((1 << n) - 1) & ~(columns | diagonals1 | diagonals2);

        while (available != 0) {
            int position = available & -available; // Choose the rightmost available column.
            available -= position;

            count += backtrack(
                n,
                row + 1,
                columns | position,
                ((diagonals1 | position) << 1) & ((1 << n) - 1),
                (diagonals2 | position) >> 1
            );
        }

        return count;
    }
}