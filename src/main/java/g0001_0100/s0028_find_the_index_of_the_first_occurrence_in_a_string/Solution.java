package g0001_0100.s0028_find_the_index_of_the_first_occurrence_in_a_string;

// #Easy #Top_Interview_Questions #String #Two_Pointers #String_Matching
// #Programming_Skills_II_Day_1 #Top_Interview_150_Array/String
// #2025_03_04_Time_0_ms_(100.00%)_Space_41.19_MB_(97.77%)

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int start = 0; start < m - n + 1; start++) {
            if (haystack.substring(start, start + n).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
