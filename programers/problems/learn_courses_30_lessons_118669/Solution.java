package problems.learn_courses_30_lessons_118669;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        /*{
            Solution s = new Solution();
            int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
            int[] answer = s.solution(7, paths, new int[]{3, 7}, new int[]{1, 5});
            System.out.println(answer[0] + ":" + answer[1]);

        }
        {
            Solution s = new Solution();
            int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
            ;
            int[] answer = s.solution(6, paths, new int[]{1, 3}, new int[]{5});
            System.out.println(answer[0] + ":" + answer[1]);
        }*/
        {
            Solution s = new Solution();
            int[][] paths = {{1, 4, 4},{1, 6, 1},{1, 7, 3},{2, 5, 2},{3, 7, 4},{5, 6, 6}};
            ;
            int[] answer = s.solution(7, paths, new int[]{1}, new int[]{2, 3, 4});
            System.out.println(answer[0] + ":" + answer[1]);
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        Map<String, Map<String, Integer>> pathMap = new HashMap<>();
        for (int[] path : paths) {
            if (!pathMap.containsKey(path[0] + "")) pathMap.put(path[0] + "", new HashMap<String, Integer>());
            if (!pathMap.containsKey(path[1] + "")) pathMap.put(path[1] + "", new HashMap<String, Integer>());
            pathMap.get(path[0] + "").put(path[1] + "", path[2]);
            pathMap.get(path[1] + "").put(path[0] + "", path[2]);
        }


        for (int i = 0; i < gates.length; i++) {
            List<String> gateList = Arrays.stream(gates).mapToObj(String::valueOf).collect(Collectors.toList());
            gateList.remove(i);
            bt(gates[i] + "", pathMap, gateList, summits, null, 0, 0, null, gates[i] + "");
        }

        answer[0] = summitMin;
        answer[1] = intensityMin;

        return answer;
    }

    public int summitMin = Integer.MAX_VALUE;
    public int intensityMin = Integer.MAX_VALUE;

    private void bt(String gate, Map<String, Map<String, Integer>> pathMap, List<String> gateList, int[] summits, String pre, int cnt, int inten, String summit, String curr) {
        if (inten > intensityMin) return;
        if (summit == null && Arrays.stream(summits).anyMatch(v -> v == Integer.parseInt(curr))) {
            if (intensityMin > inten) {
                intensityMin = inten;
                summitMin = Integer.parseInt(curr);
            } else if (intensityMin == inten) {
                summitMin = Math.min(summitMin, Integer.parseInt(curr));
            }
            return;
        }

        for (String next : pathMap.get(curr).keySet()) {
            if (!next.equals(pre) && !gateList.contains(next)) {
                if (summit != null && Arrays.stream(summits).anyMatch(v -> String.valueOf(v) == next)) {
                    continue;
                }
                bt(gate, pathMap, gateList, summits, curr, cnt + 1, Math.max(inten, pathMap.get(curr).get(next)), summit, next);
            }
        }
    }
}
