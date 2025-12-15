package MyDSA.Heaps.Mislaneous;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3};
        heapSort(arr);

        System.out.println("Elements in Ascending order: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        // STEP 1: Build max heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // STEP 2: Swap root with last element & heapify
        for (int i = n - 1; i > 0; i--) {
            // swap arr[0] with arr[i]
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // heapify reduced heap
            heapify(arr, 0, i);
        }
    }

    // max-heap heapify
    private static void heapify(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;

        // check left child
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        // check right child
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        // if parent is not largest
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            // recursively heapify the affected subtree
            heapify(arr, max, n);
        }
    }
}
