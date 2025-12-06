package MyDSA.Greedy;

import java.util.Arrays;

public class jumpGame1 {
    public static boolean canCross(int arr[]){
        int maxJump = 0;
        for(int i = 0;i<arr.length;i++){
            if(i>maxJump) return false;
            maxJump = Math.max(maxJump,i+arr[i]);
        }
        return true;
    }
    public static int minJump(int[] arr){ // arr must be crossable means no  element is 0
        int l = 0,r = 0;
        int n = arr.length;
        int jumps = 0;
        while (r<n-1){
            int farthest = 0;
            for(int i = l;i<=r;i++){
                farthest = Math.max(i+arr[i],farthest);
            }
            l = r+1;
            r = farthest;
            jumps++;

        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,4,1,1,1,2,0,2};
        int[] arr1 = {2,3,1,1,4,1,2,1,2};
        System.out.println("Can we cross the array: "+canCross(arr));
        System.out.println("Min Jumps required to cross the arr: "+ Arrays.toString(arr1)+" is "+minJump(arr1));

    }
}
