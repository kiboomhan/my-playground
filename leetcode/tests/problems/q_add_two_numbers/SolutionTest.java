package problems.q_add_two_numbers;


import utils.ListNode;

class SolutionTest {

    public static void main(String[] args) {
        ListNode test = Solution.addTwoNumbers(ListNode.getListNodeFromStr("[2,4,3]"), ListNode.getListNodeFromStr("[5,6,4]"));
        test.print();
    }
}