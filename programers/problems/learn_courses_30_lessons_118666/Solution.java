package problems.learn_courses_30_lessons_118666;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String ret = "";
        ret = s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println("ret = " + ret);
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> cal = new HashMap<>(Map.of("RT", 0, "CF", 0, "JM", 0, "AN", 0));

        for (int i=0; i<survey.length; i++) {
            int s = 4 - choices[i];
            if (survey[i].indexOf("R") >= 0) {
                cal.put("RT", cal.get("RT") + survey[i].indexOf("R") == 0 ? s : -s);
            } else if (survey[i].indexOf("C") >= 0) {
                cal.put("CF", cal.get("CF") + survey[i].indexOf("C") == 0 ? s : -s);
            } else if (survey[i].indexOf("J") >= 0) {
                cal.put("JM", cal.get("JM") + survey[i].indexOf("J") == 0 ? s : -s);
            } else if (survey[i].indexOf("A") >= 0) {
                cal.put("AN", cal.get("AN") + survey[i].indexOf("A") == 0 ? s : -s);
            }
        }

        if (cal.get("RT") >=0) answer += "R";
        else answer += "T";
        if (cal.get("CF") >=0) answer += "C";
        else answer += "F";
        if (cal.get("JM") >=0) answer += "J";
        else answer += "M";
        if (cal.get("AN") >=0) answer += "A";
        else answer += "N";

        return answer;
    }
}
