package HaeInSung.LearningCurve.util;

/* Definition for singly-linked list */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//    @Override
//    public String toString() {
//        ;
//        String result = "" + val;
//        ListNode copy = new ListNode(this.val, this.next);
//        while (copy.next != null) {
//            result += "," + next.val;
//            copy = copy.next;
//        }
//
//        return result;
//    }
}
