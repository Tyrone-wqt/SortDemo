/**
 * Created by 127-72 on 2016/8/10.
 */
public class SortTest {
    public static void main(String[] args){
        int[] input=new int[]{45 ,12 ,45 ,32, 5, 6};
        SortAlgorithm sortAlgorithm=new SortAlgorithm();
        //sortAlgorithm.quickSort(input,0,input.length-1);
        //sortAlgorithm.mergeSort(input,0,input.length-1);
        sortAlgorithm.heapSort(input);

    }
}
