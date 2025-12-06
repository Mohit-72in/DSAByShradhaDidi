package MyDSA.Pragmatix.TwoThreePointer;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayRight {
    public void RotateRight(int[] arr,int k){
        int n = arr.length;
        k = k%n;
        rotate(arr,0,n-k-1);
        rotate(arr,n-k,n-1);
        rotate(arr,0,n-1);

    }
    public void rotate(int[] arr,int left,int right){
        while(left<right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

}
class RotationToRight{
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
            System.out.print("Enter Number of Right rotation: ");
            int k = sc.nextInt();
            RotateArrayRight ob = new RotateArrayRight();
            ob.RotateRight(arr, k);
            System.out.println("Array After "+k+" times Right Rotation is: "+ Arrays.toString(arr));
        }
    }
}
