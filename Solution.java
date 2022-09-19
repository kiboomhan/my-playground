import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("y => " + solution.pseudoPalindromicPaths(solution.getTreeNodeFromString("[2,3,1,3,1,null,1]")));

        solution.getTreeNodeFromString("[2,3,1,3,1,null,1]");
    }

//    public int pseudoPalindromicPaths (TreeNode root) {
//
//    }

    /**
     * 문자열로부터 트리를 가져온다.
     * @param x : [root, d2, d2, d3, d3, d3, d3, d4, d4, d4, d4...]
     * @return TreeNode
     */
    public TreeNode getTreeNodeFromString(String x) {
        System.out.println("x => " + x);
        x = x.replace("[", "");
        x = x.replace("]", "");

        if ("".equals(x))
            return null;

        String[] xs = x.split(",");

        TreeNode treeNode = new TreeNode(Integer.parseInt(xs[0]));
        getTreeNodeFromStringRel(1, xs, new TreeNode[]{treeNode});
        return treeNode;
    }

    public void getTreeNodeFromStringRel(int i, String[] xs, TreeNode[] nodes) {
//        int l = (int) Math.pow(2L, d);
//        int i = (int) (Math.pow(2L, d-1));

        for (TreeNode node : nodes) {
            for (int j = 0; j < 2; j++) {
                if (i + j > xs.length - 1) {
                    return;
                }

                System.out.println((i + j) + " => " + xs[i + j]);

                if ("null".equals(xs[i + j])) {
//                    i++;
                    continue;
                }

                if (j == 0) {
                    node.setLeft(new TreeNode(Integer.parseInt(xs[i + j])));
                } else {
                    node.setRight(new TreeNode(Integer.parseInt(xs[i + j])));
                }
            }
            i = i + 2;
        }

        // rel
        TreeNode[] pp = Arrays.stream(nodes)
                .<TreeNode>mapMulti((node, consumer) -> {
            consumer.accept(node.left);
            consumer.accept(node.right);
        }).toArray(TreeNode[]::new);
        getTreeNodeFromStringRel(i++, xs, pp);
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
