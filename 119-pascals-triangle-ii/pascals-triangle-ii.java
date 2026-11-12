import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int r = 1; r <= rowIndex; r++) {
            // Add the new right edge.
            row.add(1);

            // Update interior values from right to left.
            for (int c = r - 1; c > 0; c--) {
                row.set(c, row.get(c) + row.get(c - 1));
            }
        }

        return row;
    }
}