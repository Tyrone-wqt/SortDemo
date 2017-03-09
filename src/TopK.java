/**
 * Created by lenovo on 2017/2/21.
 */
public class TopK {

    public static void main(String[] args){
        int[] data=new int[]{4,7,12,6,8,5,9,5,3};
        int k=5;
        TopK sample=new TopK();
        try {
            System.out.println(sample.topK(data,k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 求array中第k小的数 建立大根对
     * @param array
     * @param k
     * @return
     * @throws Exception
     */
    public int topK(int[] array,int k) throws Exception {
        if(k>array.length) throw new Exception("k is bigger than length");

        int[] heap=new int[k];
        for(int i=0;i<k;i++){
            heap[i]=array[i];
            heapInsert(heap,i);
        }
        for(int j=k;j<array.length;j++){
            if(array[j]>heap[0]){

            }else{
                reheapify(heap,array[j],k);
            }
        }
        return heap[k-1];
    }

    private void reheapify(int[] heap,int num,int heapSize) {
        //heap[index]=num;
        heap[0]=num;
        int index=0;
        int left=index*2+1;
        int right=index*2+2;
        int smallest=index;
        while(left<heapSize){
            if(right<heapSize){
                smallest=heap[right]>heap[left]?left:right;
            } else
                smallest=left;
            if(heap[index]<heap[smallest]){
                swap(heap,index,smallest);
            }else break;
            index=smallest;
            left=index*2+1;
            right=index*2+2;
        }
    }

    private void heapInsert(int[] heap,int index){
        if(index>heap.length) return;
        while(index!=0){
            int parent=(index-1)/2;
            if(heap[parent]<heap[index]){
                swap(heap,parent,index);
                index=parent;
            }else break;
        }
    }

    private void swap(int[] array,int i,int j){
        if(i!=j){
            array[i]=array[i]^array[j];
            array[j]=array[i]^array[j];
            array[i]=array[i]^array[j];
        }
    }


}
