import sun.reflect.generics.tree.Tree;

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
        if (isRecursive) {
            searchInorder(root.left, isRecursive);
            visit(root);
            searchInorder(root.right, isRecursive);
        } else {
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
     * 得到二叉树的最大距离
     *
     * @param root
     * @return
     */
    public int getMaxDistance(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDistance = 0;
        int rightMaxDistance = 0;
        if (root.left != null)
            leftMaxDistance = getMaxDistanceCore(root.left) + 1;
        if (root.right != null)
            rightMaxDistance = getMaxDistanceCore(root.right) + 1;
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

    public TreeNode buildBinaryTree(int[] array) {
        TreeNode root = null;
        if (array == null || array.length == 0) return root;
        for (int i = 0; i < array.length; i++) {
            if (root == null) {
                root = new TreeNode(array[i]);
                continue;
            }
            int value = array[i];
            TreeNode node = root;
            while (node != null) {
                if (node.value > value) {
                    if (node.left != null) node = node.left;
                    else {
                        node.left = new TreeNode(value);
                        break;
                    }
                } else if (node.value < value) {
                    if (node.right != null) node = node.right;
                    else {
                        node.right = new TreeNode(value);
                        break;
                    }
                }
            }
        }
        return root;
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode node = root;

        if (key < node.value) {
            //以node的左孩子为搜索起点，返回删除节点后的子树的根节点
            node.left = deleteNode(node.left, key);
        } else if (key > node.value) {
            node.right = deleteNode(node.right, key);
        } else if (node.left != null && node.right != null) {
            TreeNode nextNode = findMin(node.right);
            node.value = nextNode.value;
            deleteNode(node, nextNode.value);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    public boolean deleteNodeNoRecur(TreeNode root,int key){
        //三种情况
        //1.是叶子节点，直接删除
        //2.只有左节点或只有右节点，将子节点作为父节点的新孩子
        //3.有两个孩子节点，取右孩子子树中的最小的节点的值替换到当前节点中，然后删除最小节点。
        TreeNode parent=null;
        TreeNode node=root;
        boolean isLeafChild=false;
        while (node!=null){
            if(key<node.value){
                parent=node;
                node=node.left;
                isLeafChild=true;
            }else if(key>node.value){
                parent=node;
                node=node.right;
                isLeafChild=false;
            }else{
                if(node.left==null&&node.right==null){
                    if(isLeafChild) parent.left=null;
                    else parent.right=null;

                }else if(node.left!=null&&node.right!=null){
                    node.value=findMin(node.right).value;
                    deleteNodeNoRecur(node.right,key);
                }else{
                    if(node.left!=null) {
                        if(isLeafChild) parent.left=node.left;
                        else parent.right=node.left;
                    }else{
                        if(isLeafChild) parent.left=node.right;
                        else parent.right=node.right;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public TreeNode findMin(TreeNode root) {
        TreeNode node=root;
        while(node.left!=null) node=node.left;
        return node;
    }
}
