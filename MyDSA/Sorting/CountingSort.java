package MyDSA.Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr,int k){
        int len  = arr.length;
        int[] output = new int[len];//auxilary array
        int[] count = new int[k]; // storing frequency of all num's till 0 to k-1
        Arrays.fill(count,0);
        for(int i = 0;i<len;i++){ // count frequencies of all given array element
            count[arr[i]]++;
        }
        for(int i = 1;i<k;i++){ //prefix sum of count array
            count[i] += count[i-1];
        }
        for(int i = len-1;i>=0;i--){ //store element from backward in sorted manner
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for(int i =0;i<len;i++){ // copy sorted array back in original
            arr[i] = output[i];
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,1,4,0,2};
        countingSort(arr,5);
        for(int i : arr){
            System.out.print(i+" , ");
        }
        System.out.println();
    }
}
