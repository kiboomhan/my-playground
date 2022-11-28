package problems.merge_sorted_array;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        {
            int[] nums1 = {1,2,3,0,0,0};
            int m = 3;
            int[] nums2 = {2,5,6};
            int n = 3;
            System.out.println("nums1 = " + Arrays.toString(nums1));
            System.out.println("m = " + m);
            System.out.println("nums2 = " + Arrays.toString(nums2));
            System.out.println("n = " + n);

            Solution s = new Solution();
            s.merge(nums1, m, nums2, n);
            System.out.println("out = " + Arrays.toString(nums1));;
            System.out.println("exp = [1,2,2,3,5,6]");

        }
        System.out.println("-------------------------------------------------------");
        {
            int[] nums1 = {2,0};
            int m = 1;
            int[] nums2 = {1};
            int n = 1;
            System.out.println("nums1 = " + Arrays.toString(nums1));
            System.out.println("m = " + m);
            System.out.println("nums2 = " + Arrays.toString(nums2));
            System.out.println("n = " + n);

            Solution s = new Solution();
            s.merge(nums1, m, nums2, n);
            System.out.println("out = " + Arrays.toString(nums1));;
            System.out.println("exp = [1,2]");

        }
        System.out.println("-------------------------------------------------------");
        {
            int[] nums1 = {0,0,3,0,0,0,0,0,0};
            int m = 3;
            int[] nums2 = {-1,1,1,1,2,3};
            int n = 6;
            System.out.println("nums1 = " + Arrays.toString(nums1));
            System.out.println("m = " + m);
            System.out.println("nums2 = " + Arrays.toString(nums2));
            System.out.println("n = " + n);

            Solution s = new Solution();
            s.merge(nums1, m, nums2, n);
            System.out.println("out = " + Arrays.toString(nums1));;
            System.out.println("exp = [-1,0,0,1,1,1,2,3,3]");

        }
        System.out.println("-------------------------------------------------------");
        {
            int[] nums1 = {-33,-33,-33,-25,-12,-9,-3,4,9,13,21,29,30,32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            int m = 14;
            int[] nums2 = {-50,-50,-49,-48,-47,-45,-43,-40,-38,-37,-36,-35,-31,-30,-26,-24,-24,-21,-19,-17,-16,-13,-10,-10,-10,-9,-8,-6,-2,0,1,1,1,7,9,10,12,12,14,15,17,17,18,19,20,21,23,24,28,29,30,31,31,33,35,35,38,39,41,42,48,49,49};
            int n = 63;
            System.out.println("nums1 = " + Arrays.toString(nums1));
            System.out.println("m = " + m);
            System.out.println("nums2 = " + Arrays.toString(nums2));
            System.out.println("n = " + n);

            Solution s = new Solution();
            s.merge(nums1, m, nums2, n);
            System.out.println("out = " + Arrays.toString(nums1));;
            System.out.println("exp = [-50, -50, -49, -48, -47, -45, -43, -40, -38, -37, -36, -35, -33, -33, -33, -31, -30, -26, -25, -24, -24, -21, -19, -17, -16, -13, -12, -10, -10, -10, -9, -9, -8, -6, -3, -2, 0, 1, 1, 1, 4, 7, 9, 9, 10, 12, 12, 13, 14, 15, 17, 17, 18, 19, 20, 21, 21, 23, 24, 28, 29, 29, 30, 30, 31, 31, 32, 33, 35, 35, 38, 39, 41, 42, 48, 49, 49]");

        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx = m-1;
        int idxEnd = m+n-1;
        for (int i = nums2.length-1; i > -1; ) {
            int t = idx < 0 ? Integer.MIN_VALUE : nums1[idx];
            if (nums2[i] >= t) {
                nums1[idxEnd--] = nums2[i];
                i--;
            } else {
                nums1[idxEnd--] = nums1[idx];
                idx--;
            }
        }
    }

}
