package HaeInSung.LearningCurve.Explore.Recursion.RecurrenceRelation;

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
        // 출력을 위한 임시 객체
        ListNode temp = next;
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append(",");
        while (temp != null) {
            sb.append(temp.val);
            sb.append(",");

            temp = temp.next;
        }
        return sb.toString();
    }
}
