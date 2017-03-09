/**
 * Created by lenovo on 2017/3/9.
 */
public class Main {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        //node1.right=node3;
        node2.left=node4;
        node2.right=node5;

        TreeAlgorithm ta=new TreeAlgorithm();
        System.out.print(ta.getMaxDistance(node1));
    }
}
