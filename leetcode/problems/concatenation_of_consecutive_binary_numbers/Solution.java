package problems.concatenation_of_consecutive_binary_numbers;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("result = " + s.concatenatedBinary(1));
        System.out.println("result = " + s.concatenatedBinary(3));
        System.out.println("result = " + s.concatenatedBinary(12));
        System.out.println("result = " + s.concatenatedBinary(9998));
    }

    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            String n2 = Integer.toBinaryString(i);
            res = (res << n2.length()) % modulo;
            res = (res + i) % modulo;
        }

        return (int) res;
    }
}
