import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lenovo on 2017/2/21.
 */
public class TreeAlgorithm {
    /**
     * @param root
     */
    public void searchInorder(TreeNode root, boolean isRecursive) {
        if (root == null) return;
        searchInorder(root.left, isRecursive);
        visit(root);
        searchInorder(root.right, isRecursive);

        //非递归实现
        if (root == null) return;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        //stack.add(node);
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                visit(node);
                node = node.right;
            }
        }
    }

    public void searchPreorder(TreeNode root, boolean isRecursive) {
        if (root == null) return;
        visit(root);
        searchInorder(root.left, isRecursive);
        searchInorder(root.right, isRecursive);

        //非递归实现
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            visit(node);
            stack.add(node.right);
            stack.add(node.left);

        }
    }

    public void searchPostorder(TreeNode root, boolean isRecursive) {
        if (root == null) return;
        searchInorder(root.left, isRecursive);
        searchInorder(root.right, isRecursive);
        visit(root);

        //非递归实现
        if (root == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode node = root;
        s1.add(node);
        Stack<TreeNode> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            node = s1.pop();
            if (node.left != null) s1.add(node.left);
            if (node.right != null) s1.add(node.right);
            s2.add(node);
        }

        while (!s2.isEmpty()) {
            visit(s2.pop());
        }
    }

    private void visit(TreeNode node) {
        System.out.println(node.value);
    }

    /**
     *  得到二叉树的最大距离
     * @param root
     * @return
     */
    public int getMaxDistance(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDistance = 0;
        int rightMaxDistance = 0;
        if (root.left != null)
            leftMaxDistance = getMaxDistanceCore(root.left)+1;
        if (root.right != null)
            rightMaxDistance = getMaxDistanceCore(root.right)+1;
        return leftMaxDistance + rightMaxDistance;
    }

    private int getMaxDistanceCore(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDistance = 0;
        int rightMaxDistance = 0;
        if (root.left != null)
            leftMaxDistance = getMaxDistanceCore(root.left) + 1;
        if (root.right != null)
            rightMaxDistance = getMaxDistanceCore(root.right) + 1;
        return Math.max(leftMaxDistance, rightMaxDistance);
    }
}
