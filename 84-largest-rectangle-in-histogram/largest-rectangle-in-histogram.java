class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (top >= 0 && heights[stack[top]] > currentHeight) {
                int height = heights[stack[top--]];
                int leftBoundary = (top >= 0) ? stack[top] : -1;
                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return maxArea;
    }
}