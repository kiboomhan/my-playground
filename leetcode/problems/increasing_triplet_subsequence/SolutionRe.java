package problems.increasing_triplet_subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionRe {

    public static void main(String[] args) {

        /*{
            SolutionRe s = new SolutionRe();
            boolean b = s.increasingTriplet(new int[]{1, 2, 3, 4, 5});
            System.out.println("b = " + b);
        }
        {
            SolutionRe s = new SolutionRe();
            boolean b = s.increasingTriplet(new int[]{2,1,5,0,4,6});
            System.out.println("b = " + b);
        }
        {
            SolutionRe s = new SolutionRe();
            boolean b = s.increasingTriplet(new int[]{1,5,0,4,1,3});
            System.out.println("b = " + b);
        }
        {
            SolutionRe s = new SolutionRe();
            boolean b = s.increasingTriplet(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2});
            System.out.println("b = " + b);
        }*/
        {
            SolutionRe s = new SolutionRe();
            boolean b = s.increasingTriplet(new int[]{20,100,10,12,5,13});
            System.out.println("b = " + b);
        }
        {
            SolutionRe s = new SolutionRe();
            boolean b = s.increasingTriplet(new int[]{20,12,100,10,5,13});
            System.out.println("b = " + b);
        }

    }

    public boolean increasingTriplet(int[] nums) {

        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n <= n1) {
                n1 = n;
//                n2 = Integer.MAX_VALUE;
            } else if (n <= n2) {
                n2 = n;
            } else {
                return true;
            }
        }
        return false;
    }

}
