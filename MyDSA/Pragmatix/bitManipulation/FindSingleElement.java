package MyDSA.Pragmatix.bitManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class FindSingleElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Num Of TestCases: ");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.print("Enter Size Of Array: ");
            int n = sc.nextInt();
            System.out.print("Enter Array Element: ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int unique = findUniqueXOR(arr);
            System.out.println("Unique Element in arr: " + Arrays.toString(arr) + " is " + unique);

        }
    }
    public static int findUniqueXOR(int[] arr){
        int unique = 0;
        for(int x : arr){
            unique ^= x;
        }
        return unique;
    }

}
