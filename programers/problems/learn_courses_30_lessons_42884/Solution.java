package problems.learn_courses_30_lessons_42884;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][]{{-15,-20}, {-5,-14}, {-13,-18}, {-3,-5}, {9,-10}, {20,10}});
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}, {-10, 9}, {10, 20}});
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 8;
            int r = s.solution(new int[][]{ {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15} });
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][]{ {-191, -107}, { -184,-151 }, { -150,-102 }, { -171,-124 }, { -120,-114 } });
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][]{{0,2},{2,3},{3,4},{4,6}});
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][]{ {-20, 15}, {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} });
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 4;
            int r = s.solution(new int[][]{ {0, 1}, {2, 3}, {4, 5}, {6, 7} });
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 1;
            int r = s.solution(new int[][]{ {0, 1}, {0, 1}, {1, 2} });
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][] { {2,2},{0,1},{-10,9} });
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
        {
            Solution s = new Solution();
            int e = 2;
            int r = s.solution(new int[][] {{10,50},{15,20},{40,60}});
            System.out.print("e = " + e);
            System.out.println(" | r = " + r);
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;

        List<int[]> tmpList;
        List<Integer> choice = new LinkedList();


        while (true) {
            tmpList = new LinkedList<>();
            for (int i=0 ; i<routes.length ; i++) {
                int r1 = Math.min(routes[i][0],routes[i][1]);
                int r2 = Math.max(routes[i][0],routes[i][1]);
                int[] chs = checkAndReplaceChoice(choice, tmpList, r1, r2);
                if (chs == null) continue;
                tmpList.add(chs);
            }
            if (tmpList.isEmpty()) {
                break;
            }

            int max = tmpList.stream().mapToInt(v -> v[2]).max().getAsInt();
            List<int[]> collects = tmpList.stream().filter(v -> v[2] == max).collect(Collectors.toList());
//            for (int[] collect : collects) {
//                choice.add((collect[0] + collect[1]) / 2);
//            }
            choice.add((collects.get(0)[0] + collects.get(0)[1]) / 2);
        }

        answer = choice.size();

        return answer;
    }

    private static int[] checkAndReplaceChoice(List<Integer> choice, List<int[]> tmpList, int r1, int r2) {
        for (int c : choice) {
            if (c <= r2 && c >= r1) {
                return null;
            }
        }

        for (int[] t : tmpList) {
            if ( (t[0] <= r1 && t[1] >= r1) || (t[0] <= r2 && t[1] >= r2) ) {
                if (t[0] < r1) t[0] = r1;
                if (t[1] > r2) t[1] = r2;
                t[2] = t[2] + 1;
                return null;
            }
        }

        return new int[]{r1, r2, 1};
    }
}
