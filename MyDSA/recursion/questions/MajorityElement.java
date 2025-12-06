package MyDSA.recursion.questions;

public class MajorityElement {
    public static int majorityElement(int[] arr){
        int len = arr.length;
        int majority = arr[0];
        int count = 0;
        for(int i = 0;i<len;i++) {
            if (count == 0) majority = arr[i];
            count += arr[i] == majority ? 1 : -1;
        }
        count = 0;
        for(int x : arr){
            if (x == majority) count++;
        }
        return count>len/2?majority:-1;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,3,3,3,2,2,2,2};
        System.out.println(majorityElement(arr));
    }
}
