package problems.letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        {
            Solution s = new Solution();
            String in = "23";
            List<String> out = s.letterCombinations(in);
            System.out.println("in = " + in);
            System.out.println("out = " + Arrays.toString(out.toArray()));
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if ("".equals(digits)) return ret;
        Map<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"a","b","c"});
        map.put("3", new String[]{"d","e","f"});
        map.put("4", new String[]{"g","h","i"});
        map.put("5", new String[]{"j","k","l"});
        map.put("6", new String[]{"m","n","o"});
        map.put("7", new String[]{"p","q","r","s"});
        map.put("8", new String[]{"t","u","v"});
        map.put("9", new String[]{"w","x","y","z"});
        List<String[]> digitsList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String key = digits.charAt(i)+"";
            if (!map.containsKey(key)) return ret;

            String[] vals = map.get(key);

            digitsList.add(vals);
        }

        setRet(ret, digitsList, 0, "");

        return ret;
    }

    private void setRet(List<String> ret, List<String[]> digitsList, int idx, String str) {
        for (int i = 0; i < digitsList.get(idx).length; i++) {
            if (digitsList.size() > idx + 1) {
                setRet(ret, digitsList, idx+1, (str + digitsList.get(idx)[i]));
            } else {
                ret.add(str + digitsList.get(idx)[i]);
            }
        }
    }


}
