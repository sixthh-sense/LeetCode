package HaeInSung.LearningCurve.dailyCT.August2024;

public class TreeNode {
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
     @Override
    public String toString() {
         return "{now: " + val + ", left: " + left + ", right: " + right + "}";
     }
}
