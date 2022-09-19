package utils;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        System.out.println("=> " + val);
        if (next != null) {
            next.print();
        }
    }

    public static ListNode getListNodeFromStr(String str) {
        str = str.replace("[", "");
        str = str.replace("]", "");

        if ("".equals(str))
            return null;

        String[] xs = str.split(",");

        ListNode listNode = new ListNode(Integer.parseInt(xs[0]));
        ListNode tmpNode = listNode;

        for (int i = 1; i < xs.length; i++) {
            tmpNode.next = new ListNode(Integer.parseInt(xs[i]));
            tmpNode = tmpNode.next;
        }

        return listNode;
    }


}
