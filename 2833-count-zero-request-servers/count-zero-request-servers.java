import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[m];
        int[] requestCount = new int[n + 1];
        int activeServers = 0;
        int left = 0;
        int right = 0;

        for (int[] query : sortedQueries) {
            int time = query[0];
            int windowStart = time - x;

            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right++][0];
                if (requestCount[server]++ == 0) {
                    activeServers++;
                }
            }

            while (left < right && logs[left][1] < windowStart) {
                int server = logs[left++][0];
                if (--requestCount[server] == 0) {
                    activeServers--;
                }
            }

            result[query[1]] = n - activeServers;
        }

        return result;
    }
}