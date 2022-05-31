package g2101_2200.s2106_maximum_fruits_harvested_after_at_most_k_steps;

// #Hard #Array #Binary_Search #Prefix_Sum #Sliding_Window
// #2022_05_31_Time_27_ms_(48.57%)_Space_128.7_MB_(44.76%)

public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int res = 0;
        for (int left = 0, right = 0, sum = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while (left <= right && !isValidRange(fruits[left][0], fruits[right][0], startPos, k)) {
                sum -= fruits[left++][1];
            }
            res = Math.max(sum, res);
        }

        return res;
    }

    private boolean isValidRange(int leftPos, int rightPos, int startPos, int k) {
        if (rightPos <= startPos) {
            return startPos - leftPos <= k;
        } else if (leftPos >= startPos) {
            return rightPos - startPos <= k;
        } else {
            int left = startPos - leftPos;
            int right = rightPos - startPos;
            return left <= right ? left * 2 + right <= k : right * 2 + left <= k;
        }
    }
}