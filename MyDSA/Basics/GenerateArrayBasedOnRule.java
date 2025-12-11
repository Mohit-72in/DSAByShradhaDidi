package MyDSA.Basics;

import java.util.Arrays;
import java.util.Scanner;
/*
arr[0] = 0
arr[1] = 1
arr[2*i] = arr[i] if 2<= 2*1 <=n
arr[2*i+1] = arr[i]+arr[i+1] if 2<= 2*1+1 <=n
 return max element from the array
*/

public class GenerateArrayBasedOnRule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of TestCase");
        int t = sc.nextInt();
        while (t-->0) {
            System.out.println("Enter Size Of array");
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = 1;
            int max = 0;
            for (int i = 1; (2 * i) + 1 <= n || (2 * i) <= n; i++) {
                arr[2 * i] = arr[i];
                max = Math.max(max, arr[(2 * i)]);
                if ((2 * i) + 1 <= n) {
                    arr[(2 * i) + 1] = arr[i] + arr[i + 1];
                    max = Math.max(max, arr[(2 * i) + 1]);
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("Max element is:"+max);
        }
    }
}
