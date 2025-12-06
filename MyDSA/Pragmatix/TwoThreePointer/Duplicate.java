package MyDSA.Pragmatix.TwoThreePointer;

import java.util.Arrays;
import java.util.Scanner;

//Question: Remove duplicates from a sorted array in-place and return the new
//length.
//        Explanation: Use two pointers to overwrite duplicates by tracking the index of the
//last unique element.
//        Input: 0 0 1 1 1 2 3
//        output:4
public class Duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t>0){
            System.out.print("ENter size of arr: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(arr));
            Sol ob = new Sol();
            int unique = ob.findDuplicate(arr);
            System.out.println("Unique Element: "+unique);
            t--;
        }
    }

}
class Sol{
    public int findDuplicate(int[] arr){
        int i = 0,j=0,len = arr.length;

        for(j = 1;j<len;j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}
