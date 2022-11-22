package problems.roman_to_integer;

public class Solution {

    public static void main(String[] args) {
        int i = 1;
        {
            Solution s = new Solution();
            String in = "III";
            int out = s.romanToInt(in);
            System.out.println(i + ".");
            System.out.println("in = " + in);
            System.out.println("out = " + out);
            System.out.println("exp = 3");
            i++;
        }
        {
            Solution s = new Solution();
            String in = "LVIII";
            int out = s.romanToInt(in);
            System.out.println(i + ".");
            System.out.println("in = " + in);
            System.out.println("out = " + out);
            System.out.println("exp = 58");
            i++;
        }
        {
            Solution s = new Solution();
            String in = "MCMXCIV";
            int out = s.romanToInt(in);
            System.out.println(i + ".");
            System.out.println("in = " + in);
            System.out.println("out = " + out);
            System.out.println("exp = 1994");
            i++;
        }
    }

    public int romanToInt(String s) {
        int ret = 0;
        int i = 0;

        while (i < s.length()) {

            if (i < s.length() - 1) {
                if("IV".equals(s.substring(i, i+2))) {
                    ret = ret + 4;
                    i = i + 2;
                    continue;
                } else if("IX".equals(s.substring(i, i+2))) {
                    ret = ret + 9;
                    i = i + 2;
                    continue;
                } else if("XL".equals(s.substring(i, i+2))) {
                    ret = ret + 40;
                    i = i + 2;
                    continue;
                } else if("XC".equals(s.substring(i, i+2))) {
                    ret = ret + 90;
                    i = i + 2;
                    continue;
                } else if("CD".equals(s.substring(i, i+2))) {
                    ret = ret + 400;
                    i = i + 2;
                    continue;
                } else if("CM".equals(s.substring(i, i+2))) {
                    ret = ret + 900;
                    i = i + 2;
                    continue;
                }
            }

            if("I".charAt(0) == s.charAt(i)) {
                ret = ret + 1;
            } else if("V".charAt(0) == s.charAt(i)) {
                ret = ret + 5;
            } else if("X".charAt(0) == s.charAt(i)) {
                ret = ret + 10;
            } else if("L".charAt(0) == s.charAt(i)) {
                ret = ret + 50;
            } else if("C".charAt(0) == s.charAt(i)) {
                ret = ret + 100;
            } else if("D".charAt(0) == s.charAt(i)) {
                ret = ret + 500;
            } else if("M".charAt(0) == s.charAt(i)) {
                ret = ret + 1000;
            } else {
                return -1;
            }

            i++;
        }

        return ret;
    }
}
