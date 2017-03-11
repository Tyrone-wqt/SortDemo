import java.util.Iterator;

/**
 * Created by lenovo on 2017/3/9.
 */
public class Main {
    public static void main(String[] args){
       /* TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        //node1.right=node3;
        node2.left=node4;
        node2.right=node5;

        TreeAlgorithm ta=new TreeAlgorithm();
        System.out.print(ta.getMaxDistance(node1));*/

       /* TreeAlgorithm ta=new TreeAlgorithm();
        int[] array=new int[]{5,7,4,3,9,2};
        TreeNode root=ta.buildBinaryTree(array);
        ta.searchInorder(root,true);
        System.out.println("-----------------");
        ta.deleteNodeNoRecur(root, 7);

        ta.searchInorder(root,true);*/

        /*int a=1;
        int b=2;
        Algorithm al=new Algorithm();

        Integer i1=new Integer(10);
        Integer i2=new Integer(20);
        al.swap(i1,i2);
        System.out.print(i1);
        System.out.print(i2);*/
       String s=new String("12");
     Algorithm al=new Algorithm();
     al.changeStringVaule(s);
     System.out.println(s);
    }
}
