package HaeInSung.LearningCurve.Explore.Recursion.RecurrenceRelation;

public class TreeNode {
    /* LeetCode 정의 TreeNode */
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    /* 자체 override */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (left != null) {
            sb.append(",");
            sb.append(left.val);
        } else {
            sb.append(",");
            sb.append("null");
        }
        if (right != null) {
            sb.append(",");
            sb.append(right.val);
        } else {
            sb.append(",");
            sb.append("null");
        }

        return sb.toString();
    }
}
