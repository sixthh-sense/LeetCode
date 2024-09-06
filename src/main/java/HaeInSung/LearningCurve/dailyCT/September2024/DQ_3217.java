package HaeInSung.LearningCurve.dailyCT.September2024;


import HaeInSung.LearningCurve.util.ListNode;

import java.util.*;

/** 9/6 Delete Nodes From Linked List Present in Array
 * You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
 * */
public class DQ_3217 {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> removeList = new HashSet<>();
        for (int num : nums) {
            removeList.add(num);
        }

        while (head != null && removeList.contains(head.val)) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current.next != null) {
            if (removeList.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DQ_3217 dq = new DQ_3217();

        List<int[]> numsList = new ArrayList<>(Arrays.asList(new int[]{1, 2, 3}, new int[]{1}, new int[]{5}));
        List<ListNode> headList = new ArrayList<>();
        headList.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        headList.add(new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2)))))));
        headList.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));

        for (int[] num : numsList) {
            int i = numsList.indexOf(num);
            System.out.println("result: " + dq.modifiedList(num, headList.get(i)));;
        }

    }
}
