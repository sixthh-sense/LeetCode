package HaeInSung.LearningCurve.Explore.Recursion.PrincipleOfRecursion;

import java.util.ArrayList;
import java.util.List;


/* Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.) */
public class SwapNodesInPairs {

    // 무한 루프를 방지하려면 node를 재정의할 때 그 뒤에 오는 꼬리들까지 다 따라온다는 걸 고려해야 함
    // next까지 정의해야 한다
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 초기 cursor 어디 있는지 기록용
        ListNode init = new ListNode(0); // ln 바로 전에 있는 Node라고 설정, 초기화상태니 0
        init.next = head; // init : 0 > 1, 2, 3, 4
//        System.out.println("init: " + init);

        ListNode prev = init; // prev: 0 > 1, 2, 3, 4 // 여기서 의도한 대로 init값이 제대로 들어가지 않는데 이유를 모르겠음
//        System.out.println("prev: " + prev);

        // 여기서 head를 변화시키고
        while (head != null && head.next != null) {
            ListNode current = head; // current: 1 > 2, 3, 4
//            System.out.println("current: " + current);
            ListNode nextNode = head.next; // nextNode: 2 > 3, 4
//            System.out.println("nextNode: " + nextNode);

            prev.next = nextNode; // 0 > 2, 3, 4
//            System.out.println("prev: " + prev);
            current.next = nextNode.next; // 1 > 3, 4
//            System.out.println("current: " + current);
            nextNode.next = current; // 2 > 1, 3, 4
//            System.out.println("nextNode: " + nextNode);

            prev = current;
//            System.out.println("prev: " + prev);
            head = current.next; // 이제는 3, 4를 바꿀 차례
//            System.out.println("head: " + head);
        }

        // init에 저장된 초기 cursor의 바로 뒷부분이 head이니 while문을 거친 head를 반환
        return init.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs recursion = new SwapNodesInPairs();

        List<ListNode> nodeList = new ArrayList<>();
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode second = new ListNode();
        ListNode third = new ListNode(1);

        nodeList.add(first);
        nodeList.add(second);
        nodeList.add(third);

//        System.out.println("first: " + first);

        for (ListNode node : nodeList) {
            System.out.println("result: " + recursion.swapPairs(node));
        }
    }
}
