package HaeInSung.LearningCurve.Explore.Recursion.RecurrenceRelation;


import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    // 방향만 바꿔볼 수 있을까?
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode now = head;

        while (now != null) {
            ListNode nextTemp = now.next; // 반복문 순차적으로 돌릴 용도 > 다음 위치 정보 미리 기록해두기
            // 화살표 방향 바꾸기
            now.next = prev;
            // 반복문의 다음 회차에서 써먹어야 하니까 prev -> now 업데이트
            prev = now;
            now = nextTemp; // 처음 저장해뒀던 정보 -> '다음' 요소의 방향도 바꿔주기
        }
        return prev;
    }

    // ListNode의 head 를 주면 순서 바꿔서 재구성하기
    public static void main(String[] args) {
        ReverseLinkedList recursion = new ReverseLinkedList();

        List<ListNode> listnodes = new ArrayList<>();
        listnodes.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        listnodes.add(new ListNode(1, new ListNode(2)));
        listnodes.add(new ListNode());

        for (ListNode node : listnodes) {
            System.out.println(recursion.reverseList(node));
        }
    }
}
