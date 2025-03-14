package g0101_0200.s0149_max_points_on_a_line;

// #Hard #Top_Interview_Questions #Array #Hash_Table #Math #Geometry #Algorithm_II_Day_21_Others
// #Top_Interview_150_Math #2025_03_06_Time_7_ms_(99.18%)_Space_41.70_MB_(81.57%)

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                int c = x * points[j][1] - y * points[j][0];
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {
                    if (c == x * points[k][1] - y * points[k][0]) {
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
