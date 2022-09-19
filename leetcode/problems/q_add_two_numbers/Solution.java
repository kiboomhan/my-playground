package problems.q_add_two_numbers;

import utils.ListNode;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();

        int tv = 0;
        ListNode tl1 = l1;
        ListNode tl2 = l2;
        ListNode tl3 = l3;
        while (true) {
            tl3.val = (tl1.val + tl2.val + tv) % 10;
            tv = (tl1.val + tl2.val + tv) / 10;

            if (tl1.next == null && tl2.next == null)
                break;
            if (tl1.next == null) {
                tl1.val = 0;
            } else {
                tl1 = tl1.next;
            }

            if (tl2.next == null) {
                tl2.val = 0;
            } else {
                tl2 = tl2.next;
            }
            tl3.next = new ListNode();
            tl3 = tl3.next;
        }

        if (tv > 0) {
            tl3.next = new ListNode();
            tl3 = tl3.next;
            tl3.val = tv;
        }

        return l3;
    }


}