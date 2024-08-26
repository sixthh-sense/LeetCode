package HaeInSung.LearningCurve.dailyCT.August2024;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* N-ary Tree Postorder Traversal */

/* N-ary tree의 root가 주어졌을 때, node value 들의 postorder traversal을 구하기 */
public class DQ_0590 {

    public List<Integer> postorder(Node root) {
        return null;
    }

    public static void main(String[] args) {
        DQ_0590 dq = new DQ_0590();

        List<Node> testcases = new ArrayList<>();
        testcases.add(new Node(1, Arrays.asList(null, new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4))));
    }
}
