class Solution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int index = 0;

        // First create k distinct differences: k, k-1, ..., 1.
        int low = 1;
        int high = k + 1;

        while (low <= high) {
            answer[index++] = low++;
            if (low <= high) {
                answer[index++] = high--;
            }
        }

        // Append the remaining numbers in increasing order.
        for (int value = k + 2; value <= n; value++) {
            answer[index++] = value;
        }

        return answer;
    }
}