package org.rvchavda.leetcode;

import static org.rvchavda.leetcode.MergeSortedList_21.buildList;

/**
 * 19. Remove Nth Node From End of List
 * Medium
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthLastFromLL_19 {


    public static void main(String[] args) {
        RemoveNthLastFromLL_19 cls = new RemoveNthLastFromLL_19();
        System.out.println(cls.removeNthFromEnd(buildList(new int[]{1, 2, 3, 4 ,5}).next, 1));
        System.out.println(cls.removeNthFromEnd(buildList(new int[]{1, 2, 3, 4 ,5}).next, 2));
        System.out.println(cls.removeNthFromEnd(buildList(new int[]{1, 2, 3, 4 ,5}).next, 3));
        System.out.println(cls.removeNthFromEnd(buildList(new int[]{1, 2, 3, 4 ,5}).next, 4));
        System.out.println(
                cls.removeNthFromEnd(buildList(new int[]{1, 2, 3, 4 ,5}).next, 5));
        System.out.println(cls.removeNthFromEnd(buildList(new int[]{1}).next, 1));
        System.out.println(cls.removeNthFromEnd(buildList(new int[]{1, 2}).next, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nthFromLastMinusOne = getNthFromLast(head, n);
        nthFromLastMinusOne.next = nthFromLastMinusOne.next.next;
        //nthFromLast.val = nthFromLast.next.val;
        //nthFromLast.next = nthFromLast.next.next;
        return head;
    }
    //1->2->3->4

    public ListNode getNthFromLast(ListNode head, int n) {
        int i = 1;
        ListNode slow,fast,prevSlow;
        slow = head;
        fast = head;
        prevSlow=slow;
        while(i<n) {
            fast = fast.next;
            i++;
        }

        while(fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Last is"+fast.val+", nth last-1 is:"+prevSlow.val);
        return prevSlow;
    }
}
