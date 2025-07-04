package g3501_3600.s3597_partition_string;

// #Medium #String #Hash_Table #Simulation #Trie
// #2025_06_30_Time_25_ms_(100.00%)_Space_55.91_MB_(100.00%)

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static class Trie {
        Trie[] tries = new Trie[26];
    }

    public List<String> partitionString(String s) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        Trie node = trie;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            int idx = s.charAt(j) - 'a';
            if (node.tries[idx] == null) {
                res.add(s.substring(i, j + 1));
                node.tries[idx] = new Trie();
                i = j + 1;
                j = i;
                node = trie;
            } else {
                node = node.tries[idx];
                j++;
            }
        }
        return res;
    }
}
