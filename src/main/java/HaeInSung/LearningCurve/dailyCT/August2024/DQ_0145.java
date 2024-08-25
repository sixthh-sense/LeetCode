package HaeInSung.LearningCurve.dailyCT.August2024;


import java.util.ArrayList;
import java.util.List;

/* Binary Tree Postorder Traversal */
/* binary tree의 root가 주어졌을 때, node 값 역순 정렬을 반환하기 */
public class DQ_0145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        // 여기서 TreeNode 말단(즉 값이 큰)부터 차곡차곡 넣어주기
        traverseTreeNode(root, result);

        return result;
    }

    private void traverseTreeNode(TreeNode currentNode, List<Integer> result) {
        if (currentNode == null) {
            return;
        }
        System.out.println("current val: " + currentNode.val); // 탐색 자체는 root와 가까운 순부터 되지만

        // left -> right 순서도 중요함. binary tree라는 걸 잊지 말 것
        traverseTreeNode(currentNode.left, result); // left node 탐색
        traverseTreeNode(currentNode.right, result); // right node 탐색

        result.add(currentNode.val); // result에 더해지는 건 말단(즉 값이 큰) node부터
    }

    public static void main(String[] args) {
        DQ_0145 dq = new DQ_0145();

        List<TreeNode> testcases = new ArrayList<>();
        testcases.add(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));  // 3, 2, 1 나와야 함
        testcases.add(new TreeNode());
        testcases.add(new TreeNode(1));
        testcases.add(new TreeNode(3, new TreeNode(1), new TreeNode(2)));

        for (TreeNode testcase : testcases) {
            System.out.println(dq.postorderTraversal(testcase));
        }
    }
}
