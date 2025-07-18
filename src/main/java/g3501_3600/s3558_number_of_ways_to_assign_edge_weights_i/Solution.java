package g3501_3600.s3558_number_of_ways_to_assign_edge_weights_i;

// #Medium #Math #Depth_First_Search #Tree #2025_05_27_Time_12_ms_(100.00%)_Space_106.62_MB_(76.01%)

public class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private final long[] pow2 = new long[100001];

    public int assignEdgeWeights(int[][] edges) {
        if (pow2[0] == 0) {
            pow2[0] = 1;
            for (int i = 1; i < pow2.length; i++) {
                pow2[i] = (pow2[i - 1] << 1) % MOD;
            }
        }
        int n = edges.length + 1;
        int[] adj = new int[n + 1];
        int[] degrees = new int[n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u] += v;
            adj[v] += u;
            degrees[u]++;
            degrees[v]++;
        }
        int[] que = new int[n];
        int write = 0;
        int read = 0;
        for (int i = 2; i <= n; ++i) {
            if (degrees[i] == 1) {
                que[write++] = i;
            }
        }
        int distance = 0;
        while (read < write) {
            distance++;
            int size = write - read;
            while (size-- > 0) {
                int v = que[read++];
                int u = adj[v];
                adj[u] -= v;
                if (--degrees[u] == 1 && u != 1) {
                    que[write++] = u;
                }
            }
        }
        return (int) pow2[distance - 1];
    }
}
