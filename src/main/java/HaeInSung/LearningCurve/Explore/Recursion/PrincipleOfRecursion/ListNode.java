package HaeInSung.LearningCurve.Explore.Recursion.PrincipleOfRecursion;

/* Definition for singly-linked list */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // LeetCode에 정의되지 않은 toString() 메소드지만 내 이해를 위해 집어넣음
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null) {
            sb.append(",");
        }
        while (next != null) {
            sb.append(next.val);
            if (next.next != null) {
                sb.append(",");
            }
            next = next.next;
        }
        return sb.toString();
    }
}
