package problems.increasing_triplet_subsequence;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        {
//            Solution s = new Solution();
//            s.increasingTriplet(new int[]{1, 2, 3, 4, 5});
        }
        {
//            Solution s = new Solution();
//            s.increasingTriplet(new int[]{2,1,5,0,4,6});
        }
        {
//            Solution s = new Solution();
//            s.increasingTriplet(new int[]{1,5,0,4,1,3});
        }
        {
            Solution s = new Solution();
            s.increasingTriplet(new int[]{1,2,1,2,1,2,1,2,1,2,1,2,1,2});
        }

    }
    int tot = 0;

    private boolean ret = false;
    private Map<String, Integer> tmp = new HashMap<>();

    public boolean increasingTriplet(int[] nums) {
        if (Arrays.stream(nums).distinct().count() < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 2 && nums[i+1] > nums[i] && !tmp.containsKey(nums[i]+"_"+nums[i+1])) {
                bt(i+1, nums, 1, nums[i]);
            }
        }
        bt(0, nums, 0, Integer.MIN_VALUE);

        System.out.println("ret = " + ret);
        System.out.println("tot = " + tot);
        return ret;
    }

    private void bt(int i, int[] nums, int cnt, int prev) {
        tot++;
        if (cnt > 2 || ret) {
            ret = true;
            return;
        }
        if (i >= nums.length) {
            return;
        }

        if (prev < nums[i]) {
            if (cnt == 1 && tmp.containsKey(prev+"_"+nums[i])) {
                // pass
            } else {
                if (cnt == 1 && !tmp.containsKey(prev+"_"+nums[i])) {
                    tmp.put(prev+"_"+nums[i], i);

                }
                bt(i+1, nums, cnt+1, nums[i]);
            }
        }
        bt(i+1, nums, cnt, prev);
    }
}
