package MyDSA.Pragmatix.bitManipulation;

import java.util.Arrays;

public class MaxDiff {
    public static int maxDiff(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[n-1];
        int diff = max-arr[0];
        if(diff == 0){
            return -1;
        }

        int maxDif = max - diff ;
        return maxDif;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3};
        System.out.println("MaxDiffTarget is:"+maxDiff(arr));
    }

}
