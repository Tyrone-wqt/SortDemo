/**
 * Created by 127-72 on 2016/8/10.
 */
public class SortAlgorithm {
    /*-----------------------------------------*/
    //快排
    public void quickSort(int[] array,int start,int end){
        if(array==null||start>=end) return;
        int i=start;
        int j=end;
        int key=array[start];
        while(i<j){
            while(array[i]<=key&&i<j){
                i++;
            }
            while(array[j]>key&&i<=j){
                j--;
            }
            if(i<j){
                array[i]=array[i]^array[j];
                array[j]=array[i]^array[j];
                array[i]=array[i]^array[j];
            }
        }
        if(j!=start){
            array[j]=array[start]^array[j];
            array[start]=array[start]^array[j];
            array[j]=array[start]^array[j];
        }
        quickSort(array,start,j-1);
        quickSort(array,j+1,end);
        printSortedArray(array);
    }

    /*-----------------------------------------------------*/
    //归并排序
    public void mergeSort(int[] array,int beg,int end){
        if(array==null) return;
        if(beg<end){
            int mid=(beg+end)/2;
            mergeSort(array,beg,mid);
            mergeSort(array,mid+1,end);
            mergeArray(array,beg,mid,end);
        }
        printSortedArray(array);
    }

    public void mergeArray(int[] array,int first,int mid,int end){
        int i=first;
        int j=mid;
        int m=mid+1;
        int n=end;
        int[] tempArray=new int[end-first+1];
        int k=0;
        while(i<=j&&m<=n){
            if(array[i]<array[m]){
                tempArray[k++]=array[i++];
            }else{
                tempArray[k++]=array[m++];
            }
        }
        while(i<=j){
            tempArray[k++]=array[i++];
        }
        while (m<=n){
            tempArray[k++]=array[m++];
        }
        for(int p=first,q=0;p<=end;p++,q++){
            array[p]=tempArray[q];
        }

    }

    /*
   堆排序
     */
    /*------------------------------------------------------*/
    public void heapSort(int[] array){
        if(array==null||array.length<=1) return;
        //build heap
        int[] heap=new int[array.length];
        for(int i=0;i<array.length;i++){
            heap[i]=array[i];
            heapInsert(heap,i);
        }
        printFromSmallest(heap);
    }

    public void printFromSmallest(int[] heap){
        int length=heap.length;
        for(int i=0;i<length;i++){
            System.out.print(heap[0]+" ");
            reheapify(heap,0,length-i);
        }
    }

    private void reheapify(int[] heap,int index,int heapSize) {
        int temp=heap[heapSize-1];
        int left=index*2+1;
        int right=index*2+2;
        int smallest=index;
        while(left<heapSize){
            if(right<heapSize){
                smallest=(heap[left]<heap[right]?left:right);
            }else{
                smallest=left;
            }
            heap[index]=heap[smallest];
            index=smallest;
            left=2*index+1;
            right=2*index+2;
        }
        heap[index]=temp;
    }

    private void heapInsert(int[] heap,int index){
        while(index!=0){
            int parent=(index-1)/2;
            if(heap[index]<heap[parent]){
                swap(heap,index,parent);
                index=parent;
            }else{
                break;
            }
        }
    }

    public void swap(int[] array,int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }


    public void printSortedArray(int[] array) {
        System.out.println();
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

}
