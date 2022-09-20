package problems.q_find_minimum_time_to_finish_all_jobs;

import java.util.Arrays;

public class Solution {

    int min = Integer.MAX_VALUE;
    int cnt = 0;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        backtracking(jobs, 0, new int[k]);
        System.out.println("cnt => " + cnt);

        return min;
    }

    private void backtracking(int[] jobs, int ji, int[] sum) {
        cnt++;
        int max = getMax(sum);

        if (max >= min) {
            return;
        }

        if (ji == jobs.length) {
            if (max < min) {
                min = max;
            }
            return;
        }

        for (int i = 0; i < sum.length; i++) {
            if (i > 0 && sum[i] == sum[i - 1]) {
                continue;
            }
            sum[i] += jobs[ji];
            backtracking(jobs, ji + 1, sum);
            sum[i] -= jobs[ji];
        }
    }

    private int getMax(int[] sum) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > max) {
                max = sum[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int[] x1;
        int x2;
        int ret;

        x1 = new int[] {3,2,3};
        x2 = 3;
        ret = new Solution().minimumTimeRequired(x1, x2);
        System.out.println(ret);

        x1 = new int[] {1,2,4,7,8};
        x2 = 2;
        ret = new Solution().minimumTimeRequired(x1, x2);
        System.out.println(ret);

        x1 = new int[] {5,5,4,4,4};
        x2 = 2;
        ret = new Solution().minimumTimeRequired(x1, x2);
        System.out.println(ret);
    }
}
