package problems.learn_courses_30_lessons_118670;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        {
            Solution s = new Solution();
            int[][] ret = s.solution(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}}, new String[]{"Rotate", "ShiftRow"});
        }
    }

    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = rc;
        System.out.println("input = " + Arrays.deepToString(answer));

        for (String operation : operations) {
            if ("ShiftRow".equals(operation)) shiftRow(answer);
            if ("Rotate".equals(operation)) rotate(answer);
        }

        System.out.println("input = " + Arrays.deepToString(answer));
        return answer;
    }

    /**
     * 외각 값을 시가방향으로 돌림
     */
    private void rotate(int[][] rc) {

        int lastI = rc.length - 1;
        int lastJ = rc[0].length - 1;

        int remainTop = rc[0][lastJ];;
        int remainRight = rc[lastI][lastJ];
        int remainBottom = rc[lastI][0];
        int remainLeft = rc[0][0];

        // 상단 : 우측으로
        for (int j = lastJ; j >= 1; j--) {
            rc[0][j] = rc[0][j-1];
        }

        // 우측 : 하단으로
        for (int i = lastI; i >= 1; i--) {
            rc[i][lastJ] = rc[i-1][lastJ];
        }

        // 하단 : 죄측으로
        for (int j = 0; j < rc[lastI].length - 1; j++) {
            rc[lastI][j] = rc[lastI][j+1];
        }

        // 좌측 : 상단으로
        for (int i = 0; i < lastI; i++) {
            rc[i][0] = rc[i+1][0];
        }

        // 보정
        rc[1][lastJ] = remainTop;
        rc[lastI][lastJ - 1] = remainRight;
        rc[lastI - 1][0] = remainBottom;
        rc[0][1] = remainLeft;
    }

    /**
     * 아래방향으로 한칸씩 이동
     */
    private void shiftRow(int[][] rc) {
        int lastI = rc.length - 1;
        int lastJ = rc[0].length - 1;

        int[] remains = rc[lastI].clone(); // 값만 복사

        for (int i = rc.length - 1; i >= 1; i--) {
            for (int j = 0; j < rc[i].length; j++) {
                rc[i][j] = rc[i - 1][j];
            }
        }

        // 보정
        for (int j = 0; j < remains.length; j++) {
            rc[0][j] = remains[j];
        }
    }


}
