package MyDSA.Pragmatix.TwoThreePointer;

import java.util.Arrays;
import java.util.Scanner;

public class LeftandRightSum {
    public void leftRightSum(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        leftSum(arr,left);
        rightSum(arr,right);
        CalCLeftRightSum(left,right,arr);
        System.out.println("Left Array is: "+ Arrays.toString(left));
        System.out.println("Right Array is: "+ Arrays.toString(right));
        System.out.println("Left and Right Sum of Array is: "+ Arrays.toString(arr));
    }
    public void leftSum(int[] arr,int[] left){
        int sum = 0;
        left[0] = sum;
        for(int i = 1;i<arr.length;i++){
            left[i] = left[i-1]+arr[i-1];
        }
    }
    public void rightSum(int[] arr,int[] right){
        int sum = 0;
        int n = arr.length;
        right[n-1] = sum;
        for(int i = n-2;i>=0;i--){
            right[i] = right[i+1]+arr[i+1];
        }
    }
    public void CalCLeftRightSum(int[] left,int[] right,int[] arr){
        for(int i = 0;i<arr.length;i++){
            arr[i] = left[i]+right[i];
        }
    }
}
class landRSum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Testcases: ");
        int t = sc.nextInt();
        while(t-->0) {
            System.out.print("Enter Length Of Array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            LeftandRightSum ob = new LeftandRightSum();
            ob.leftRightSum(arr);

        }
    }
}
