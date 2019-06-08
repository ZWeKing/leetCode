package linkedList;

/**
 * 148. Sort List https://leetcode.com/problems/sort-list/
 * Medium
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList148Medium {
    public ListNode sortList(ListNode head) {

        if (head != null && head.next == null) {
            return head;
        }


        //step1: half the linkList, find the midPoint of the ListNode
        ListNode fast = head,slow = head,pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast =  fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }


        //step2: sort the sub-LinkList
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);

        //step3: merge two sorted-LinkList
        return mergeTwoLists(h1,h2);


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        while ( l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    if (head == null) {
                        head = l1;
                        current =  head;
                    } else {
                        current.next = l1;
                        current = current.next;
                    }

                    l1 = l1.next;
                } else {
                    if (head == null) {
                        head = l2;
                        current =  head;
                    } else {
                        current.next = l2;
                        current = current.next;
                    }

                    l2 = l2.next;
                }
                continue;
            }

            if (l1 != null) {
                current.next = l1;
                break;
            }

            if (l2 != null) {
                current.next = l2;
                break;
            }


        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new SortList148Medium().sortList(node1);


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
