import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // [finish time, server ID]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        TreeSet<Integer> available = new TreeSet<>();
        for (int server = 0; server < k; server++) {
            available.add(server);
        }

        int[] handled = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) {
                continue; // Drop the request.
            }

            int preferred = i % k;
            Integer server = available.ceiling(preferred);
            if (server == null) {
                server = available.first(); // Wrap around.
            }

            available.remove(server);
            handled[server]++;
            busy.offer(new int[] {arrival[i] + load[i], server});
        }

        int maxHandled = 0;
        for (int count : handled) {
            maxHandled = Math.max(maxHandled, count);
        }

        List<Integer> result = new ArrayList<>();
        for (int server = 0; server < k; server++) {
            if (handled[server] == maxHandled) {
                result.add(server);
            }
        }

        return result;
    }
}