import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by 127-72 on 2016/8/10.
 */
public class SortAlgorithm {
    /*-----------------------------------------*/
    //快排
    public void quickSort(int[] array, int start, int end) {
        if (array == null || start >= end) return;
        int i = start;
        int j = end;
        int key = array[start];
        while (i < j) {
            while (array[i] <= key && i < j) {
                i++;
            }
            while (array[j] > key && i <= j) {
                j--;
            }
            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
        if (j != start) {
            array[j] = array[start] ^ array[j];
            array[start] = array[start] ^ array[j];
            array[j] = array[start] ^ array[j];
        }
        quickSort(array, start, j - 1);
        quickSort(array, j + 1, end);
        printSortedArray(array);

    }


    /*-----------------------------------------------------*/
    //归并排序
    public void mergeSort(int[] array, int beg, int end) {
        if (array == null) return;
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(array, beg, mid);
            mergeSort(array, mid + 1, end);
            mergeArray(array, beg, mid, end);
        }
        printSortedArray(array);
    }

    public void mergeArray(int[] array, int first, int mid, int end) {
        int i = first;
        int j = mid;
        int m = mid + 1;
        int n = end;
        int[] tempArray = new int[end - first + 1];
        int k = 0;
        while (i <= j && m <= n) {
            if (array[i] < array[m]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[m++];
            }
        }
        while (i <= j) {
            tempArray[k++] = array[i++];
        }
        while (m <= n) {
            tempArray[k++] = array[m++];
        }
        for (int p = first, q = 0; p <= end; p++, q++) {
            array[p] = tempArray[q];
        }

    }


    /*------------------------------------------------------*/



    /*public void heapSort(int[] array) {
        if (array == null || array.length <= 1) return;
        //build heap
        int[] heap = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            heap[i] = array[i];
            heapInsert(heap, i);
        }
        printFromSmallest(heap);
    }

    public void printFromSmallest(int[] heap) {
        int length = heap.length;
        for (int i = 0; i < length; i++) {
            System.out.print(heap[0] + " ");
            reheapify(heap, 0, length - i);
        }
    }

    private void reheapify(int[] heap, int index, int heapSize) {
        int temp = heap[heapSize - 1];
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (right < heapSize) {
                smallest = (heap[left] < heap[right] ? left : right);
            } else {
                smallest = left;
            }
            heap[index] = heap[smallest];
            index = smallest;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
        heap[index] = temp;
    }

    private void heapInsert(int[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[index] < heap[parent]) {
                swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }*/

    public void heapSort(int[] array) {
        if (array == null || array.length <= 1) return;
        buildMaxHeap(array, array.length);
        printSortedArray(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, 0, i);
        }
        printSortedArray(array);
    }

    private void buildMaxHeap(int[] array, int heapSize) {
        for (int i = (heapSize - 2) / 2; i >= 0; i--) {//i=(lastIndex-1)/2;
            maxHeapify(array, i, heapSize);
        }
    }

    private void maxHeapify(int[] array, int index, int heapSize) {
        int l = 2 * index + 1;
        int r = l + 1;
        int largest = index;
        if (l < heapSize && array[l] > array[largest]) largest = l;
        if (r < heapSize && array[r] > array[largest]) largest = r;
        if (largest != index) {
            swap(array, largest, index);
            maxHeapify(array, largest, heapSize);
        }
    }


    /**
     * ----------------------------------------
     */
    //冒泡排序
    public void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            // 记录某趟是否发生交换，若为false表示数组已处于有序状态
            boolean isSorted = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    isSorted = true;

                }
            }
            if (!isSorted) {
                // 若数组已处于有序状态，结束循环
                break;
            }
        }
    }

    /*
    *插入排序
     */
    public void insertSort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            if (array[i] < array[i - 1]) {
                int j = i - 1;
                // 整体后移一格
                while (j >= 0 && array[j] > temp) {
                    array[j + 1] = array[j];
                    j--;
                }
                // 最后将tmp插入合适的位置
                array[j + 1] = temp;

            }
        }
        printSortedArray(array);
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public void shellSort(int[] array) {
        if (array == null || array.length == 0) return;
        //计算最大h
        int h = 1;
        while (h <= array.length) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < array.length; i = i + h) {
                if (array[i] < array[i - h]) {
                    int temp = array[i];
                    int j = i - h;
                    while (j >= 0 && array[j] > temp) {
                        array[j + h] = array[j];
                        j = j - h;
                    }
                    array[j + h] = temp;
                    printSortedArray(array);
                }
            }
            //计算下一个h
            h = (h - 1) / 3;
        }
        printSortedArray(array);
    }

    /*
    * 选择排序
     */
    public void selectSort(int[] array) {
        if (array == null || array.length == 0) return;
        int index = -1;
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    index = j;
                    min = array[j];
                }
            }
            swap(array, i, index);
        }
        printSortedArray(array);
    }

    /*
    *二分排序(折半排序)
     */
    public void binarySort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (array[i] > array[mid]) {
                    low = mid + 1;
                } else if (array[i] < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid;
                    break;
                }
            }
            int temp = array[i];
            for (int k = i; k > low; k--) {
                array[k] = array[k - 1];
            }
            array[low] = temp;
        }
        printSortedArray(array);
    }

    /**
     * ---------------------------------------------
     * 桶排血
     */
    public void bucketSort(int[] array, int min, int max) {
        if (array == null || array.length == 0) return;
        int[] temp = new int[array.length];
        int[] buckets = new int[max - min];
        System.arraycopy(array, 0, temp, 0, array.length);
        for (int i = 0; i < array.length; i++) {
            buckets[array[i] - min]++;
        }
        for (int i = 1; i < max - min; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }

        for (int i = 0; i < array.length; i++) {

            array[--buckets[temp[i] - min]] = temp[i];
            /*int index=temp[i]-min;
            int curtimes=buckets[index];
            if(index==0){
                array[curtimes-1]=temp[i];
            }else if(curtimes-buckets[index-1]==1){
                array[curtimes-1]=temp[i];
            }else if(curtimes-buckets[index-1]>1){
                int count=curtimes-buckets[index-1];
                int start=curtimes-1;
                for(int k=count;k>=1;k--){
                    array[start]=temp[i];
                    start--;
                }
            }*/
        }
        printSortedArray(array);
    }


    public void swap(int[] array, int i, int j) {
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }


    public void printSortedArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

}
