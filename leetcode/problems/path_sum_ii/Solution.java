package problems.path_sum_ii;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tr;
        tr = new TreeNode.builder("[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]").build();
        System.out.println(s.pathSum(tr, 22));

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        backTr(root, targetSum, 0, ret, "");

        return ret;
    }

    public void backTr(TreeNode t, int targetSum, int sum, List<List<Integer>> ret, String sub) {
        sum += t.val;

//        if (targetSum < sum) {
//            return;
//        }
        if (targetSum == sum) {
            if (t.left == null && t.right == null) {
                sub += "," + t.val;
                ret.add(Arrays.stream(sub.split(","))
                        .filter(v -> v != "")
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toList());
                return;
            }
//            else {
//                return;
//            }
        }

        if (t.left != null) {
            backTr(t.left, targetSum, sum, ret, sub + "," + t.val);
        }
        if (t.right != null) {
            backTr(t.right, targetSum, sum, ret, sub + "," + t.val);
        }
    }
}
