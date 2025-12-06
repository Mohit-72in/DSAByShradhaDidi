package MyDSA.recursion.questions;

public class SearchInRotatedArray2 {
    public static  int search(int[] arr,int tar,int si,int ei){

        while(si<=ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == tar){
                return mid;
            }
            if(arr[si] <= arr[mid]){
                if(arr[si] <= tar && tar <= arr[mid]){
                    ei = mid-1;
                }else{
                    si = mid+1;
                }
            }else{
                if(arr[mid] <= tar && tar <= arr[ei]){
                    si = mid+1;
                }else {
                    ei = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int len = arr.length;
        int target = 6;
        int targetIdx = search(arr, target, 0, len - 1);
        System.out.println(targetIdx);
    }
}
