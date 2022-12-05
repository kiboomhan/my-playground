package problems.middle_of_the_linked_list;

import utils.ListNode;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        {
            Solution s = new Solution();
            ListNode in = ListNode.getListNodeFromStr("1,2,3,4,5");
            in.print();
            ListNode out = s.middleNode(in);
            out.print();
        }
        System.out.println("+==============================+");
        {
            Solution s = new Solution();
            ListNode in = ListNode.getListNodeFromStr("1,2,3,4,5,6");
            in.print();
            ListNode out = s.middleNode(in);
            out.print();
        }
    }

    public ListNode middleNode(ListNode head) {

        LinkedList<ListNode> data = new LinkedList<>();
        ListNode curr = head;

        while ( true ) {
            data.add(curr);
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        int idx = (int) (data.size() / 2);

        ListNode ret = data.get( idx );

        return ret;
    }
}
