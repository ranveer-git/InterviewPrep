package org.rvchavda.leetcode.arrays;

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing
 * together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeSortedList_21 {

    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_V2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode h = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
//            System.out.print(val+"->");
//            h.next = new ListNode(val);
            h = h.next;
        }
        h.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode h = head;
        int val;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                val = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            System.out.print(val + "->");
            h.next = new ListNode(val);
            h = h.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeSortedList_21 cls = new MergeSortedList_21();

       /* ListNode head = cls.buildList(new int[]{2,3,4});
        ListNode a = head.next;
        while(a != null) {
            System.out.println(a.val);
            a = a.next;
        }*/
        ListNode a = cls.mergeTwoListsRecursion(cls.buildList(new int[]{1, 2, 4}).next, cls.buildList(new int[]{1, 3, 4}).next);
        System.out.println(a);
    }

    public ListNode buildList(int[] nums) {
        ListNode head = new ListNode();
        ListNode n = head;
        for (int i = 0; i < nums.length; i++) {
            n.next = new ListNode(nums[i]);
            n = n.next;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

