import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int answer = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            int duplicates = 0;
            int bestForAnchor = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int gcd = gcd(Math.abs(dx), Math.abs(dy));
                dx /= gcd;
                dy /= gcd;

                // Normalize so each slope has exactly one representation.
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1; // Vertical line
                }

                String slope = dx + "/" + dy;
                int count = slopes.getOrDefault(slope, 0) + 1;
                slopes.put(slope, count);
                bestForAnchor = Math.max(bestForAnchor, count);
            }

            answer = Math.max(answer, bestForAnchor + duplicates + 1);
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}