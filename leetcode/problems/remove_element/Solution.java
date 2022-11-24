package problems.remove_element;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        {
            Solution s = new Solution();
            int[] inNums = {3,2,2,3};
            int inVal = 3;
            System.out.println("inNums = " + Arrays.toString(inNums));
            System.out.println("inVal = " + inVal);
            int out = s.removeElement(inNums, inVal);
            System.out.println("out = " + Arrays.toString(Arrays.copyOfRange(inNums, 0, out)));
            System.out.println("expected = [2, 2]");
        }
        System.out.println("-------------------------------------------------------------------");
        {
            Solution s = new Solution();
            int[] inNums = {0,1,2,2,3,0,4,2};
            int inVal = 2;
            System.out.println("inNums = " + Arrays.toString(inNums));
            System.out.println("inVal = " + inVal);
            int out = s.removeElement(inNums, inVal);
            System.out.println("out = " + Arrays.toString(Arrays.copyOfRange(inNums, 0, out)));
            System.out.println("expected = [0,1,4,0,3]");
        }
    }

    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
            } else {
                nums[idx] = nums[i];
                idx ++;
            }
        }

        return idx;
    }
}
