package problems.sum_of_even_numbers_after_queries;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
        System.out.println(Arrays.toString(r));
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ret = new int[nums.length];

        int tot = 0;
        for (int num : nums) {
            if (isEven(num)) {
                tot += num;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int b = nums[queries[i][1]];
            int a = b + queries[i][0];
            nums[queries[i][1]] = a;
            int buff = 0;

            if (isEven(b)) {
                buff -= b;
            }
            if (isEven(a)) {
                buff += a;
            }

            ret[i] = tot + buff;
            tot = ret[i];
        }
        return ret;
    }


    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}
