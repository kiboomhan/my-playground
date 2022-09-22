package problems.reverse_words_in_a_string_iii;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String r = s.reverseWords("God Ding");
        System.out.println(r); //"doG gniD"
        r = s.reverseWords("Let's take LeetCode contest");
        System.out.println(r); //"s'teL ekat edoCteeL tsetnoc"
    }

    public String reverseWords(String s) {

        StringBuffer sb = new StringBuffer();

        int i1 = 0;
        int i2 = 0;
        char key = " ".charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (key == s.charAt(i) || i == s.length() - 1) {
                i2 = i - 1;
                if (i == s.length() - 1) {
                    i2 = i;
                }
                for (int j = i2; j >= i1; j--) {
                    sb.append(s.charAt(j));
                }
                if (i < s.length() - 1) {
                    sb.append(key);
                }

                i1 = i + 1;
                continue;
            }
        }

        return sb.toString();
    }
}
