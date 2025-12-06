package MyDSA.Pragmatix.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestHarmonicSubsequence {
    public int findSubArray(int[] arr) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hs.add(i);
        }
        Arrays.sort(arr);
        ArrayList<Integer> myArr = new ArrayList<>(hs);
        int maxLength = 0;

        for (int i : myArr) {
            if (search(arr, i + 1)) {
                int ri = rightMost(arr, i, 0, n - 1);
                int li = leftMost(arr, i, 0, n - 1);
                int r2 = rightMost(arr, i + 1, 0, n - 1);
                int l2 = leftMost(arr, i + 1, 0, n - 1);

                int countOfi = (ri == -1 || li == -1) ? 0 : (ri - li + 1);
                int countofi1 = (r2 == -1 || l2 == -1) ? 0 : (r2 - l2 + 1);

                maxLength = Math.max(maxLength, (countOfi + countofi1));
            }
        }
        return maxLength;
    }

    public int leftMost(int[] arr, int target, int lb, int ub) {
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

    public int rightMost(int[] arr, int target, int lb, int ub) {
        if (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == target) {
                int index = rightMost(arr, target, mid + 1, ub);
                return index == -1 ? mid : index;
            } else if (arr[mid] > target) {
                return rightMost(arr, target, lb, mid - 1);
            } else {
                return rightMost(arr, target, mid + 1, ub);
            }
        }
        return -1;
    }

    public boolean search(int[] arr, int target) {
        int lb = 0;
        int ub = arr.length - 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return false;
    }
}

class slove {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 2, 5, 2, 3, 7};
        LongestHarmonicSubsequence ob = new LongestHarmonicSubsequence();
        int val = ob.findSubArray(arr);
        System.out.println("LHS of " + Arrays.toString(arr) + " : " + val);
    }
}
