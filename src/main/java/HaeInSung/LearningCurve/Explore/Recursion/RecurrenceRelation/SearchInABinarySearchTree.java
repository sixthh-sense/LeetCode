package HaeInSung.LearningCurve.Explore.Recursion.RecurrenceRelation;

import java.util.ArrayList;
import java.util.List;

/* binary search tree의 root과 특정 정수값 val이 주어질 때,
* BST에서 val 값을 가지는 node를 찾고 그 node의 subtree를 찾기, 없으면 null 반환 */

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        System.out.println("current root: " + root);
        if (root == null || root.val == val) {
            return root;
        }
        // 이 부분이 헷갈렸는데
        /* binary search tree -> 2진 탐색 트리이기에 같은 level에 위치한 node끼리는 왼쪽 val < 오른쪽 val */
        return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static void main(String[] args) {
        SearchInABinarySearchTree recursion = new SearchInABinarySearchTree();

        List<TreeNode> testcases = new ArrayList<>();
        testcases.add(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)));
        testcases.add(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)));

        List<Integer> values = new ArrayList<>();
        values.add(2);
        values.add(5);

        for (TreeNode testcase : testcases) {
            int index = testcases.indexOf(testcase);
            System.out.println(recursion.searchBST(testcase, values.get(index)));
        }
    }
}
