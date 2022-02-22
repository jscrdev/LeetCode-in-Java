package g0101_0200.s0139_word_break;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #String #Hash_Table
// #Dynamic_Programming #Trie #Memoization #Dynamic_Programming_I_Day_9
// #2022_02_22_Time_2_ms_(96.55%)_Space_42.2_MB_(63.03%)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int max = 0;
        boolean[] flag = new boolean[s.length() + 1];
        for (String st : wordDict) {
            set.add(st);
            if (max < st.length()) {
                max = st.length();
            }
        }
        for (int i = 1; i <= max; i++) {
            if (dfs(s, 0, i, max, set, flag)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String s, int start, int end, int max, Set<String> set, boolean[] flag) {
        if (!flag[end] && set.contains(s.substring(start, end))) {
            flag[end] = true;
            if (end == s.length()) {
                return true;
            }
            for (int i = 1; i <= max; i++) {
                if (end + i <= s.length() && dfs(s, end, end + i, max, set, flag)) {
                    return true;
                }
            }
        }
        return false;
    }
}
