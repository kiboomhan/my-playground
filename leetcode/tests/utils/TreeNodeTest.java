package utils;

public class TreeNodeTest {

    public static void main(String[] args) {

        TreeNode test = new TreeNode.builder().val(1).build();
        test.print();

        TreeNode test2 = new TreeNode.builder("[2,3,1,3,1,null,1]").build();
        test2.print();
    }
}
