package problems.learn_courses_30_lessons_118668;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution s;
        int solution;
        s = new Solution();
        solution = s.solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}});
        System.out.println(solution);

        s = new Solution();
        solution = s.solution(0, 0, new int[][]{{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}});
        System.out.println(solution);

    }

    public int minTime = Integer.MAX_VALUE;
    public int maxAlp = 0;
    public int maxCop = 0;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        maxAlp = Arrays.stream(problems).mapToInt(v -> v[0]).max().getAsInt();
        maxCop = Arrays.stream(problems).mapToInt(v -> v[1]).max().getAsInt();
        bt(alp, cop, problems, 0, 0);
        return minTime;
    }

    public void bt(int alp, int cop, int[][] problems, int time, int cnt) {
        if (alp >= maxAlp && cop >= maxCop) {
            if (time < minTime) {
                minTime = time;
            }
            return;
        }

        if (time > minTime) return;

        if (cnt > 10) return;

        for (int i=0; i<problems.length; i++) {
            int newTime = time;
            int addAlp = 0;
            int addCop = 0;
            int addCnt = 0;

            if (problems[i][0] > alp) addAlp = problems[i][0] - alp;
            if (problems[i][1] > cop) addCop = problems[i][1] - cop;
            newTime += addAlp + addCop + problems[i][4];
            if ((addAlp+problems[i][2] == 0) || (addCop+problems[i][3] == 0)) addCnt++;
            bt(alp+addAlp+problems[i][2], cop+addCop+problems[i][3], problems, newTime, cnt + addCnt);
        }
    }
}