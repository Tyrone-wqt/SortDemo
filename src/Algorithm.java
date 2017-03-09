import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;

/**
 * Created by lenovo on 2017/2/22.
 */
public class Algorithm {

    public static void main(String[] args){
        int[] testData=new int[]{9,4,3,2,5,4,3,2};
        Algorithm al=new Algorithm();
        //System.out.println(al.maxDescLength(testData));
        int[] testData1=new int[]{0,2,4,0,6};
        al.moveZeros(testData1);
    }

    public int maxDescLength(int[] array){
        if(array==null||array.length==0) return 0;
        int[] dp=new int[array.length];

        dp[0]=1;
        int maxLength=1;
        for(int i=1;i<array.length;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                if(array[j]>array[i]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            maxLength=maxLength<dp[i]?dp[i]:maxLength;
        }
        return maxLength;

    }

    public  void moveZeros(int[] array){
        printArray(array);
        int i=0,j=0;
        for(;i<array.length;i++){
            if(array[i]!=0){
                array[j]=array[i];
                j++;
            }
        }
        for(;j<array.length;j++){
            array[j]=0;
        }
        printArray(array);
    }
    private void printArray(int[] array){
        System.out.println();
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }
}
