package problems.powx_n;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        double r;
        r = s.myPow(2, 10);
        System.out.println("r = " + r);
        r = s.myPow(2, -2147483648);
        System.out.println("r = " + r); // 0
        r = s.myPow(2.10000, 3);
        System.out.println("r = " + r);
        r = s.myPow(2.00000, -2);
        System.out.println("r = " + r);
        r = s.myPow(0.00001, 2147483647);
        System.out.println("r = " + r);
        r = s.myPow(-1, 2147483647);
        System.out.println("r = " + r);
        r = s.myPow(-1, 2147483647);
        System.out.println("r = " + r);

    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }

        double r = x;
        long i = 1;
        long nn = Math.max(n, -((long) n));
        while (i < nn) {
            if (i < nn / 2) {
                r = r * r;
                i = i + i;
            } else {
                r = r * x;
                i++;
            }
            if (!(r < Double.MAX_VALUE) || r == 0) {
                break;
            }
        }
        if (Double.isInfinite(r) && n < 0) {
            return 0;
        }
        if (n < 0) {
            return 1 / r;
        }

        return r;
    }

}
