package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public String target;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(String target) {

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

    public void print() {

        System.out.println("print target start => " + target);
        List<TreeNode> targetList = new ArrayList<>();
        List<TreeNode> tmpList = new ArrayList<>();
        targetList.add(this);
        boolean has = true;
        String str = "";
        while (true) {
            if (!has) {
                break;
            }
            for (TreeNode target : targetList) {
                if (target == null) {
                    str += ("null" + "  ");
                } else {
                    str += (target.val + "  ");
                }
            }
            str += "\r\n";
            has = false;
            tmpList = new ArrayList<>();
            for (TreeNode target : targetList) {
                if (target == null) {
                    tmpList.add(null);
                    tmpList.add(null);
                    continue;
                }
                if (target.left != null) {
                    tmpList.add(target.left);
                    has = true;
                } else {
                    tmpList.add(null);
                }
                if (target.right != null) {
                    tmpList.add(target.right);
                    has = true;
                } else {
                    tmpList.add(null);
                }
            }
            targetList = tmpList;
        }

        System.out.println(str);

        System.out.println("print target end => " + target);
    }

    public static final class builder {
        private int val;
        private TreeNode left;
        private TreeNode right;

        String target;

        public builder() {
        }

        public builder(String target) {
            this.target = target;
        }

        public static builder aTreeNode() {
            return new builder();
        }

        public builder val(int val) {
            this.val = val;
            return this;
        }

        public builder left(TreeNode left) {
            this.left = left;
            return this;
        }

        public builder right(TreeNode right) {
            this.right = right;
            return this;
        }

        public builder but() {
            return aTreeNode().val(val).left(left).right(right);
        }

        public TreeNode getTreeNodeFromString(String x) {
            // System.out.println("x => " + x);
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
            for (TreeNode node : nodes) {
                for (int j = 0; j < 2; j++) {
                    if (i + j > xs.length - 1) {
                        return;
                    }

                    // System.out.println((i + j) + " => " + xs[i + j]);

                    if ("null".equals(xs[i + j])) {
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
                        if (node == null) {
                            return;
                        }
                        consumer.accept(node.left);
                        consumer.accept(node.right);
                    }).toArray(TreeNode[]::new);
            getTreeNodeFromStringRel(i++, xs, pp);
        }

        public TreeNode build() {
            if (target != null) {
                TreeNode result = getTreeNodeFromString(target);
                result.target = this.target;
                return result;
            }
            TreeNode treeNode = new TreeNode(val);
            treeNode.setLeft(left);
            treeNode.setRight(right);

            return treeNode;
        }

    }
}
