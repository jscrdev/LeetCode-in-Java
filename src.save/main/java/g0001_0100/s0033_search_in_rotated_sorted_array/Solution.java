package g0001_0100.s0033_search_in_rotated_sorted_array;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Binary_Search
// #2022_02_18_Time_0_ms_(100.00%)_Space_41.6_MB_(34.74%)

public class Solution {
    public int search(int[] nums, int target) {
        int mid;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            mid = ((hi - lo) >> 1) + lo;
            if (target == nums[mid]) {
                return mid;
            }
            // if this is true, then the possible rotation can only be in the second half
            if (nums[lo] <= nums[mid]) {
                // the target is in the first half only if it's
                if (nums[lo] <= target && target <= nums[mid]) {
                    // included
                    hi = mid - 1;
                } else {
                    // between nums[lo] and nums[mid]
                    lo = mid + 1;
                }
                // otherwise, the possible rotation can only be in the first half
            } else if (nums[mid] <= target && target <= nums[hi]) {
                // the target is in the second half only if it's included
                lo = mid + 1;
            } else {
                // between nums[hi] and nums[mid]
                hi = mid - 1;
            }
        }
        return -1;
    }
}
