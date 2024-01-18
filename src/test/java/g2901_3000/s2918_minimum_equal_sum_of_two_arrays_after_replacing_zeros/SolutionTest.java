package g2901_3000.s2918_minimum_equal_sum_of_two_arrays_after_replacing_zeros;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void minSum() {
        assertThat(
                new Solution().minSum(new int[] {3, 2, 0, 1, 0}, new int[] {6, 5, 0}),
                equalTo(12L));
    }

    @Test
    void minSum2() {
        assertThat(new Solution().minSum(new int[] {2, 0, 2, 0}, new int[] {1, 4}), equalTo(-1L));
    }

    @Test
    void minSum3() {
        assertThat(
                new Solution().minSum(new int[] {17, 1, 13, 12, 3, 13}, new int[] {2, 25}),
                equalTo(-1L));
    }

    @Test
    void minSum4() {
        assertThat(
                new Solution()
                        .minSum(
                                new int[] {9, 5},
                                new int[] {
                                    15, 12, 5, 21, 4, 26, 27, 9, 6, 29, 0, 18, 16, 0, 0, 0, 20
                                }),
                equalTo(-1L));
    }
}
