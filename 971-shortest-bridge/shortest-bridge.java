import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        // Find one island and add all its cells to the queue.
        boolean found = false;
        for (int row = 0; row < n && !found; row++) {
            for (int col = 0; col < n && !found; col++) {
                if (grid[row][col] == 1) {
                    markIsland(grid, row, col, visited, queue);
                    found = true;
                }
            }
        }

        // Expand outward from the first island until reaching the second.
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int flips = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] direction : directions) {
                    int nextRow = cell[0] + direction[0];
                    int nextCol = cell[1] + direction[1];

                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n
                            || visited[nextRow][nextCol]) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 1) {
                        return flips;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }

            flips++;
        }

        return -1; // The problem guarantees exactly two islands.
    }

    private void markIsland(int[][] grid, int row, int col,
                            boolean[][] visited, Queue<int[]> queue) {
        int n = grid.length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
                    && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                markIsland(grid, nextRow, nextCol, visited, queue);
            }
        }
    }
}