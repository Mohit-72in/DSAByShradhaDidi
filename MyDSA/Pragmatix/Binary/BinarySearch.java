package MyDSA.Pragmatix.Binary;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        int lb = 0;
        int ub = arr.length - 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return -1;
    }
    public static int leftMost(int[] arr, int target, int lb, int ub) {
        if (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == target) {
                int index = leftMost(arr, target, lb, mid - 1);
                return index == -1 ? mid : index;
            } else if (arr[mid] > target) {
                return leftMost(arr, target, lb, mid - 1);
            } else {
                return leftMost(arr, target, mid + 1, ub);
            }
        }
        return -1;
    }
    public static int RightMost(int[] arr, int target, int lb, int ub) {
        if (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == target) {
                int index = RightMost(arr, target, mid+1, ub);
                return index == -1 ? mid : index;
            } else if (arr[mid] > target) {
                return RightMost(arr, target, lb, mid - 1);
            } else {
                return RightMost(arr, target, mid + 1, ub);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr  = {1,2,2,2,4,5,6};
        int target = 2;
        Arrays.sort(arr);
        int idx = leftMost(arr,target,0, arr.length-1);
        int rdx = RightMost(arr,target,0, arr.length-1);
        System.out.println(Arrays.toString(arr)+" in array "+target+" is at left idx :"+idx+" right idx: "+rdx);
    }
}
