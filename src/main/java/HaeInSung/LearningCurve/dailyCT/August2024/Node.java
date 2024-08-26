package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {

        String result = "Node val: " + String.valueOf(val);

        if (children != null) {
            result += ", children: ";
            for (Node child : children) {
                result += child.val + ", ";
            }
        }

        return result;
    }
}
