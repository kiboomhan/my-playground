package problems.learn_courses_30_lessons_118667;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret = 0;
        ret = s.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        System.out.println("ret = " + ret);

        s = new Solution();
        ret = s.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println("ret = " + ret);

        s = new Solution();
        ret = s.solution(new int[]{1, 1}, new int[]{1, 5});
        System.out.println("ret = " + ret);
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        long sum1 = 0;
        long sum2 = 0;
        long max = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            if (queue1[i] > max) max = queue1[i];
            if (queue2[i] > max) max = queue2[i];
        }
        if (max > (sum1 + sum2) / 2) return -1;
        if (sum1 == sum2) return 0;
        if ((sum1 + sum2) % 2 == 1) return -1;

        bt(queue1, queue2, sum1, sum2, 0);

        if (min == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = min;
        }

        return answer;
    }

    int min = Integer.MAX_VALUE;

    public void bt(int[] q1, int[] q2, long sum1, long sum2, int cnt) {
        if (sum1 == sum2) {
            if (cnt < min) {
                min = cnt;
            }
            return;
        }
        if (cnt > min || cnt > (q1.length + q2.length)*2) return;

        if (q1.length > 0 && sum1 > sum2) {
            int[] q11 = new int[q1.length - 1];
            int[] q21 = new int[q2.length + 1];
            for (int i = 1; i < q1.length; i++) {
                q11[i-1] = q1[i];
            }
            for (int i = 0; i < q2.length; i++) {
                q21[i] = q2[i];
            }
            q21[q2.length] = q1[0];

            bt(q11, q21, sum1 - q1[0], sum2 + q1[0], cnt + 1);
        } else if (q2.length > 0 && sum2 > sum1) {
            int[] q12 = new int[q1.length + 1];
            int[] q22 = new int[q2.length - 1];
            for (int i = 0; i < q1.length; i++) {
                q12[i] = q1[i];
            }
            for (int i = 1; i < q2.length; i++) {
                q22[i-1] = q2[i];
            }
            q12[q1.length] = q2[0];

            bt(q12, q22, sum1 + q2[0], sum2 - q2[0], cnt + 1);
        }
    }

}
