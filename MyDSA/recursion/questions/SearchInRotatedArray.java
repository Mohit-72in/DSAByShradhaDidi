package MyDSA.recursion.questions;

public class SearchInRotatedArray {
    public static int search(int[] arr,int tar,int si,int ei){
        //base condition
        if(si > ei) return -1;
        //Kaam
        int mid = si + (ei-si)/2;
        //found
        if(arr[mid] == tar){
            return mid;
        }

        // mid on l1
        if(arr[si] <= arr[mid]){
            //case a : Line left
            if(arr[si] <= tar && tar <= arr[mid] ){
                return search(arr,tar,si,mid-1);
            }else {  // case b: right of Line
                return search(arr,tar,mid+1,ei);
            }

        }
        // mid on line 2
        else {
            // case c : right of line
            if(arr[mid] <= tar && tar <= arr[ei]){
                return  search(arr,tar,mid+1,ei);
            }else{  // case d: left of line
                return search(arr,tar,si, mid-1);

            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int len = arr.length;
        int target = 9;
        int targetIdx = search(arr,target,0,len-1);
        System.out.println(targetIdx);
    }
}
